import { createContext, useContext, useState } from "react";

const ReferencesContext = createContext();

export function ReferencesProvider({ children }) {
  const [logos] = useState([
      { id: 1, img: "/referencesIMG/referencesL1.png", name: "Logo 1" },
      { id: 1, img: "/referencesIMG/referencesL2.png", name: "Logo 1" },
      { id: 1, img: "/referencesIMG/referencesL3.png", name: "Logo 1" },
      { id: 1, img: "/referencesIMG/referencesL4.png", name: "Logo 1" },
      { id: 1, img: "/referencesIMG/referencesL5.png", name: "Logo 1" }
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

