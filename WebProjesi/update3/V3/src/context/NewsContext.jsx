import { createContext, useContext, useState } from "react";

const NewsContext = createContext();

export function NewsProvider({ children }) {
  const [news] = useState([
      { id: 1, img: "/imagesNews/News1.jpg", title: "Qualcomm, Arduino’yu Satın Aldı: Yeni Nesil Gömülü Sistemler Yolda", price: "Qualcomm, açık kaynaklı elektronik platformu Arduino’yu satın aldı. Bu birleşme, yeni nesil gömülü sistemler ve AI destekli projeler için önemli bir adım olarak görülüyor. Arduino'nun yeni geliştirdiği Uno Q kartı, Qualcomm'un Dragonwing QRB2210 işlemcisiyle çalışıyor ve Linux Debian desteği sunuyor. Bu gelişme, özellikle yazılım ve donanım entegrasyonu konusunda hizmet veren mühendislik firmaları için fırsatlar yaratabilir." },
      { id: 2, img: "/imagesNews/News2.jpg", title: "SolidWorks 2025: Mekanik Tasarımda Yeni Dönem", price: "SolidWorks 2025, mekanik tasarım süreçlerini hızlandıran yeni özellikler sunuyor. Geliştirilmiş montaj ilişkileri, çizim ve montaj iş akışlarıyla daha verimli bir tasarım süreci mümkün hale geliyor. Bu güncellemeler, PCB tasarımı ve mekanik entegrasyon hizmetleri sunan firmalar için önemli iyileştirmeler sağlıyor." },
      { id: 3, img: "/imagesNews/News3.jpg", title: "2025 Yılı İçin Yeni Konektör ve Bağlantı Teknolojileri", price: "2025 yılı için yeni konektör ve bağlantı ürünleri tanıtıldı. Bu ürünler, sensörler, antenler, kablo montajları ve gelişim kitlerini içeriyor. Yeni bağlantı teknolojileri, özellikle endüstriyel otomasyon ve IoT projeleri için kritik öneme sahip. Bu gelişmeler, ürün tasarımı ve üretimi konusunda hizmet veren firmalar için yenilikçi çözümler sunuyor." },
      { id: 4, img: "/imagesNews/News4.jpg", title: "PCB Tasarımında AI Destekli Yenilikler", price: "PCB tasarımında yapay zeka destekli yeni trendler, tasarım süreçlerini daha verimli hale getiriyor. AI destekli tasarım araçları, daha hızlı ve hatasız devre kartları üretimi sağlıyor. Bu gelişmeler, PCB tasarımı ve üretimi hizmetleri sunan firmalar için rekabet avantajı yaratabilir." },
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

