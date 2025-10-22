import { useState, useEffect } from "react";
import './ScrollTop.css'; 

export default function ScrollTop() {
  const [show, setShow] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      setShow(window.pageYOffset > 300); // 300px’den sonra göster
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  const scrollToTop = () => {
    window.scrollTo({ top: 0, behavior: "smooth" });
  };

  if (!show) return null;

  return (
    <button className="scroll-top-btn" onClick={scrollToTop} aria-label="Scroll to top">
      <i className="fa-solid fa-chevron-up"></i>
    </button>
  );
}