import "./Banner.css";
import { useBanner } from '../context/BannerContext.jsx';
import { useState, useEffect, useRef } from "react";

export default function Banner() {
  const { banners } = useBanner();
  const [activeIndex, setActiveIndex] = useState(0);
  const [progress, setProgress] = useState(0);

  const intervalRef = useRef(null);
  const startRef = useRef(null);
  const touchStartRef = useRef(null);
  const dragStartRef = useRef(null);
  const draggingRef = useRef(false);

  const DURATION = 10000; // 10s
  const TICK = 100;       // 100ms update

  useEffect(() => {
    if (!banners || banners.length === 0) return;
    setActiveIndex(0);
    restartTimer();
    return () => clearInterval(intervalRef.current);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [banners]);

  function restartTimer() {
    clearInterval(intervalRef.current);

    if (!banners || banners.length <= 1) {
      setProgress(100);
      return;
    }

    startRef.current = Date.now();
    setProgress(0);

    intervalRef.current = setInterval(() => {
      const elapsed = Date.now() - startRef.current;
      const pct = Math.min((elapsed / DURATION) * 100, 100);
      setProgress(pct);

      if (pct >= 100) {
        setActiveIndex(prev => (prev + 1) % banners.length);
        startRef.current = Date.now();
        setProgress(0);
      }
    }, TICK);
  }

  function goToIndex(index) {
    setActiveIndex(index);
    restartTimer(); // manuel müdahalede timer sıfırlansın
  }

  // Touch handlers
  const onTouchStart = (e) => { touchStartRef.current = e.touches[0].clientX; };
  const onTouchEnd = (e) => {
    if (touchStartRef.current === null) return;
    const diff = touchStartRef.current - e.changedTouches[0].clientX;
    if (diff > 50) goToIndex((activeIndex + 1) % banners.length);
    else if (diff < -50) goToIndex((activeIndex - 1 + banners.length) % banners.length);
    touchStartRef.current = null;
  };

  // Mouse drag handlers
  const onMouseDown = (e) => { dragStartRef.current = e.clientX; draggingRef.current = true; };
  const onMouseUp = (e) => {
    if (!draggingRef.current || dragStartRef.current === null) { draggingRef.current = false; dragStartRef.current = null; return; }
    const diff = dragStartRef.current - e.clientX;
    if (diff > 50) goToIndex((activeIndex + 1) % banners.length);
    else if (diff < -50) goToIndex((activeIndex - 1 + banners.length) % banners.length);
    draggingRef.current = false; dragStartRef.current = null;
  };
  const onMouseLeave = () => { draggingRef.current = false; dragStartRef.current = null; };

  return (
    <div className="banner-wrapper">
      <div
        className="banner-container"
        onTouchStart={onTouchStart}
        onTouchEnd={onTouchEnd}
        onMouseDown={onMouseDown}
        onMouseMove={() => {}}
        onMouseUp={onMouseUp}
        onMouseLeave={onMouseLeave}
      >
        {banners.map((banner, index) => (
          <img
            key={banner.id ?? index}
            src={banner.img}
            alt={`Banner ${index + 1}`}
            className={index === activeIndex ? "active" : ""}
            draggable={false}
          />
        ))}
      </div>

      <div className="progress-container">
        {banners.map((banner, index) => (
          <div
            key={(banner.id ?? index) + "-pb"}
            className={index === activeIndex ? "progress-bar active" : "progress-bar"}
            onClick={() => goToIndex(index)}
          >
            <div
              className="fill"
              style={{ width: index === activeIndex ? `${progress}%` : "0%" }}
            />
          </div>
        ))}
      </div>
    </div>
  );
}
