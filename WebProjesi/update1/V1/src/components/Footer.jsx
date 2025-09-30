import HeroCircle from "./HeroCircle";
import "./Footer.css";

export default function Footer() {
  return (
    <footer className="footer">
      {/* Sol: Logo */}
      <div className="footer-left">
        <HeroCircle />
      </div>

      {/* Ortada: İçerik */}
      <div className="footer-center">
        <p>© 2025 Futroniks. All rights reserved.</p>
        <div className="social-icons">
          <a href="#"><i className="fab fa-facebook-f"></i></a>
          <a href="#"><i className="fab fa-twitter"></i></a>
          <a href="#"><i className="fab fa-linkedin-in"></i></a>
        </div>
      </div>

      {/* Sağ: Dönen HeroCircle */}
      <div className="footer-right">

      </div>
    </footer>
  );
}
