import { useState } from 'react';
import { useLocation, Link } from 'react-router-dom';
import './Iletisim.css';

export default function Iletisim() {
  const location = useLocation();
  const initialMesaj = location.state?.mesaj || '';

  const [formData, setFormData] = useState({
    mesaj: initialMesaj,
    isim: '',
    email: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    alert('Mesajınız hazır!');
    setFormData({ mesaj: '', isim: '', email: '' });
  };

  return (
    <div className="iletisim-page">


      <div className="iletisim-breadcrumb">
        <Link to="/" className="iletisim-breadcrumb-home">Anasayfa</Link>
        <i className="fa-solid fa-chevron-right iletisim-breadcrumb-separator"></i>
        <span className="iletisim-breadcrumb-current">İletişim</span>
      </div>
      

      <div className="iletisim-banner">
        <img src="/iletisimB.png" alt="Second Banner" />
      </div>

  
      <div className="iletisim-form-container">

        <div className="iletisim-left">
          <div className="iletisim-kunye-container address">
            <h4>Adres</h4>
            <p>Çankaya/Ankara</p>
            <p>Cevizlidere, 1236. Sk. Zorlu Apt No:2/16</p>
          </div>

          <div className="iletisim-kunye-container contact">
            <h4>İletişim</h4>
            <p><i className="fa-solid fa-mobile-screen"></i> +90 506 122 67 89</p>
            <p><i className="fa-solid fa-phone"></i> +90 312 473 23 51</p>
            <p><i className="fa-regular fa-envelope"></i> fatih.akgul@futroniks.com</p>
          </div>

          <div className="iletisim-map">
            <h3 className="map-title1">
              Bize Ulaşın
              <span className="map-title2">08:00 - 18:00 arası açığız.</span>
            </h3>
            <iframe 
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2531.1758129246664!2d32.818877!3d39.88929710000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14d345fc10b03cf3%3A0x869c5abbc85fa3aa!2zRlVUUk9OxLBLUyBCxLBMxLDFnsSwTSBURUtOT0xPSsSwIFlBWklMSU0gU0FOLiBUxLBDLiBMVEQuIMWeVMSwLg!5e1!3m2!1str!2str!4v1759946598181!5m2!1str!2str"  
            allowFullScreen="" 
            loading="lazy" 
            referrerPolicy="no-referrer-when-downgrade">
            </iframe>
          </div>
        </div>


        <div className="iletisim-right">
          <form onSubmit={handleSubmit}>
            <textarea
              name="mesaj"
              placeholder="Mesajınız..."
              value={formData.mesaj}
              onChange={handleChange}
            />
            <div className="iletisim-input-row">
              <input
                type="text"
                name="isim"
                placeholder="İsim Soyisim"
                value={formData.isim}
                onChange={handleChange}
              />
              <input
                type="email"
                name="email"
                placeholder="E-posta"
                value={formData.email}
                onChange={handleChange}
              />
            </div>
            <button type="submit">Gönder</button>
          </form>
        </div>
      </div>

      <div className="iletisim-video-container">
        <video 
          src="/video1.mp4" 
          autoPlay                  
          loop                      
          muted                     
          playsInline               
          className="iletisim-video"
        >
        </video>
        <div className="iletisim-video-overlay">
          <div className="iletisim-video-content">
            <h2>İhtiyacınıza en uygun elektronik sistemleri tasarlamak ve süreçlerinizi daha verimli hale getirmek için bizimle iletişime geçin.</h2>
          </div>
        </div>
      </div>
      
    </div>
  );
}
