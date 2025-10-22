import { Link } from 'react-router-dom';
import './Kurumsal.css';
import Reference from './References.jsx';
import { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";

export default function Kurumsal() {
  const [animate, setAnimate] = useState(false);
  const location = useLocation();

  useEffect(() => {
    // sayfa gerçekten /kurumsal olunca animasyonu tetikle
    if (location.pathname === "/kurumsal") {
      // önce reset
      setAnimate(false);
      // sonra küçük bir delay ile true yap
      setTimeout(() => setAnimate(true), 50);
    }
  }, [location]);

  return (
    <div className="kurumsal-page">

      {/* Breadcrumb */}
      <div className="Probreadcrumb">
        <Link to="/" className="Probreadcrumb-home">Anasayfa</Link>
        <i className="fa-solid fa-chevron-right Probreadcrumb-separator"></i>
        <span className="Probreadcrumb-current">Kurumsal</span>
      </div>

      {/* Breadcrumb Second */}
      <div className="breadcrumbSecond">
        <span className="Probreadcrumb-current2">Kurumsal</span>
      </div>


{/* Vizyon */}
<div className={`full-bg-container right slide-in-right ${animate ? 'animate' : ''}`}>
  <div className="box-with-icon">
    <div className="text-box">
      <h2>Misyonumuz</h2>
      <p>
        FUTRONİKS olarak misyonumuz, ileri mühendislik metotları kullanarak endüstriye yenilikçi ve güvenilir çözümler sunmaktır. Teknolojiyi etkili biçimde kullanarak somut değer yaratan ve beklentilerin ötesine geçen çözümler üretiyoruz.
      </p>
    </div>
    <i className="fa-solid fa-globe"></i>
  </div>
</div>
{/* Misyon */}
<div className={`full-bg-container left slide-in-left ${animate ? 'animate' : ''}`}>
  <div className="box-with-icon">
    <i className="fa-solid fa-user-shield"></i>
    <div className="text-box">
      <h2>Vizyonumuz</h2>
      <p>
      FUTRONİKS olarak vizyonumuz, elektronik sistemler alanında uluslararası ölçekte bir mükemmeliyet merkezi haline gelerek, dünya çapında talep gören ve teknolojiye yön veren bir marka olmaktır.
      </p>
    </div>
  </div>
</div>




      {/* References modülü */}
      <Reference />


      <div className="about-us-block">
        <h4 className="about-us-pre-title">FUTRONİKS HAKKINDA</h4>
        <h2 className="about-us-main-title-one">Profesyonel Güvenilirlik,</h2>
        <h2 className="about-us-main-title-two">Kanıtlanmış Çözümler.</h2>
        <p className="about-us-text">
        FUTRONIKS olarak, güç elektroniği alanındaki uzmanlığımızı uçtan uca kritik sistem mühendisliği uygulamalarıyla buluşturuyoruz.
        Ankara Ar-Ge ve üretim Ofislerimizde, başta savunma, havacılık, medikal ve endüstriyel elektronik sanayisi olmak üzere, sektörlere yönelik donanım, 
        sistem ve alt sistemler tasarlayıp üretiyoruz. 
        </p>
        <p className="about-us-text">
        Temel prensibimiz; sistemlerinizin operasyonel sürekliliğini teminat altına alan, yüksek güvenilirlikli ve çevresel stres dayanımına sahip modüler enerji çözümleri tasarlamaktır. 
        Kuruluşumuzdan bu yana, yüksek saha dayanımı ve uzun ömürlülük sunan çözümlerimizle, kesintisiz görev sürekliliğini sağlamayı hedefliyoruz.
        </p>
      </div>


      {/* 4 ikon + metin */}
      <div className="icon-section">
        <div className="icon-item">
          <div className="valuE-icon-container">
            <i className="fa-solid fa-microchip"></i>
          </div>
          <p>Mühendislik Hizmetleri</p>
        </div>

        <div className="icon-item">
          <div className="valuE-icon-container">
            <i className="fa-solid fa-tools"></i>
          </div>
          <p>Donanım & Mekanik Tasarım Hizmetleri</p>
        </div>

        <div className="icon-item">
          <div className="valuE-icon-container">
            <i className="fa-solid fa-code"></i>
          </div>
          <p>Yazılım Hizmetleri</p>
        </div>

        <div className="icon-item">
          <div className="valuE-icon-container">
            <i className="fa-solid fa-cogs"></i>
          </div>
          <p>Tedarik & Üretim Hizmetleri</p>
        </div>
      </div>
    </div>
  );
}
