import { useState, useEffect, useRef } from "react";
import { useReferences } from '../context/ReferencesContext.jsx';
import "./References.css";

export default function Reference() {

  const { logos } = useReferences();

  const containerRef = useRef(null);
  const [isPaused, setIsPaused] = useState(false);

  // Animasyon gerekli mi? (4 logodan fazla ise)
  const shouldAnimate = logos.length > 4;

  // Logoları kopyalayarak sürekli döngü efekti oluştur, eğer animasyon aktifse
  const duplicatedLogos = shouldAnimate ? [...logos, ...logos] : logos;

  useEffect(() => {
    if (isPaused || !shouldAnimate) return;
    
    const container = containerRef.current;
    if (!container) return;
    
    let animationId;
    let position = 0;
    
    const animate = () => {
      position -= 1; // Kaydırma hızı
      
      if (-position >= container.scrollWidth / 2) {
        position = 0;
      }
      
      container.style.transform = `translateX(${position}px)`;
      animationId = requestAnimationFrame(animate);
    };
    
    animationId = requestAnimationFrame(animate);
    
    return () => cancelAnimationFrame(animationId);
  }, [isPaused, shouldAnimate]);

  return (
    <div className="logosSlider-wrapper">
      <h2 className="logos-title">REFERANSLARIMIZ</h2>
      <div className="logos-container-wrapper">
        <div 
          className="logos-container" 
          ref={containerRef}
          style={{ justifyContent: shouldAnimate ? 'flex-start' : 'center' }}
        >
          {duplicatedLogos.map((logo, index) => (
            <div className="logo-item" key={`${logo.id}-${index}`}>
              <img 
                src={logo.img} 
                alt={logo.name} 
                draggable={false}
              />
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}


