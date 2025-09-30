import { createContext, useContext, useState } from "react";

const ReferencesContext = createContext();

export function ReferencesProvider({ children }) {
  const [logos] = useState([
      { id: 1, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 1" },
      { id: 2, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 2" },
      { id: 3, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 3" },
      { id: 4, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 4" },
      /*{ id: 5, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 5" },
      { id: 6, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 6" },
      { id: 7, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 7" },
      { id: 8, img: "/imagesBannerLogo/LOGOSnew2.png", name: "Logo 8" }*/
  ]);

  return (
    <ReferencesContext.Provider value={{ logos }}>
      {children}
    </ReferencesContext.Provider>
  );
}

export function useReferences() {
  return useContext(ReferencesContext);
}

