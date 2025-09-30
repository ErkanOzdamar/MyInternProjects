import { useState, useRef, useEffect } from "react";
import { useNews } from '../context/NewsContext.jsx';
import "./News.css";

export default function News() {

  const { news } = useNews();
  
  const containerRef = useRef(null);
  const [activeIndex, setActiveIndex] = useState(0);
  const cardWidth = 450;
  const gap = 20;
  const transitionTime = 400; // geçiş süresi
  const autoplayInterval = 10000; // otomatik 10 saniye
  const [visibleCount, setVisibleCount] = useState(3);

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

  const extendedNews =
    visibleCount > 1
      ? [
          ...news.slice(-visibleCount),
          ...news,
          ...news.slice(0, visibleCount)
        ]
      : [...news];

  const offset = visibleCount > 1 ? visibleCount : 0;

  // Preload images
  useEffect(() => {
    news.forEach(n => {
      const img = new Image();
      img.src = n.img;
    });
  }, []);

  const updateTransform = (index, transition = true) => {
    if (transition) containerRef.current.style.transition = `transform ${transitionTime}ms ease`;
    else containerRef.current.style.transition = "none";
    containerRef.current.style.transform = `translate3d(-${index * (cardWidth + gap)}px,0,0)`;
  };

  const nextManual = () => setActiveIndex(prev => prev + 1);
  const prevManual = () => setActiveIndex(prev => prev - 1);

  useEffect(() => {
    updateTransform(activeIndex);

    if (visibleCount <= 1) return;

    if (activeIndex >= news.length + offset) {
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
        setActiveIndex(news.length - 1 + offset);
        updateTransform(news.length - 1 + offset, false);
        requestAnimationFrame(() => {
          containerRef.current.style.transition = `transform ${transitionTime}ms ease`;
        });
      });
    }
  }, [activeIndex, visibleCount]);

  const dragState = useRef({ startX: 0, isDragging: false, prevTranslate: 0 });

  const handleDragStart = (clientX) => {
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

  useEffect(() => {
    const interval = setInterval(() => {
      setActiveIndex(prev => prev + 1);
    }, autoplayInterval);
    return () => clearInterval(interval);
  }, []);

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
          style={{ transform: `translate3d(-${activeIndex * (cardWidth + gap)}px,0,0)` }}
        >
          {extendedNews.map((n, i) => (
            <div className="news-card" key={i}>
              <img src={n.img} alt={n.title} draggable={false} />
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
