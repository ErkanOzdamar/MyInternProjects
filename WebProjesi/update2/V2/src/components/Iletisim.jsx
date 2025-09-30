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

    
      {/* 1️⃣ Breadcrump */}
      <div className="iletisim-breadcrumb">
        <Link to="/" className="iletisim-breadcrumb-home">Anasayfa</Link>
        <i className="fa-solid fa-chevron-right iletisim-breadcrumb-separator"></i>
        <span className="iletisim-breadcrumb-current">İletişim</span>
      </div>
      
      {/* 2️⃣ Banner */}
      <div className="iletisim-banner">
        <img src="/iletisimB.png" alt="Second Banner" />
      </div>

      {/* 4️⃣ İletişim Formu ve Sol Açıklama */}
      <div className="iletisim-form-container">
        <div className="iletisim-left">
          <p>Bizimle iletişime geçmek için formu doldurabilirsiniz.</p>
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

      {/* 3️⃣ Künye / Biz Kimiz */}
      <div className="iletisim-kunye">
        <div className="iletisim-kunye-container address">
          <h4>Adres</h4>
          <p>Çankaya/Ankara</p>
          <p>Kızılay Mah. İzmir 1 Cad. No:20/22</p>
        </div>
        <div className="iletisim-kunye-container contact">
          <h4>İletişim</h4>
          <p>Tel: +90 123 456 78 90</p>
          <p>Email: info@futroniks.com</p>
        </div>
      </div>

      <div className="iletisim-map">
          <h3 className="map-title1">
            Bize Ulaşın
            <span className="map-title2">08:00 - 18:00 arası açığız.</span>
          </h3>
          <iframe
            title="Google Map"
            src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d10119.756678809757!2d32.853091!3d39.922777!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14d34efff0e6e747%3A0x9cd776585816f3a2!2zS8SxesSxbGF5LCDEsHptaXItMSBDZC4gTm86MjAgRDoyMiwgMDY0MjAgw4dhbmtheWEvQW5rYXJh!5e1!3m2!1str!2str!4v1759136855288!5m2!1str!2str"
            allowFullScreen
            loading="lazy"
            referrerPolicy="no-referrer-when-downgrade"
          ></iframe>
        </div>

    </div>
  );
}

