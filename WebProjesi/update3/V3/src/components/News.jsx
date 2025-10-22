import { useState, useRef, useEffect, useCallback } from "react"; 
import { useNews } from '../context/NewsContext.jsx';
import "./News.css";

export default function News() {

  const { news } = useNews();
  
  const containerRef = useRef(null);
  const [activeIndex, setActiveIndex] = useState(0);


  const isJumping = useRef(false);
  const isManualTransitioning = useRef(false);


  const [cardWidth, setCardWidth] = useState(500); 
  const [gap, setGap] = useState(25);

  
  const [visibleCount, setVisibleCount] = useState(3);
  const transitionTime = 400; 
  const autoplayInterval = 10000; 
  const manualCooldown = 500; 

  useEffect(() => {
    const handleResize = () => {
 
      if (!containerRef.current || !news || news.length === 0) return;
      const styles = getComputedStyle(containerRef.current);
      const newCardWidth = parseFloat(styles.getPropertyValue('--card-width'));
      const newGap = parseFloat(styles.getPropertyValue('--card-gap'));
      
      setCardWidth(newCardWidth);
      setGap(newGap);
   

      const width = window.innerWidth;
      if (width < 768) setVisibleCount(1);
      else if (width < 1024) setVisibleCount(2);
      else setVisibleCount(3);
    };
    handleResize();
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, [news]); 

  const extendedNews =
    visibleCount > 1 && news.length > 0
      ? [
          ...news.slice(-visibleCount),
          ...news,
          ...news.slice(0, visibleCount)
        ]
      : [...news];

  const offset = visibleCount > 1 ? visibleCount : 0;


  useEffect(() => {
     if (offset > 0 && news.length > 0) {
       setActiveIndex(offset);
     }
  }, [offset, news]);


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
    if (!news || news.length === 0 || !containerRef.current) return;


    if (visibleCount <= 1) {
      let effectiveIndex = activeIndex;
      let jumpHappened = false;

      if (activeIndex >= news.length) {
        effectiveIndex = 0; 
        jumpHappened = true;
      } 
      else if (activeIndex < 0) {
        effectiveIndex = news.length - 1; 
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

      if (activeIndex >= news.length + offset) {
        newIndex = offset; 
        needsJump = true;
      } else if (activeIndex < offset) {
        newIndex = (news.length - 1) + offset; 
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

  }, [activeIndex, news, offset, visibleCount, updateTransform]);

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

  useEffect(() => {
    const interval = setInterval(() => {
      if (!dragState.current.isDragging) {
        setActiveIndex(prev => prev + 1); 
      }
    }, autoplayInterval);
    return () => clearInterval(interval);
  }, [autoplayInterval]); 

return (
  <div className="newsSlider-wrapper">
    <h2 className="news-title">Haberler</h2>
    <div className="newsSlider-inner">
      <button className="newNav-btn left" onClick={prevManual}><i className="fas fa-chevron-left"></i></button>
      <div
        className="news-wrapper"
        onTouchStart={(e) => handleDragStart(e.touches[0].clientX)}
        onTouchMove={(e) => handleDragMove(e.touches[0].clientX)}
        onTouchEnd={(e) => handleDragEnd(e.changedTouches[0].clientX)}
        onMouseDown={(e) => handleDragStart(e.clientX)}
        onMouseMove={(e) => handleDragMove(e.clientX)}
        onMouseUp={(e) => handleDragEnd(e.clientX)}
        onMouseLeave={() => { handleDragEnd(dragState.current.startX); }}
      >
        <div
          className="news-container"
          ref={containerRef}

        >
          {extendedNews.map((n, i) => (
            <div className="news-card" key={i}>
              <img 
                src={n.img} 
                alt={n.title} 
                draggable={false}
                loading="lazy" 
              />
              <div className="news-info">
                <h3>{n.title}</h3>
                <p>{n.price}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
      <button className="newNav-btn right" onClick={nextManual}><i className="fas fa-chevron-right"></i></button>
    </div>
  </div>
);
}