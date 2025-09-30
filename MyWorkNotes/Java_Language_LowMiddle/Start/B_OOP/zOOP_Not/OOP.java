package zOOP_Not;

//NESNE YÖNELİMLİ PROGRAMLAMA (OOP):
//
//Bu yöntemde program nesnelerden oluşur,
//bu nesneler birbirleri ile etkileşim içindedirler.
//Bu bir disiplin/yaklaşımdır.
//
//package start; yöntemi birbiriyle ilişkili sınıfları birleştirmeye yarar.
//sınıf(class)
//nesne(object)
//kalıtım(ınheritance)
//sarmalama/kapsülleme(encapsulation)
//çok biçimlilik(polymorphism)
//soyutlama(abstraction)
//arayüz(ınterface)


//Bir sınıfa birbirinden bağımsız birden fazla nesne
//türetilebilir.

//Nesne türetimi için metotlar mevcuttur:
//1)Sınıf_adi nesne_adi=new Sınıf_adi();
//2)Araba kamyon=new Araba();
//"."operatörü;sınıf üyelerine erişilmesini sağlayan operatördür.

//Nesnelerin üç erişim etiketi vardır:

//PUBLİC:
//iç ve dış erişime açıktır,tüm fonksiyonlar tarafından erişilebilir.
//PRİVATE:
//farklı paket ve sınıflardan erişilemez,sadece tanımlı olduğu sınıf
//aracılığıyla erişilebilir.
//PROCTED:
//aynı paket ve sınıf içinden erişilebilir ancak paket dışına sadece 
//kalıtım ile oluşturulmuş alt-üst sınıflara aktarılabilir.
//DEFAULT:
//hiç bir etiket kullanılmamışsa sadece tanımlı olduğu paketten erişim
//sağlanabilir.


//Yapıcı metotların özellikleri:
//
//Bir sınıf yapıcısının adı,sınıf adı ile aynı olmalıdır.
//bir yapıcı metot geriye değer döndürmez.
//yapıcı metotlar parametreli veya paremetresiz kullanılabilir.
//bir sınıfın birden fazla yapıcı metodu(sınıf ismi aynı olmak şartıyla)olabilir.
//Yapıcı metotlar çağrılırken 'this' ve 'super' işaretçileri kullanılır.


//THIS-SUPER KULLANIMI:
//this;sınıf içindeki erişilecek nesneler için kullanılır
//this.nesneAdı; şeklinde kullanılır.

//super;bir üst sınıfa ait metoda erişmek için kullanılır
//super.metotAdı(); şeklinde kullanılır.


//KALITIM(Inheritance):
//Bir üst sınıfa ait değişkenlerin alt sınıflara
//Aktarılabilmesine kalıtım denir.
//Javada bir alt sınıfın sadece bir üst sınıfı bulunur.
//Ancak bir üst sınıfın birden fazla alt sınıfı bulunabilir.
//hiyerarşik şekilde üstten alta doğru sınıf sıralaması yapılabilir.


//EXTENDS:
//Aktarım sınıflar arası "extends" anahtar kelimesiyle yapılır.
//Alt sınıf bu metotla üst sınıfın özelliklerine sahip olabilir
//üst sınıf(türediği),alt sınıf(türeyen) olarak adlandırılır.
//Örnek:[class AltSınıf extends ÜstSınıf{}]
//Türeyen sınıfa ekstra özellikler eklenebilir.


//ÜZERİNE YAZMA-OVVERRİDİNG:
//Bir alt sınıf üst sınıfın işlevlerini değiştirebilir.


//PROTECTED:
//En üst sınıftan en alt sınıfa veri aktarılabilmesi için PROTECTED
//kullanılır.Protected ve private aynıdır yalnız private alt sınıflara
//erişimi engeller bu yüzden protected kullanılır.


                                    //   +public---------#protected-------/private
//------------------Aynı sınıf içerisinde:Evet-----------Evet-------------Evet
//-----Aynı paket içerisinde alt sınıftan:Evet-----------Evet-------------Hayır
//--Aynı paket içerisinde farklı sınıftan:Evet-----------Evet-------------Hayır
//-----Aynı paket içerisinde üst sınıftan:Evet-----------Evet-------------Hayır
//---Farklı paket içerisinde alt sınıftan:Evet-----------Evet(kalıtımla)--Hayır
//Farklı paket içerisinde farklı sınıftan:Evet-----------Evet-------------Hayır



//ENCAPSULATİON(Sarmalama):
//Paketleme ve kapsülleme olarak adlandırılabilir nesnel programlamanın 
//%90 dır.Private etiketiyle paketleme işlemi yapılır.
//Bu yöntem kullanıcıya sadece gerekli verilerin gösterilmesini sağlar
//bu sayede güvenlik ve kolaylık kazanılır.

//GETTER/SETTER METOTLARI:
//Private değerleri erişmek için bu metotlar kullanılır.
//Set/Get çiftleri set ön ekiyle kullanılanları private değerlerini değiştirmeye yarayan;
//get ön ekiyle kullanılanları private değerin return/gösterilmesini sağlayan ek çiftleridir.


//POLYMORPHİSM(Çok Biçimlilik):
//Aralarında kalıtım ilişkisi bulunan sınıfların ortak işlevlerinin
//sınıfına göre ayrı görevler atanabilmesi için kullanılan yetenektir.
//Örnek:köpek kedi farklı sınıflardır ortak işlevi ses çıkarmasıdır
//ancak köpek havlarken kedi miyavlar bu çeşitliliği sağlamak için
//bu yöntem kullanılır.



//INSTANCEOF:
//Belirtilen nesnenin doğru sınıfa ait olup olmadığını kontrol etmek için
//kullanılır;kullanım şekli:nesne instanceof tip şeklindedir.
//Hayvan instanceof köpek true sonucunu verecektir.



//ABSTRAC CLASS(Soyut sınıf):
//soyut sınıfın polymorphism yönteminden çok bir farkı yoktur
//soyut sınıflama da yeni bir nesne oluşturulamaz
//ancak soyut sınıfın alt sınıflarından nesne türetilebilir.




//INTERFACE(Arayüz):
//Bir arayüz ilgili sınıfının davranış ve özelliklerinin tanımlandığı kısımdır
//Bir arayüz tasarlandıktan sonra bir sınıfa atıf yapmazsa soyut bir sınıftan
//farkı kalmaz.atıf yapmak için sınıf ismi implements ınterface ismi kullanılır.
//bir arayüz içerisindeki tüm metotlar otomatik public belirteci alır.




















