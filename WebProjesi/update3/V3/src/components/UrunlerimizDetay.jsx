import { useParams} from 'react-router-dom';
import { useProducts } from '../context/ProductsContext.jsx';
import './UrunlerimizDetay.css';

export default function UrunlerimizDetay() {
  const { id } = useParams();
  const { products } = useProducts();

  const product  = products.find(u => u.id === parseInt(id));
  if (!products) return <p>Ürün bulunamadı</p>;


  return (
    <div className="urunlerimiz-detay-page">
      <div className="urunlerimiz-banner">
        <div className="banner-left">
          <img src={product.img} alt={product.title} />
        </div>
        <div className="banner-right">
          <h1>{product.title}</h1>
          <p>{product.detail1}</p>
        </div>
      </div>

      <div className="urunlerimiz-action-boxes">
        <div className="action-box">

        </div>
        <div className="action-box">

        </div>
        <div className="action-box">

        </div>
        <div className="action-box">

        </div>
      </div>
    </div>
  );
}

