import { useState, useEffect, useRef } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useProducts } from "../context/ProductsContext.jsx";
import SearchModal from "./SearchModal.jsx"; // Yeni component import edildi
import "./Header.css";

const translations = {
  tr: { kurumsal: "KURUMSAL", ozelTalep: "ÖZEL TALEP", urunlerimiz: "ÜRÜNLERİMİZ", iletisim: "İLETİŞİM", geri: "Geri", kategoriler: "Kategoriler", urunler: "Ürünler", arama: "Arama", dil: "Dil" },
  en: { kurumsal: "ABOUT US", ozelTalep: "SPECIAL REQUEST", urunlerimiz: "OUR PRODUCTS", iletisim: "CONTACT", geri: "Back", kategoriler: "Categories", urunler: "Products", arama: "Search", dil: "Language" }
};

export default function Header() {
  const lastScroll = useRef(0);
  const [headerHidden, setHeaderHidden] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      const currentScroll = window.pageYOffset;
      if (currentScroll > 100) {
        setHeaderHidden(currentScroll > lastScroll.current);
      } else {
        setHeaderHidden(false);
      }
      lastScroll.current = currentScroll;
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  const [searchOpen, setSearchOpen] = useState(false);
  const [language, setLanguage] = useState("tr");
  const toggleLanguage = () => setLanguage(language === "tr" ? "en" : "tr");
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const navigate = useNavigate();
  const goToProduct = (id) => navigate(`/urunlerimiz/${id}`);

  const { productCategories, products } = useProducts() || { productCategories: [], products: [] }; // products eklendi

  const [activeCategory, setActiveCategory] = useState(null);
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [menuPanel, setMenuPanel] = useState('main');
  const [activeMobileCategory, setActiveMobileCategory] = useState(null);

  useEffect(() => {
    if (productCategories && productCategories.length > 0 && !activeCategory) {
      setActiveCategory(productCategories[0]);
    }
  }, [productCategories, activeCategory]);

  useEffect(() => {
    if (!isMenuOpen) {
      setTimeout(() => {
        setMenuPanel('main');
        setActiveMobileCategory(null);
      }, 300);
    }
  }, [isMenuOpen]);

  const handleMobileLinkClick = () => {
    setIsMenuOpen(false);
  };

  const handleMobileSearchClick = () => {
    setIsMenuOpen(false);
    setSearchOpen(true);
  };

  const handleDesktopCategoryClick = (category) => {
    setActiveCategory(category);
    setSelectedProduct(null);
  };

  return (
    <>
      <header className={`header ${headerHidden ? "hidden" : ""}`}>
        <div className="header-left">
          <Link to="/" className="logo-click-area" aria-label="Anasayfa"></Link>
          <img src="/LOGOSnewİ.png" alt="Logo" className="logo" />
        </div>

        <div className={`header-center ${isMenuOpen ? "active" : ""}`}>
          <ul className="nav desktop-nav">
            <li><Link to="/kurumsal">{translations[language].kurumsal}</Link></li>
            <li><Link to="/ozel-talep">{translations[language].ozelTalep}</Link></li>
            <li className="dropdown-parent">
              <span className="dropdown-label">{translations[language].urunlerimiz}</span>
              <div className="dropdown" role="menu">
                <div className="dropdown-column dropdown-categories">
                  {productCategories.map((category) => (
                    <div
                      key={category.id}
                      className={`category-item ${activeCategory?.id === category.id ? 'active' : ''}`}
                      onClick={() => handleDesktopCategoryClick(category)}
                    >
                      {category.categoryTitle}
                    </div>
                  ))}
                </div>
                <div className="dropdown-column dropdown-products">
                  {activeCategory && activeCategory.products.map((product) => (
                    <div
                      key={product.id}
                      className={`product-item ${selectedProduct?.id === product.id ? 'active' : ''}`}
                      onClick={() => setSelectedProduct(product)}
                    >
                      {product.title}
                    </div>
                  ))}
                </div>
                <div className="dropdown-column dropdown-visuals">
                  {selectedProduct ? (
                    <div className="visual-single" onClick={() => goToProduct(selectedProduct.id)}>
                      <img src={selectedProduct.img} alt={selectedProduct.title} />
                      <h3>{selectedProduct.title}</h3>
                      <p>{selectedProduct.price}</p>
                    </div>
                  ) : (
                    <div className="visuals-grid">
                      {activeCategory && activeCategory.products.map((product) => (
                        <div key={product.id} className="visual-item" onClick={() => goToProduct(product.id)}>
                          <img src={product.img} alt={product.title} loading="lazy" />
                          <span className="visual-item-title">{product.title}</span>
                          <span className="visual-item-desc">{product.price}</span>
                        </div>
                      ))}
                    </div>
                  )}
                </div>
              </div>
            </li>
            <li><Link to="/iletisim">{translations[language].iletisim}</Link></li>
          </ul>

          <div className="mobile-menu-viewport">
            <div className={`mobile-menu-panels-container panel-${menuPanel}-active`}>
              <div className="mobile-menu-panel panel-main">
                <ul className="nav mobile-nav">
                  <li><Link to="/kurumsal" onClick={handleMobileLinkClick}>{translations[language].kurumsal}</Link></li>
                  <li><Link to="/ozel-talep" onClick={handleMobileLinkClick}>{translations[language].ozelTalep}</Link></li>
                  <li onClick={() => setMenuPanel('categories')}><span className="dropdown-label">{translations[language].urunlerimiz}</span></li>
                  <li><Link to="/iletisim" onClick={handleMobileLinkClick}>{translations[language].iletisim}</Link></li>
                </ul>
                <div className="mobile-menu-utilities">
                  <button className="mobile-util-btn" onClick={handleMobileSearchClick}><i className="fa-solid fa-magnifying-glass"></i><span>{translations[language].arama}</span></button>
                  <button className="mobile-util-btn" onClick={toggleLanguage}><i className="fa-solid fa-earth-americas"></i><span>{language === "tr" ? "EN" : "TR"} ({translations[language].dil})</span></button>
                </div>
              </div>
              <div className="mobile-menu-panel panel-categories">
                <div className="mobile-menu-header" onClick={() => setMenuPanel('main')}><i className="fa-solid fa-chevron-left"></i> {translations[language].geri}</div>
                <h3 className="mobile-menu-title">{translations[language].kategoriler}</h3>
                <ul className="nav mobile-nav">
                  {productCategories.map((category) => ( <li key={category.id}  onClick={() => { setActiveMobileCategory(category); setMenuPanel('products'); }}><span className="dropdown-label">{category.categoryTitle}</span></li>))}
                </ul>
              </div>
              <div className="mobile-menu-panel panel-products">
                <div className="mobile-menu-header" onClick={() => setMenuPanel('categories')}><i className="fa-solid fa-chevron-left"></i> {translations[language].geri}</div>
                <h3 className="mobile-menu-title">{activeMobileCategory ? activeMobileCategory.categoryTitle : translations[language].urunler}</h3>
                <ul className="nav mobile-nav">
                  {activeMobileCategory && activeMobileCategory.products.map((product) => ( <li key={product.id}><Link to={`/urunlerimiz/${product.id}`} onClick={handleMobileLinkClick}>{product.title}</Link></li>))}
                </ul>
              </div>
            </div>
          </div>
        </div>

        <div className="header-right">
          <button className="search-btn" onClick={() => setSearchOpen(true)} aria-label="Arama"><i className="fa-solid fa-magnifying-glass"></i></button>
          <button className="language-btn" onClick={toggleLanguage}>
            {language === "tr" ? <><span className="lang-text">TR</span> <i className="fa-solid fa-earth-americas"></i></> : <><span className="lang-text">EN</span> <i className="fa-solid fa-earth-americas"></i></>}
          </button>
          <button className="mobile-menu-toggle" onClick={() => setIsMenuOpen(!isMenuOpen)} aria-label="Menüyü aç/kapat"><i className={`fa-solid ${isMenuOpen ? 'fa-xmark' : 'fa-bars'}`}></i></button>
        </div>
      </header>

      {isMenuOpen && <div className="mobile-menu-overlay" onClick={() => setIsMenuOpen(false)}></div>}


      {searchOpen && (
        <SearchModal
          isOpen={searchOpen}
          onClose={() => setSearchOpen(false)}
          products={products}
          navigate={navigate}
        />
      )}
    </>
  );
}