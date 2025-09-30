

import Header from "./components/Header.jsx";
import Banner from "./components/Banner.jsx";
import Products from "./components/Products.jsx";
import News from "./components/News.jsx";
import Values from "./components/Values.jsx";
import Footer from "./components/Footer.jsx";

import './index.css'
export default function App(){
    return(
        <div>
            <Header />
            <Banner />
            <Products />
            <Values />
            <News />
            <Footer />
        </div>
    )
}