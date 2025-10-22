import { createContext, useContext, useState, useMemo } from "react";

const ProductsContext = createContext({
  productCategories: [],
  products: [],
});

export function ProductsProvider({ children }) {

  const [productCategories] = useState([
    {
      id: "cat1",
      categoryTitle: "Askeri Tip Ürünler",
      products: [
          { 
            id: 1, 
            img: "/imagesProducts/akıllıEv.png", 
            title: "MIL-STD-1275 Modül", 
            price: "En zorlu askeri ortamlarda bile kesintisiz ve güvenilir güç yönetimi için vazgeçilmeziniz.", 
            detail: "Askeri standartlara uygun bu modül, araç ve sistemlerde güç hatlarını korur ve düzenler.", 
          },
          { 
            id: 2, 
            img: "/imagesProducts/tüketiciE.jpg", 
            title: "Güç Dağıtım Birimi", 
            price: "Maksimum performansı korurken, sisteminizin enerji akışını akıllıca yönetin.", 
            detail: "Sistem içindeki farklı bileşenlere güvenli ve kontrollü bir şekilde enerji dağıtımı yapar.", 
          }
      ]
    },
    {
      id: "cat2",
      categoryTitle: "Endüstriyel Tip Ürünler",
      products: [
          { 
            id: 3, 
            img: "/imagesProducts/powerControl.jpg", 
            title: "Endüstriyel PCB", 
            price: "Dayanıklı yapısı ve üstün tasarımıyla endüstriyel süreçlerinizi kusursuzlaştırın.", 
            detail: "Fabrika otomasyonu ve ağır sanayi ortamlarında kontrol ve iletişim görevlerini yerine getirir.", 
          }
      ]
    },
    {
        id: "cat3",
        categoryTitle: "Yüksek Hızlı Elektronik Kartlar",
        products: [
          { 
            id: 4, 
            img: "/imagesProducts/tüketiciE.jpg", 
            title: "Jetson Nano Taşıyıcı Kart", 
            price: "AI ve robotik projelerinizi hızlandırmak için kompakt ve tam entegre çözümü keşfedin.", 
            detail: "NVIDIA Jetson Nano'nun tüm çevresel birimlerini erişilebilir hale getirerek projelerin geliştirilmesini sağlar.", 
          },
          { 
            id: 5, 
            img: "/imagesProducts/akıllıEv.png", 
            title: "Jetson Orin Taşıyıcı Kart", 
            price: "Geleceğin AI sistemlerine güç veren, ultra hızlı ve esnek taşıyıcı kartımızla tanışın.", 
            detail: "Yüksek performanslı yapay zeka uygulamaları için NVIDIA Jetson Orin serisi modülleri destekler.", 
          }
        ]
    },
    {
        id: "cat4",
        categoryTitle: "IOT Tabanlı Ürünler",
        products: [
            { 
              id: 6, 
              img: "/imagesProducts/elevatorControl.jpg", 
              title: "IOT Tabanlı Spray", 
              price: "Akıllı otomasyonla kontrol edilen püskürtme sistemi ile verimlilikte yeni bir seviyeye ulaşın.", 
              detail: "Belirlenen kimyasal/sıvıların uzaktan kontrol edilen bir mekanizma ile püskürtülmesini sağlar.", 
            },
            { 
              id: 7, 
              img: "/imagesProducts/facialRecognition.jpg", 
              title: "IOT Tabanlı Parafudr", 
              price: "Cihazlarınızı yıldırım ve ani voltaj değişimlerinin yıkıcı etkisinden uzaktan izleyerek koruyun.", 
              detail: "Şebekedeki aşırı gerilimleri algılayıp toprağa yönlendirerek bağlı elektronik cihazları korur.", 
            }
        ]
    }
  ]);

  const products = useMemo(() => {
    return productCategories.reduce((acc, category) => {
      return acc.concat(category.products);
    }, []);
  }, [productCategories]); 

  const value = { productCategories, products }; 

  return (
    <ProductsContext.Provider value={value}>
      {children}
    </ProductsContext.Provider>
  );
}

export function useProducts() {
  return useContext(ProductsContext);
}