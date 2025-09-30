import "./OzelTalep.css";
import { Link, useNavigate } from 'react-router-dom';

export default function OzelTalep() {
  const navigate = useNavigate();

  // Buton click handler (iletisim sayfasına yönlendirme)
  const handleButtonClick = (mesaj) => {
    navigate('/iletisim', { state: { mesaj } }); // <-- state ile gönderiyoruz
  };

  return (
    <div className="ozel-talep-page">

      {/* Breadcrumb / Yönlendirme alanı */}
      <div className="breadcrumb">
        <Link to="/" className="breadcrumb-home">Anasayfa</Link>
        <i className="fa-solid fa-chevron-right breadcrumb-separator"></i>
        <span className="breadcrumb-current">Özel Talep</span>
      </div>
      {/* 2. Banner + Üstüne Konteyner */}
      <div className="ozel-talep-second-banner">
        <img src="/OzelTalepB.png" alt="Second Banner" />
      </div>

        {/* Alt kutular ve butonlar */}
        <div className="ozel-talep-action-boxes">
          <div className="box-title">
            
            <h2>PCB Tasarım Talebi</h2>
            <p>Lorem Ipsum , baskı ve dizgi endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, bilinmeyen bir matbaacının bir yazı galerisini alıp karıştırarak bir yazı örneği kitabı oluşturduğu 1500'lerden beri endüstrinin standart mıgır metni olmuştur. Beş yüzyılı atlatmakla kalmamış, aynı zamanda elektronik dizgiye de sıçramış ve temelde hiç değişmeden kalmıştır. 1960'larda Lorem Ipsum pasajları içeren Letraset sayfalarının piyasaya sürülmesiyle ve daha yakın zamanda Aldus PageMaker gibi masaüstü yayıncılık yazılımlarının Lorem Ipsum sürümleri içermesiyle popüler hale gelmiştir.</p>
          <button onClick={() => handleButtonClick("PCB Tasarım Talebinde Bulunmak İstiyorum.")}>
               İletişime Geç
          </button>              
          </div>
          <div className="box-image">
            <img src="/imagesProducts/akıllıEv.png" alt="PCB görseli" />
          </div>
        </div>

        <div className="ozel-talep-action-boxes">
          <div className="box-title">
            
            <h2>Yazılım Hizmet Talebi</h2>
            <p>Lorem Ipsum , baskı ve dizgi endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, bilinmeyen bir matbaacının bir yazı galerisini alıp karıştırarak bir yazı örneği kitabı oluşturduğu 1500'lerden beri endüstrinin standart mıgır metni olmuştur. Beş yüzyılı atlatmakla kalmamış, aynı zamanda elektronik dizgiye de sıçramış ve temelde hiç değişmeden kalmıştır. 1960'larda Lorem Ipsum pasajları içeren Letraset sayfalarının piyasaya sürülmesiyle ve daha yakın zamanda Aldus PageMaker gibi masaüstü yayıncılık yazılımlarının Lorem Ipsum sürümleri içermesiyle popüler hale gelmiştir.</p>
            <button onClick={() => handleButtonClick("Yazılım Hizmet Talebinde Bulunmak İstiyorum.")}>
               İletişime Geç
            </button>            
          </div>
          <div className="box-image">
            <img src="/imagesProducts/akıllıEv.png" alt="PCB görseli" />
          </div>
        </div>

        <div className="ozel-talep-action-boxes">
          <div className="box-title">
           
            <h2>Mekanik Tasarım Talebi</h2>
            <p>Lorem Ipsum , baskı ve dizgi endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, bilinmeyen bir matbaacının bir yazı galerisini alıp karıştırarak bir yazı örneği kitabı oluşturduğu 1500'lerden beri endüstrinin standart mıgır metni olmuştur. Beş yüzyılı atlatmakla kalmamış, aynı zamanda elektronik dizgiye de sıçramış ve temelde hiç değişmeden kalmıştır. 1960'larda Lorem Ipsum pasajları içeren Letraset sayfalarının piyasaya sürülmesiyle ve daha yakın zamanda Aldus PageMaker gibi masaüstü yayıncılık yazılımlarının Lorem Ipsum sürümleri içermesiyle popüler hale gelmiştir.</p>
            <button onClick={() => handleButtonClick("Mekanik Tasarım Talebinde Bulunmak İstiyorum.")}>
               İletişime Geç
            </button>            
          </div>
            <div className="box-image">
              <img src="/imagesProducts/akıllıEv.png" alt="PCB görseli" />
            </div>
        </div>

        <div className="ozel-talep-action-boxes">
          <div className="box-title">
            
            <h2>Üretim Talebi</h2>
            <p>Lorem Ipsum , baskı ve dizgi endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, bilinmeyen bir matbaacının bir yazı galerisini alıp karıştırarak bir yazı örneği kitabı oluşturduğu 1500'lerden beri endüstrinin standart mıgır metni olmuştur. Beş yüzyılı atlatmakla kalmamış, aynı zamanda elektronik dizgiye de sıçramış ve temelde hiç değişmeden kalmıştır. 1960'larda Lorem Ipsum pasajları içeren Letraset sayfalarının piyasaya sürülmesiyle ve daha yakın zamanda Aldus PageMaker gibi masaüstü yayıncılık yazılımlarının Lorem Ipsum sürümleri içermesiyle popüler hale gelmiştir.</p>
            <button onClick={() => handleButtonClick("Üretim Talebinde Bulunmak İstiyorum.")}>
               İletişime Geç
            </button>               
          </div>
          <div className="box-image">
            <img src="/imagesProducts/akıllıEv.png" alt="PCB görseli" />
          </div>
        </div>
    </div>
  );
}




