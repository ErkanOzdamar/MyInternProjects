package D_DuzenlIf.zDuzenli_Not;





//REGEX:
//Eğer bir string verilen desene
//uyum sağlarsa buna match/eşleşme denir.
//
//Belli kriterlere uygun verileri alma
//arama yapma
//değiştirme
//regexlerle kolayca bu işlemler yapılabilir.

//java.util.regex.* şeklinde import edilmelidir



//BELİRTEÇLER:
//?=tek bir karakter yerine geçen joker karakter

//*=birden fazla karakter yerine geçen joker karakter

//m?=kendisinden önce belirtilen ifadenin metin içerisinde
//mevcut olmadığını belirtir.

//m*=kendisinden önce belirtilen ifadenin metin içerisinde
//mevcut olduğunu hatta tekrarlanacağını belirtir.

//m+=kendisinden önceki ifadenin tekrarlanacağını belirtir

//{n}=kendisinden önce belirtilen ifadenin n kez tekrarlanacağını
//belirtir.

//{n, }=kendisinden önce belirtilen ifadenin en az n kez
//tekrarlanacağını belirtir.

//{n, m}=Kendisinden önce belirtilen ifadenin en az n. en fazla m
//kez tekrarlanacağını belirtir




//SINIRLAYICILAR:
//^=String ifadenin başını belirtir.

//$=String ifadenin sonunu belirtir.

//\b=bir kelimeyi temsil eder
//\B=bir kelime haricindekiler

//\A=girilen ilk kelime

//\z=girilen son kelimedir,eğer sonlandırıcı bu ise

//\G=önceki eşleşmenin sonucunu verir

//matches()
//String s="bir";
//Boolean ara2=s.matches("bir");
//System.out.println(ara2);









//compile() regex nesnesini oluşturur.
//
//split() bir metni belirtilen kalıba göre parçalar/ayrıştırır
//ve listeye dönüştürür.
//
//replaceFirst() bir string ifade içerisindeki düzenli ifade
//ile eşleşen ilk karakteri değiştirir.
//
//replaceAll() bir string ifade içerisindeki düzenli ifade
//ile eşleşen tüm karakterleri değiştirir.
//
//group() ifadeleri dizi/liste içerisinde tutulur
//indis numarasına göre bu değerler döndürülür.
//((A)(B(C))) ifadesi ile 4 grup oluşturulabilir.
//
//find(),             end(),        start()
//eşleşmeleri bulur  bitiş indis     başlangıç indis



//LOCALE SINIFI:
//java dünyadaki bütün ülkelerin ve dillerin 
//alfabelerini yazabilir.tarih-saat,para gibi
//
//java.util.Locale şeklinde import edilmelidir
//
//Locale yerelNesne= new Locale("dil kodu", "ülke kodu"):
//veya
//Locale yerelNesne = Locale.forLanguageTag("tr-TR");



//DATE SINIFI:
//java.util.Date şeklinde import edilmelidir.
//başlangıcı: 01 ocak 1970 00:00:00 GMT 
//
//Date d=new Date(); nesne üretilir.
//Date() sınıfının
//getTime() metodu başlangıç anından o ana kadar geçen zamanı
//milisaniye cinsinden verir.
//aynı işlem;
//System.currentTimeMillis() metodu ile elde edilebilir.






//CALENDAR SINIFI:
//java.util.Calendar şeklinde import edilmelidir
//Calendar c = Calendar.getInstance(); nesne üretilir






































