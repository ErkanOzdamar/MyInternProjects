import { createContext, useContext, useState } from "react";

// Context oluştur
const UrunlerContext = createContext();

// Provider bileşeni
export function UrunlerProvider({ children }) {
  // Başlangıç verisi (sonradan API ile değişebilir)
  const [urunler] = useState([
    { id: 1, isim: "Akıllı Ev PCB", img: "/imagesProducts/akıllıEv.webp", aciklama: "Ürün 1 açıklaması" },
    { id: 2, isim: "Elevator Control PCB", img: "/imagesProducts/elevatorControl.jpg", aciklama: "Ürün 2 açıklaması" },
    { id: 3, isim: "Facial Recognition PCB", img: "/imagesProducts/facialRecognition.jpg", aciklama: "Ürün 3 açıklaması" },
    { id: 4, isim: "Power Control PCB", img: "/imagesProducts/powerControl.jpg", aciklama: "Ürün 4 açıklaması" },
    { id: 5, isim: "Tüketici Elektroniği PCB", img: "/imagesProducts/tüketiciE.jpg", aciklama: "Ürün 5 açıklaması" },
    { id: 6, isim: "Yeni Enerji Ve Otomotiv PCB", img: "/imagesProducts/yeniE.jpg", aciklama: "Ürün 6 açıklaması" },
  ]);

  return (
    <UrunlerContext.Provider value={{ urunler }}>
      {children}
    </UrunlerContext.Provider>
  );
}

// Context’i kullanmak için hook
export function useUrunler() {
  return useContext(UrunlerContext);
}
