import { useState, useRef, useEffect } from "react";
import "./Products.css";

export default function Products() {
  const products = [
    { id: 1, img: "/imagesProducts/products1.jpg", title: "Lorem", price: "standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing" },
    { id: 2, img: "/imagesProducts/products2.jpg", title: "Ipsum", price: " galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with d" },
    { id: 3, img: "/imagesProducts/products3.jpg", title: "Lorem", price: " galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with d" },
    { id: 4, img: "/imagesProducts/products4.jpg", title: "Ipsum", price: " galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with d" },
    { id: 5, img: "/imagesProducts/products5.jpg", title: "Lorem", price: " galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with d" },
    { id: 6, img: "/imagesProducts/products6.jpg", title: "Ipsum", price: " galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with d" }
  ];

  const containerRef = useRef(null);
  const [activeIndex, setActiveIndex] = useState(0);
  const cardWidth = 450;
  const gap = 20;
  const transitionTime = 400; // geçiş süresi
  const manualCooldown = 500; // manuel geçiş cooldown 0.5s
  const autoplayInterval = 10000; // otomatik 10 saniye

  const [visibleCount, setVisibleCount] = useState(3);
  const isManualTransitioning = useRef(false); // manuel için cooldown

  // Responsive
  useEffect(() => {
    const handleResize = () => {
      const width = window.innerWidth;
      if (width < 768) setVisibleCount(1);
      else if (width < 1024) setVisibleCount(2);
      else setVisibleCount(3);
    };
    handleResize();
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  const extendedProducts =
    visibleCount > 1
      ? [
          ...products.slice(-visibleCount),
          ...products,
          ...products.slice(0, visibleCount)
        ]
      : [...products];

  const offset = visibleCount > 1 ? visibleCount : 0;

  // Preload images
  useEffect(() => {
    products.forEach(p => {
      const img = new Image();
      img.src = p.img;
    });
  }, []);

  const updateTransform = (index, transition = true) => {
    if (transition) containerRef.current.style.transition = `transform ${transitionTime}ms ease`;
    else containerRef.current.style.transition = "none";
    containerRef.current.style.transform = `translate3d(-${index * (cardWidth + gap)}px,0,0)`;
  };

  // Manual Next / Prev
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

  // Active index effect
  useEffect(() => {
    updateTransform(activeIndex);

    if (visibleCount <= 1) return;

    if (activeIndex >= products.length + offset) {
      requestAnimationFrame(() => {
        containerRef.current.style.transition = "none";
        setActiveIndex(offset);
        updateTransform(offset, false);
        requestAnimationFrame(() => {
          containerRef.current.style.transition = `transform ${transitionTime}ms ease`;
        });
      });
    }

    if (activeIndex < 0) {
      requestAnimationFrame(() => {
        containerRef.current.style.transition = "none";
        setActiveIndex(products.length - 1 + offset);
        updateTransform(products.length - 1 + offset, false);
        requestAnimationFrame(() => {
          containerRef.current.style.transition = `transform ${transitionTime}ms ease`;
        });
      });
    }
  }, [activeIndex, visibleCount]);

  // Drag / Touch
  const dragState = useRef({ startX: 0, isDragging: false, prevTranslate: 0 });

  const handleDragStart = (clientX) => {
    if (isManualTransitioning.current) return;
    dragState.current.isDragging = true;
    dragState.current.startX = clientX;
    dragState.current.prevTranslate = -activeIndex * (cardWidth + gap);
    containerRef.current.style.transition = "none";
  };

  const handleDragMove = (clientX) => {
    if (!dragState.current.isDragging) return;
    const diff = clientX - dragState.current.startX;
    containerRef.current.style.transform = `translate3d(${dragState.current.prevTranslate + diff}px,0,0)`;
  };

  const handleDragEnd = (clientX) => {
    if (!dragState.current.isDragging) return;
    dragState.current.isDragging = false;
    containerRef.current.style.transition = `transform ${transitionTime}ms ease`;

    const diff = clientX - dragState.current.startX;
    if (diff < -50) nextManual();
    else if (diff > 50) prevManual();
    else updateTransform(activeIndex);
  };

  // 🔹 Autoplay 10 saniye, manuel cooldown ayrı
  useEffect(() => {
    const interval = setInterval(() => {
      setActiveIndex(prev => prev + 1); // autoplay kendi bekleme süresiyle
    }, autoplayInterval);
    return () => clearInterval(interval);
  }, []);

return (
  <div className="productsSlider-wrapper">
    <h2 className="products-title">Ürünler</h2>
    <div className="productsSlider-inner">
      <button className="procNav-btn left" onClick={prevManual}>{"<"}</button>
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
          style={{ transform: `translate3d(-${activeIndex * (cardWidth + gap)}px,0,0)` }}
        >
          {extendedProducts.map((product, i) => (
            <div className="product-card" key={i}>
              <img src={product.img} alt={product.title} draggable={false} />
              <div className="product-info">
                <h3>{product.title}</h3>
                <p>{product.price}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
      <button className="procNav-btn right" onClick={nextManual}>{">"}</button>
    </div>
  </div>
);



}

