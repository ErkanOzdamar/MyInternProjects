import "./Header.css";
import { useState, useEffect } from "react";

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
  // Scroll efekt
  useEffect(() => {
    let lastScroll = 0;
    const header = document.querySelector(".header");

    const onScroll = () => {
      const currentScroll = window.pageYOffset;

      if (currentScroll > lastScroll) {
        // Aşağı kaydırılıyor
        header.classList.add("scrolled-down");
        header.classList.remove("scrolled-up");
      } else {
        // Yukarı kaydırılıyor: header hemen gelsin
        header.classList.remove("scrolled-down");
        header.classList.add("scrolled-up");
      }

      lastScroll = currentScroll;
    };

    window.addEventListener("scroll", onScroll);
    return () => window.removeEventListener("scroll", onScroll);
  }, []);

  // Arama modal state
  const [searchOpen, setSearchOpen] = useState(false);
  const [query, setQuery] = useState("");
  const items = ["Adana", "Ankara", "İstanbul", "İzmir"];
  const filteredItems = items.filter(item =>
    item.toLowerCase().includes(query.toLowerCase())
  );

  const [language, setLanguage] = useState("tr");
  const toggleLanguage = () => {
    setLanguage(language === "tr" ? "en" : "tr");
  };

  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  return (
    <>
      <header className="header">
        <div className="header-left">
          <img src="/LOGOS3.png" alt="Logo" className="logo" />
        </div>

        <div className={`header-center ${isMenuOpen ? "active" : ""}`}>
          <ul className="nav">
            <li><a href="#kurumsal">{translations[language].kurumsal}</a></li>
            <li><a href="#yeteneklerimiz">{translations[language].yeteneklerimiz}</a></li>
            <li><a href="#ozel-talep">{translations[language].ozelTalep}</a></li>
            <li><a href="#urunlerimiz">{translations[language].urunlerimiz}</a></li>
            <li><a href="#iletisim">{translations[language].iletisim}</a></li>
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
