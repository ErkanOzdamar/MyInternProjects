import { Link, useNavigate } from 'react-router-dom';
import { useUrunler } from '../context/UrunlerContext';
import './Urunlerimiz.css';

export default function Urunlerimiz() {
  const navigate = useNavigate();
  const { urunler } = useUrunler();

  const handleClick = (id) => {
    navigate(`/urunlerimiz/${id}`);
  };

  return (
    <div className="urunlerimiz-page">
      {/* Breadcrumb / Yönlendirme alanı */}
      <div className="Probreadcrumb">
        <Link to="/" className="Probreadcrumb-home">Anasayfa</Link>
        <i className="fa-solid fa-chevron-right Probreadcrumb-separator"></i>
        <span className="Probreadcrumb-current">Ürünlerimiz</span>
      </div>
      {/* Breadcrumb / Yönlendirme alanı */}
      <div className="breadcrumbSecond">
        <span className="breadcrumb-current2">Ürünlerimiz</span>
      </div>

      <div className="urunlerimiz-container">
        {urunler.map((urun) => (
          <div
            key={urun.id}
            className="urunlerimiz-card"
            onClick={() => handleClick(urun.id)}
          >
            <img src={urun.img} alt={urun.isim} />
            <h3 className="urunlerimiz-card-title">{urun.isim}</h3>
          </div>
        ))}
      </div>
    </div>
  );
}
