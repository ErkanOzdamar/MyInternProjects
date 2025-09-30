import { useParams, useNavigate } from 'react-router-dom';
import { useUrunler } from '../context/UrunlerContext';
import './OzelTalepDetay.css';

export default function OzelTalepDetay() {
  const { id } = useParams();
  const navigate = useNavigate();
  const { urunler } = useUrunler();

  const urun = urunler.find(u => u.id === parseInt(id));

  if (!urun) return <p>Ürün bulunamadı</p>;

  // Buton click handler
  const handleButtonClick = (mesaj) => {
    navigate("/iletisim", { state: { mesaj } });
  };

  return (
    <div className="ozel-talep-detay-page">
      {/* Banner bölümü */}
      <div className="ozel-talep-banner">
        <div className="banner-left">
          <img src={urun.img} alt={urun.isim} />
        </div>
        <div className="banner-right">
          <h1>{urun.isim}</h1>
          <p>{urun.aciklama}</p>
        </div>
      </div>

      {/* Alt kutular ve butonlar */}
      <div className="ozel-talep-action-boxes">
        <div className="action-box">
          <button onClick={() => handleButtonClick("PCB Tasarım Talebinde Bulunmak İstiyorum.")}>
            PCB Tasarım Talebi
          </button>
        </div>
        <div className="action-box">
          <button onClick={() => handleButtonClick("Yazılım Hizmet Talebinde Bulunmak İstiyorum.")}>
            Yazılım Hizmet Talebi
          </button>
        </div>
        <div className="action-box">
          <button onClick={() => handleButtonClick("Mekanik Tasarım Talebinde Bulunmak İstiyorum.")}>
            Mekanik Tasarım Talebi
          </button>
        </div>
        <div className="action-box">
          <button onClick={() => handleButtonClick("Üretim Talebinde Bulunmak İstiyorum.")}>
            Üretim Talebi
          </button>
        </div>
      </div>
    </div>
  );
}


