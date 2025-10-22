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
          <p>Cevizlidere, 1236. Sk. Zorlu Apt No:2/16</p>
        </div>

        <div className="footer-container contact">
          <h4>İletişim</h4>
            <p><i className="fa-solid fa-mobile-screen"></i> +90 506 122 67 89</p>
            <p><i className="fa-solid fa-phone"></i> +90 312 473 23 51</p>
            <p><i className="fa-regular fa-envelope"></i> fatih.akgul@futroniks.com</p>
        </div>

        <div className="footer-container sitemap">
          <h4>Sayfalar</h4>
          <ul>
            <li><Link to="/">Ana Sayfa</Link></li>
            <li><Link to="/ozel-talep">Özel Talep</Link></li>
            <li><Link to="/iletisim">İletişim</Link></li>
          </ul>
        </div>

        

        
        <div className="footer-container map">
            <iframe 
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2531.1758129246664!2d32.818877!3d39.88929710000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14d345fc10b03cf3%3A0x869c5abbc85fa3aa!2zRlVUUk9OxLBLUyBCxLBMxLDFnsSwTSBURUtOT0xPSsSwIFlBWklMSU0gU0FOLiBUxLBDLiBMVEQuIMWeVMSwLg!5e1!3m2!1str!2str!4v1759946598181!5m2!1str!2str"  
            allowFullScreen="" 
            loading="lazy"
            style={{ border: 0 }}
            width="100%"
            height="200" 
            referrerPolicy="no-referrer-when-downgrade">
            </iframe>
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

