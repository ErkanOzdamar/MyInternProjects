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

import Kurumsal from './components/Kurumsal.jsx';
import Iletisim from './components/Iletisim.jsx';
import OzelTalep from './components/OzelTalep.jsx';
import UrunlerimizDetay from './components/UrunlerimizDetay.jsx';


import { BannerProvider } from './context/BannerContext.jsx';
import { ProductsProvider } from './context/ProductsContext.jsx';
import { ReferencesProvider } from './context/ReferencesContext.jsx';
import { NewsProvider } from './context/NewsContext.jsx';

import "./index.css";


function BodyController() {
  const location = useLocation();

  useEffect(() => {
    window.scrollTo({ top: 0, left: 0, behavior: "auto" });
  }, [location]);

  return null;
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
                    <Route path="/kurumsal" element={<Kurumsal />} />
                    <Route path="/iletisim" element={<Iletisim />} />
                    <Route path="/ozel-talep" element={<OzelTalep />} />
                    <Route path="/urunlerimiz/:id" element={<UrunlerimizDetay />} />
                  </Routes>
                </main>
            </NewsProvider>
          </ReferencesProvider>
        </ProductsProvider>
      </BannerProvider>
      <Footer />
    </Router>
  );
}