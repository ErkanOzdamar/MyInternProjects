import { useState } from 'react';
import { useLocation } from 'react-router-dom';
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
    // Şimdilik form verilerini console.log ile gösteriyoruz
    console.log(formData);
    alert('Mesajınız hazır!');
    setFormData({ mesaj: '', isim: '', email: '' });
  };

  return (
    <div className="iletisim-page">
      <div className="iletisim-container">
        {/* Sol taraf metin alanı */}
        <div className="iletisim-left">
          <p>
            Bizimle iletişime geçmek için formu doldurabilirsiniz. 
          </p>
        </div>

        {/* Sağ taraf form */}
        <div className="iletisim-right">
          <form onSubmit={handleSubmit}>
            <textarea
              name="mesaj"
              placeholder="Mesajınız..."
              value={formData.mesaj}
              onChange={handleChange}
            />
            <div className="input-row">
              <input
                type="text"
                name="isim"
                placeholder="İsminiz"
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
    </div>
  );
}
