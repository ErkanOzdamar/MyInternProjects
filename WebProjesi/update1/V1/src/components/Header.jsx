import { useState, useEffect, useRef } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useProducts } from "../context/ProductsContext.jsx";
import "./Header.css";

const translations = {
  tr: {
    kurumsal: "KURUMSAL",
    yeteneklerimiz: "YETENEKLERİMİZ",
    ozelTalep: "ÖZEL TALEP",
    urunlerimiz: "ÜRÜNLERİMİZ",
    iletisim: "İLETİŞİM"
  },
  en: {
    kurumsal: "ABOUT",
    yeteneklerimiz: "OUR SKILLS",
    ozelTalep: "SPECIAL REQUEST",
    urunlerimiz: "OUR PRODUCTS",
    iletisim: "CONTACT"
  }
};

export default function Header() {

  const lastScroll = useRef(0);
  const [headerHidden, setHeaderHidden] = useState(false);


  useEffect(() => {
    const handleScroll = () => {
      const currentScroll = window.pageYOffset;
      setHeaderHidden(currentScroll > lastScroll.current);
      lastScroll.current = currentScroll;
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  const [searchOpen, setSearchOpen] = useState(false);
  const [query, setQuery] = useState("");
  const items = ["Adana", "Ankara", "İstanbul", "İzmir"];
  const filteredItems = items.filter(item =>
    item.toLowerCase().includes(query.toLowerCase())
  );

  const [language, setLanguage] = useState("tr");
  const toggleLanguage = () => setLanguage(language === "tr" ? "en" : "tr");

  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const toggleMenu = () => setIsMenuOpen(!isMenuOpen);

  const { products } = useProducts() || { products: [] }; // boş dizi fallback

  //dropdown ayarları:
  // ref oluştur
  const scrollRef = useRef(null);
  // Dropdown hover
  const [hoveredProduct, setHoveredProduct] = useState(null);

  // Maksimum satır sayısı
  const maxRows = 4;
  const rowsPerColumn = maxRows;
  // Fare tekeri ile yatay kaydırma
  useEffect(() => {
    const el = scrollRef.current;
    if (!el) return;

    const handleWheel = (e) => {
      if (e.deltaY === 0) return;
      e.preventDefault();
      el.scrollLeft += e.deltaY;
    };

    el.addEventListener("wheel", handleWheel);
    return () => el.removeEventListener("wheel", handleWheel);
  }, []);

  // Ürünleri sütunlara böl
  const columns = [];
  for (let i = 0; i < products.length; i += rowsPerColumn) {
    columns.push(products.slice(i, i + rowsPerColumn));
  }

 
  

  const navigate = useNavigate();
  const goToProduct = (id) => navigate(`/ozel-talep/${id}`);

  return (
    <>
      <header className={`header ${headerHidden ? "hidden" : ""}`}>
        <div className="header-left">
          <Link to="/">
          <img src="/LOGOSnew.png" alt="Logo" className="logo" />
          </Link>
        </div>

        <div className={`header-center ${isMenuOpen ? "active" : ""}`}>
          <ul className="nav">
            <li><a href="#kurumsal">{translations[language].kurumsal}</a></li>
            <li><a href="#yeteneklerimiz">{translations[language].yeteneklerimiz}</a></li>
            <li><Link to="/ozel-talep">{translations[language].ozelTalep}</Link></li>

            <li className="dropdown-parent">
              <span className="dropdown-label">{translations[language].urunlerimiz}</span>

              <div className="dropdown" role="menu">
<div className="dropdown-columns" ref={scrollRef}>
  {columns.map((col, colIdx) => (
    <div key={colIdx} className="dropdown-column">
      {col.map((product, idx) => (
        <div
          key={product.id ?? idx}
          className="dropdown-item"
          role="menuitem"
          tabIndex={0}
          onMouseEnter={() => setHoveredProduct(product)}
          onMouseLeave={() => setHoveredProduct(null)}
          onClick={() => goToProduct(product.id)}
        >
          <span className="dropdown-title">{product.title ?? "Ürün"}</span>
        </div>
      ))}
    </div>
  ))}
</div>

                <div className="dropdown-image">
                  {columns.length > 0 && columns[0].length > 0 && (
                    <img
                      src={(hoveredProduct ?? columns[0][0]).img ?? "/placeholder.png"}
                      alt={(hoveredProduct ?? columns[0][0]).title ?? "Ürün"}
                      loading="lazy"
                    />
                  )}
                </div>
              </div>
            </li>

            <li><Link to="/iletisim">{translations[language].iletisim}</Link></li>
          </ul>
        </div>

        <div className="header-right">
          <button className="search-btn" onClick={() => setSearchOpen(true)} aria-label="Arama">
            <i className="fa-solid fa-magnifying-glass"></i>
          </button>
          <button className="language-btn" onClick={toggleLanguage}>
            {language === "tr" ? <>TR <i className="fa-solid fa-earth-americas"></i></> : <>EN <i className="fa-solid fa-earth-americas"></i></>}
          </button>
        </div>
      </header>

      {searchOpen && (
        <div className="search-overlay">
          <div className="search-modal">
            <div className="search-header">
              <h2>Sitede Ara</h2>
              <button className="close-btn" onClick={() => setSearchOpen(false)}>
                <i className="fa-solid fa-xmark"></i>
              </button>
            </div>
            <input
              type="text"
              placeholder="Bir şeyler yaz..."
              value={query}
              onChange={(e) => setQuery(e.target.value)}
            />
            <ul className="search-results">
              {filteredItems.length > 0 ? (
                filteredItems.map((item, index) => (
                  <li key={index} className="search-item">{item}</li>
                ))
              ) : (
                <li className="search-item">Sonuç bulunamadı</li>
              )}
            </ul>
          </div>
        </div>
      )}
    </>
  );
}


