import { useNavigate } from 'react-router-dom';
import { useUrunler } from '../context/UrunlerContext';
import './OzelTalep.css';

export default function OzelTalep() {
  const navigate = useNavigate();
  const { urunler } = useUrunler();

  const handleClick = (id) => {
    navigate(`/ozel-talep/${id}`);
  };

  return (
    <div className="ozel-talep-page">
      
      <h2 className="custom-title">
        Reliable Designs<br />
        <span>Smarter Solutions</span>
      </h2>

      <div className="ozel-talep-container">
        {urunler.map((urun) => (
          <div
            key={urun.id}
            className="ozel-talep-card"
            onClick={() => handleClick(urun.id)}
          >
            <img src={urun.img} alt={urun.isim} />
            <h3 className="ozel-talep-title">{urun.isim}</h3>
          </div>
        ))}
      </div>
    </div>
  );
}




