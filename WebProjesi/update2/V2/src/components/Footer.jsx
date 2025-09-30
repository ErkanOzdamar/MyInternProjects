import HeroCircle from "./HeroCircle";
import { Link } from "react-router-dom";
import "./Footer.css";

export default function Footer() {
  return (
    <footer className="footer">
      {/* Üst kısım: 5 konteyner */}
      <div className="footer-top">

        <div className="footer-container hero">
          <HeroCircle />
        </div>

        <div className="footer-container address">
          <h4>Adres</h4>
          <p>Çankaya/Ankara</p>
          <p>Kızılay Mah. İzmir 1 Cad. No:20/22</p>
        </div>

        <div className="footer-container contact">
          <h4>İletişim</h4>
          <p>Tel: +90 123 456 78 90</p>
          <p>Email: info@futroniks.com</p>
        </div>

        <div className="footer-container sitemap">
          <h4>Sayfalar</h4>
          <ul>
            <li><Link to="/">Ana Sayfa</Link></li>
            <li><Link to="/urunlerimiz">Ürünlerimiz</Link></li>
            <li><Link to="/ozel-talep">Özel Talep</Link></li>
            <li><Link to="/iletisim">İletişim</Link></li>
          </ul>
        </div>

        

        
        <div className="footer-container map">
          <iframe
            title="Google Map"
            src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d10119.756678809757!2d32.853091!3d39.922777!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14d34efff0e6e747%3A0x9cd776585816f3a2!2zS8SxesSxbGF5LCDEsHptaXItMSBDZC4gTm86MjAgRDoyMiwgMDY0MjAgw4dhbmtheWEvQW5rYXJh!5e1!3m2!1str!2str!4v1759136855288!5m2!1str!2str"
            width="100%"
            height="200"
            style={{ border: 0 }}
            allowFullScreen
            loading="lazy"
            referrerPolicy="no-referrer-when-downgrade"
          ></iframe>
        </div>

      </div>

      {/* Alt kısım: telif ve sosyal medya */}
      <div className="footer-bottom">
        <p>© 2025 Futroniks. All rights reserved.</p>
        <div className="social-icons">
          <a href="#"><i className="fab fa-facebook-f"></i></a>
          <a href="#"><i className="fab fa-twitter"></i></a>
          <a href="#"><i className="fab fa-linkedin-in"></i></a>
        </div>
      </div>
    </footer>
  );
}

