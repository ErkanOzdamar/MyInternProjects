import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import { useEffect } from 'react';
import Header from "./components/Header.jsx";
import Footer from "./components/Footer.jsx";
import ScrollTop from "./components/ScrollTop.jsx";

import Banner from "./components/Banner.jsx";
import Products from "./components/Products.jsx";
import References from "./components/References.jsx";
import News from "./components/News.jsx";
import Values from "./components/Values.jsx";

import Iletisim from './components/Iletisim.jsx';
import OzelTalep from './components/OzelTalep.jsx';
import UrunlerimizDetay from './components/UrunlerimizDetay.jsx';
import Urunlerimiz from './components/Urunlerimiz.jsx';

import { BannerProvider } from './context/BannerContext.jsx';
import { ProductsProvider } from './context/ProductsContext.jsx';
import { ReferencesProvider } from './context/ReferencesContext.jsx';
import { NewsProvider } from './context/NewsContext.jsx';
import { ValuesProvider } from './context/ValuesContext.jsx';
import { UrunlerProvider } from './context/UrunlerContext.jsx';

import "./index.css";


function BodyController() {
  const location = useLocation();

  useEffect(() => {
    // Body class yönetimi
    if (
      location.pathname.startsWith("/ozel-talep") ||
      location.pathname === "/urunlerimiz" ||
      location.pathname === "/iletisim"
    ) {
      document.body.classList.add("ozel-talep-page-active");
    } else {
      document.body.classList.remove("ozel-talep-page-active");
    }

    // Scroll reset
    window.scrollTo({ top: 0, left: 0, behavior: "auto" });
  }, [location]);

  return null; // DOM’a render etmez
}


export default function App() {


  return (
    <Router>

     <BodyController />
      <BannerProvider>
        <ProductsProvider>
          <Header />
          <ScrollTop />
          <ReferencesProvider>
            <NewsProvider>
              <ValuesProvider>
                <UrunlerProvider>
                <main>
                  <Routes>
                    <Route path="/" element={
                      <>
                        <Banner />
                        <References />
                        <Products />
                        <Values />
                        <News />
                      </>
                    } />
                    <Route path="/iletisim" element={<Iletisim />} />
                    <Route path="/ozel-talep" element={<OzelTalep />} />
                    <Route path="/urunlerimiz" element={<Urunlerimiz />} />
                    <Route path="/urunlerimiz/:id" element={<UrunlerimizDetay />} />
                  </Routes>
                </main>
                </UrunlerProvider>
              </ValuesProvider>
            </NewsProvider>
          </ReferencesProvider>
        </ProductsProvider>
      </BannerProvider>
      <Footer />
    </Router>
  );
}

