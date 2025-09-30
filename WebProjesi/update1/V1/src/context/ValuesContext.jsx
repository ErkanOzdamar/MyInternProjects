import { createContext, useContext } from "react";

const ValuesContext = createContext();

export function ValuesProvider({ children }) {
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
    }];

  return (
    <ValuesContext.Provider value={{ valuesData }}>
      {children}
    </ValuesContext.Provider>
  );
}

export function useValues() {
  return useContext(ValuesContext);
}
