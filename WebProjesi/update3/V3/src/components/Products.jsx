import { useState, useRef, useEffect, useCallback } from "react"; 
import { useProducts } from '../context/ProductsContext.jsx';
import "./Products.css";

export default function Products() {
  

  const { products } = useProducts();


  const containerRef = useRef(null);
  const [activeIndex, setActiveIndex] = useState(0);

  const isJumping = useRef(false);

  const [cardWidth, setCardWidth] = useState(400); 
  const [gap, setGap] = useState(100);
  const [visibleCount, setVisibleCount] = useState(3);

  const transitionTime = 400; 
  const manualCooldown = 500; 
  const autoplayInterval = 10000; 

  const isManualTransitioning = useRef(false);

 
  useEffect(() => {
    const handleResize = () => {
      if (!containerRef.current || !products || products.length === 0) return;
      const styles = getComputedStyle(containerRef.current);
      const newCardWidth = parseFloat(styles.getPropertyValue('--card-width'));
      const newGap = parseFloat(styles.getPropertyValue('--card-gap'));
      
      setCardWidth(newCardWidth);
      setGap(newGap);
      
      const width = window.innerWidth;
      let newVisibleCount;
      if (width < 768) newVisibleCount = 1;
      else if (width < 1024) newVisibleCount = 2;
      else newVisibleCount = 3;
      
      setVisibleCount(newVisibleCount);
    };
    handleResize();
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, [products]);

  const offset = visibleCount > 1 ? visibleCount : 0;
  
  const extendedProducts =
    visibleCount > 1 && products.length > 0
      ? [
          ...products.slice(-visibleCount),
          ...products,
          ...products.slice(0, visibleCount)
        ]
      : [...products];

  useEffect(() => {
     if (offset > 0 && products.length > 0) {
       setActiveIndex(offset);
     }
  }, [offset, products]);

  const updateTransform = useCallback((index, transition = true) => {
    if (!containerRef.current) return;
    if (transition) containerRef.current.style.transition = `transform ${transitionTime}ms ease`;
    else containerRef.current.style.transition = "none";
    
    containerRef.current.style.transform = `translate3d(-${index * (cardWidth + gap)}px,0,0)`;
  }, [cardWidth, gap, transitionTime]); 


  const nextManual = () => {
    if (isManualTransitioning.current) return;
    isManualTransitioning.current = true;
    setActiveIndex(prev => prev + 1);
    setTimeout(() => (isManualTransitioning.current = false), manualCooldown);
  };

  const prevManual = () => {
    if (isManualTransitioning.current) return;
    isManualTransitioning.current = true;
    setActiveIndex(prev => prev - 1);
    setTimeout(() => (isManualTransitioning.current = false), manualCooldown);
  };

  useEffect(() => {
    if (!products || products.length === 0 || !containerRef.current) return;

    if (visibleCount <= 1) {
      let effectiveIndex = activeIndex;
      let jumpHappened = false;

      if (activeIndex >= products.length) {
        effectiveIndex = 0; 
        jumpHappened = true;
      } 
      else if (activeIndex < 0) {
        effectiveIndex = products.length - 1; 
        jumpHappened = true;
      }

      if (jumpHappened) {
        isJumping.current = true; 
        setActiveIndex(effectiveIndex); 
        return; 
      }
    }

    updateTransform(activeIndex, !isJumping.current);

    if (isJumping.current) {
      isJumping.current = false;
    }

    const handleTransitionEnd = () => {
      if (visibleCount <= 1) return; 

      let newIndex = activeIndex;
      let needsJump = false; 

      if (activeIndex >= products.length + offset) {
        newIndex = offset; 
        needsJump = true;
      } else if (activeIndex < offset) {
        newIndex = (products.length - 1) + offset; 
        needsJump = true;
      }
      
      if (needsJump) {
        isJumping.current = true; 
        setActiveIndex(newIndex); 
      }
    };
    
    const container = containerRef.current;
    container.addEventListener('transitionend', handleTransitionEnd);

    return () => {
      container.removeEventListener('transitionend', handleTransitionEnd);
    };

  }, [activeIndex, products, offset, visibleCount, updateTransform]);


  // Drag / Touch (Değişiklik yok)
  const dragState = useRef({ startX: 0, isDragging: false, prevTranslate: 0 });

  const handleDragStart = (clientX) => {
    if (isManualTransitioning.current) return;
    dragState.current.isDragging = true;
    dragState.current.startX = clientX;
    dragState.current.prevTranslate = -activeIndex * (cardWidth + gap);
    if (containerRef.current) containerRef.current.style.transition = "none";
  };

  const handleDragMove = (clientX) => {
    if (!dragState.current.isDragging || !containerRef.current) return;
    const diff = clientX - dragState.current.startX;
    containerRef.current.style.transform = `translate3d(${dragState.current.prevTranslate + diff}px,0,0)`;
  };

  const handleDragEnd = (clientX) => {
    if (!dragState.current.isDragging) return;
    dragState.current.isDragging = false;
    if (containerRef.current) containerRef.current.style.transition = `transform ${transitionTime}ms ease`;

    const diff = clientX - dragState.current.startX;
    if (diff < -50) nextManual();
    else if (diff > 50) prevManual();
    else updateTransform(activeIndex); 
  };

  // Autoplay (Değişiklik yok)
  useEffect(() => {
    const interval = setInterval(() => {
      if (!dragState.current.isDragging) {
        setActiveIndex(prev => prev + 1); 
      }
    }, autoplayInterval);
    return () => clearInterval(interval);
  }, [autoplayInterval]); 

return (
  <div className="productsSlider-wrapper">
    <h2 className="products-title">ÜRÜNLERİMİZ</h2>
    <div className="productsSlider-inner">
      <button className="procNav-btn left" onClick={prevManual}><i className="fas fa-chevron-left"></i></button>
      <div
        className="products-wrapper"
        onTouchStart={(e) => handleDragStart(e.touches[0].clientX)}
        onTouchMove={(e) => handleDragMove(e.touches[0].clientX)}
        onTouchEnd={(e) => handleDragEnd(e.changedTouches[0].clientX)}
        onMouseDown={(e) => handleDragStart(e.clientX)}
        onMouseMove={(e) => handleDragMove(e.clientX)}
        onMouseUp={(e) => handleDragEnd(e.clientX)}
        onMouseLeave={() => { handleDragEnd(dragState.current.startX); }}
      >
        <div
          className="products-container"
          ref={containerRef}
        >
          {extendedProducts.map((product, i) => (
            <div className="product-card" key={i}>
              <img 
                src={product.img} 
                alt={product.title} 
                draggable={false}
                loading="lazy" /* <-- 50 resim için kritik olan Tembel Yükleme */
              />
              <div className="product-info">
                <h3>{product.title}</h3>
                <p className="product-price">{product.price}</p>
                <p>{product.detail}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
      <button className="procNav-btn right" onClick={nextManual}><i className="fas fa-chevron-right"></i></button>
    </div>
  </div>
);
}