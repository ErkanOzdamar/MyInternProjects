import "./Banner.css";
import { useBanner } from '../context/BannerContext.jsx';
import { useState, useEffect } from "react";

export default function Banner() {

  const { banners } = useBanner();
  const [activeIndex, setActiveIndex] = useState(0);
  
  //swipe state
  const [touchStart, setTouchStart] = useState(null);
  const [dragStart, setDragStart] = useState(null);
  const [dragging, setDragging] = useState(false);


  // Otomatik slider geçişi
  useEffect(() => {
    if (banners.length === 0) return;

    const interval = setInterval(() => {
      setActiveIndex(prevIndex =>
        prevIndex === banners.length - 1 ? 0 : prevIndex + 1
      );
    }, 10000); // 10 saniyede bir geçiş

    return () => clearInterval(interval);
  }, [banners]);

  return (
    <div className="banner-wrapper">
      {/* Banner container */}
      <div
        className="banner-container"
        
        // Mobil touch
        onTouchStart={(e) => setTouchStart(e.touches[0].clientX)}
        onTouchEnd={(e) => {
          if (touchStart === null) return;
          const diff = touchStart - e.changedTouches[0].clientX;
          if (diff > 50) setActiveIndex(prev => (prev + 1) % banners.length);
          else if (diff < -50) setActiveIndex(prev => (prev - 1 + banners.length) % banners.length);
          setTouchStart(null);
        }}

        // Desktop mouse drag
        onMouseDown={(e) => { setDragStart(e.clientX); setDragging(true); }}
        onMouseMove={(e) => { if (!dragging) return; }}
        onMouseUp={(e) => {
          if (!dragging || dragStart === null) return;
          const diff = dragStart - e.clientX;
          if (diff > 50) setActiveIndex(prev => (prev + 1) % banners.length);
          else if (diff < -50) setActiveIndex(prev => (prev - 1 + banners.length) % banners.length);
          setDragStart(null);
          setDragging(false);
        }}
        onMouseLeave={() => { setDragStart(null); setDragging(false); }}
      >
        {banners.map((banner, index) => (
          <img
            key={banner.id}
            src={banner.img}
            alt={`Banner ${index + 1}`}
            className={index === activeIndex ? "active" : ""}
            draggable={false} // sürükleme/copy engelleme
          />
        ))}
        {banners.map((banner, index) => (
          <img
            key={banner.id}
            src={banner.img}
            alt={`Banner ${index + 1}`}
            className={index === activeIndex ? "active" : ""}
            draggable={false}
          />
        ))}
      </div>
      {/* Progress bar */}
      <div className="progress-container">
        {banners.map((banner, index) => (
          <div
            key={banner.id}
            className={index === activeIndex ? "progress-bar active" : "progress-bar"}
            onClick={() => setActiveIndex(index)}
          >
            <div className="fill"></div>
          </div>
        ))}
      </div>
    </div>
  );
}