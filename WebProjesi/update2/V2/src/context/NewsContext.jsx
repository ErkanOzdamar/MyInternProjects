// context/NewsContext.jsx
import { createContext, useContext, useState } from "react";

const NewsContext = createContext();

export function NewsProvider({ children }) {
  const [news] = useState([
      { id: 1, img: "/imagesNews/PCByeşilKalkınma.jpg", title: "PCB sektörünün yeşil kalkınma eylemi", price: " PCB endüstrisi, üretim sürecinde aşındırma ve elektrokaplama gibi birçok kimyasal işlemden geçmekte ve bu da büyük miktarda atık su, atık gaz ve atık kalıntısı üreterek çevre üzerinde büyük bir baskı oluşturmaktadır. Bu durumu değiştirmek için ilgili ulusal birimler, PCB endüstrisinin yeşil kalkınma yoluna girmesini teşvik etmek amacıyla bir dizi sıkı çevre koruma politikası ve standardı oluşturmuştur." },
      { id: 2, img: "/imagesNews/PCByeşil2.jpg", title: "PCB sektörünün yeşil kalkınma eylemi", price: "Ülkemiz, giderek daha sıkı hale gelen çevre koruma gerekliliklerine yanıt olarak PCB endüstrisi için kapsamlı bir yeşil kalkınma girişimi başlattı ve endüstriyi üretim sürecinde çevre koruma standartlarını yükseltmeye ve sürdürülebilir kalkınmaya ulaşmaya çağırdı." },
      { id: 3, img: "/imagesNews/PCBkalkınma.jpg", title: "Devlet, PCB endüstrisindeki yeniliği güçlü bir şekilde teşvik ediyor", price: "Baskılı devre kartı (PCB) sektörünün üst düzey imalat sektöründeki rekabet gücünü artırmak ve elektronik ve bilgi gibi sektörlere güçlü destek sağlamak amacıyla ülke, PCB sektörünün yenilikçi gelişimini teşvik etmek için aktif olarak politikalar uygulamaya koyuyor ve yatırımları artırıyor." },
      { id: 4, img: "/imagesNews/PCBotomotiv.jpg", title: "PCB Kartları Otomotiv Elektroniğini Nasıl Yeniden Tanımlıyor?", price: "Otomotiv elektroniği sektörü, gelenekselden akıllı ve bağlantılı bir yapıya doğru köklü bir dönüşüm geçiriyor. Otomotiv elektroniği sisteminin donanım temel taşı olan PCB (Baskılı Devre Kartı), tüm yönleriyle kapsamlı bir şekilde işleyerek otomotiv elektroniği ekosistemini yeniden şekillendiriyor ve akıllı yolculuğu yeni bir aşamaya taşıyor." },
]);

  return (
    <NewsContext.Provider value={{ news }}>
      {children}
    </NewsContext.Provider>
  );
}

export function useNews() {
  return useContext(NewsContext);
}

