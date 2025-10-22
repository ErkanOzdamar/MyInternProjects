import { createContext, useContext, useState } from "react";

const BannerContext = createContext();

export function BannerProvider({ children }) {

    const [banners] = useState([
    { id: 1, img: "/imagesBanner/Banner4.jpg" },
    { id: 2, img: "/imagesBanner/denem3.jpeg" },
    { id: 3, img: "/imagesBanner/Banner3.jpg" },
    { id: 4, img: "/imagesBanner/denem4.png" }
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
