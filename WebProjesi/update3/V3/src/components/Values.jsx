
import './Values.css';

const valuesData = [
 {
    title: "Saygılıyız",
    icon: <i className="fa-solid fa-ranking-star"></i>,
    description: "İnsana, doğaya, geçmişe ve geleceğe saygı duyarız."
  },
  {
    title: "Duyarlıyız",
    icon: <i className="fa-solid fa-hand-holding-heart"></i>,
    description: "İş yapmanın insandan insana bir aktivite olduğunun farkındayız. Empati kurarak dinliyor, hızlı ve uygun cevaplar veriyoruz."
  },
  {
    title: "Sonuç Odaklıyız",
    icon: <i className="fa-solid fa-award"></i>,
    description: "Net ve özgül hedefler belirleyip bunları gerçekleştiriyoruz. Bu amaçla, halkımıza ihtiyaç duydukları en iyi alet ve ekipmanı sağlıyoruz."
  }
];

const Values = () => {


  return (
    <section className="values-section" id="degerlerimiz">
      <div className="container">
        <h2 className="values-title">Değerlerimiz</h2>
        
        <div className="values-grid">
          {valuesData.map((value, index) => (
            <div className="value-card" key={index}>
              <div className="value-icon-container">
                {value.icon}
              </div>
              <h3 className="value-name">{value.title}</h3>
              <p className="value-description">{value.description}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default Values;