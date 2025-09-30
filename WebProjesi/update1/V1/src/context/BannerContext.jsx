// context/BannerContext.jsx
import { createContext, useContext, useState } from "react";

const BannerContext = createContext();

export function BannerProvider({ children }) {

    const [banners] = useState([
    { id: 1, img: "/imagesBanner/Banner1.jpg" },
    { id: 2, img: "/imagesBanner/Banner2.png" },
    { id: 3, img: "/imagesBanner/Banner3.jpeg" },
    { id: 4, img: "/imagesBanner/Banner4.jpg" }
  ]);

  return (
    <BannerContext.Provider value={{ banners }}>
      {children}
    </BannerContext.Provider>
  );
}

export function useBanner() {
  return useContext(BannerContext);
}
