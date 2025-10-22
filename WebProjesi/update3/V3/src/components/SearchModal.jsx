import { useState, useMemo } from 'react';
import './SearchModal.css';

export default function SearchModal({ isOpen, onClose, products = [], navigate }) {
  const [query, setQuery] = useState('');

  const filteredProducts = useMemo(() => {
    if (query.trim() === '') {
      return []; // Arama kutusu boşsa sonuç gösterme
    }
    const lowerCaseQuery = query.toLowerCase();
    return products.filter(product =>
      product.title.toLowerCase().includes(lowerCaseQuery)
    );
  }, [query, products]);

  const handleResultClick = (productId) => {
    navigate(`/urunlerimiz/${productId}`);
    onClose(); // Modalı kapat
    setQuery(''); // Arama kutusunu temizle
  };

  // isOpen false ise hiçbir şey render etme (Header'da zaten kontrol ediliyor ama ekstra güvenlik)
  if (!isOpen) {
    return null;
  }

  return (
    <div className="search-overlay" onClick={onClose}>
      <div className="search-modal" onClick={(e) => e.stopPropagation()}>
        <div className="search-header">
          <h2>Sitede Ürün Ara</h2>
          <button className="close-btn" onClick={onClose}><i className="fa-solid fa-xmark"></i></button>
        </div>
        <input
          type="text"
          placeholder="Ürün adı yazın..."
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          autoFocus /* Modal açıldığında input'a odaklansın */
        />
        <ul className="search-results">
          {query.trim() !== '' && filteredProducts.length > 0 ? (
            filteredProducts.map((product) => (
              <li
                key={product.id}
                className="search-item"
                onClick={() => handleResultClick(product.id)}
              >
                {product.title}
              </li>
            ))
          ) : (
            query.trim() !== '' && <li className="search-item no-result">Sonuç bulunamadı</li>
          )}
          {/* Arama kutusu boşken bir şey gösterme */}
        </ul>
      </div>
    </div>
  );
}