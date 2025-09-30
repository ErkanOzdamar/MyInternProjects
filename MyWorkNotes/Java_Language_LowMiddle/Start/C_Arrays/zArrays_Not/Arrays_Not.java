package C_Arrays.zArrays_Not;






//ARRAY:
//1-Dizilerin atanması:
//Tipi Dizi_Adı[] = new Tipi[Eleman Sayısı];
//int dizi_Ad[] = new int[100];

//2-Dizilerin atanması:
//int []A= new int[5];
//int A[]=new int[5];

//int A[];
//A=new int[];

//int N=6;
//int A[]=new int[N];

//int A[]={8, 9, 12, 4, 1};

//3-Karakterlerin atanması:
//char A[] = new char[3];
//char A[] = {'s', 'a', 'u'};

//String day[]=new String[7];
//String day[]={"Pazartesi", "Sali", "Çarşamba", "Perşembe"};

//int A[boş]={sonsuz}; atanan eleman kadar dizide yer oluşur.



//AKTARIM:
//Tip MetotAdı(tip diziadi[])-----void TakeNote(int Nt[])


//DİZİ ELEMANLARINI BAŞKA BİR DİZİYE KOPYALAMAK:
//int A[]={1, 2, 3, 4};
//int B[]=A;
//======ALTERNATİF=======
//System.arraycopy(A, 0, B, 0, 10);
//System.arraycopy(A, başlangıç, B, başlangıç, eleman sayısı);




//SIRALAMA:
//Sıralama belli bir anahtar sözcük(keyworld) ile yapılır,
//yaygın kullanımlar şu şekildedir;
//buuble-Sort
//Insertion-Sort
//Selection-Sort
//Quick-Sort

//QUİCK SORT(Diğerlerinden farklı olarak yerleşik):
//import static java.util.Arrays.sort; şeklinde import edilir



//DİZİLERDE ARAMA:
//doğrusal arama(linear)(küçük boyutlular için) ve ikili arama(büyük boyutlular için) olarak ikiye ayrılır.
//binarySearch(Dizi_Adı, Aranan);(ikili arama kullanımı)(yerleşik metot)



//İKİ BOYUTLU DİZİLER:
//
//int A[][]=new int[3][3];
//2 2 2--->[0][2]
//2 1 2
//2 2 2
//atama:
//1.satır 3.sütun A[0][2]=2; ifadesi kullanılır. 
//dizi oluşturma:
//3 satır 3 sütunlu A[3][3] ifadesi kullanılır.
//3 türlü oluşturma yapılabilir:

//float[][]B=new float[3][3];

//float[][] B;
//B=new float[3][3];

//float[3][3] B={ {x, x, x}, {x, x ,x}, {x, x, x} };

//özelleştirmeler için çift for kullanılması gerekir. 




//MATRİSLERE OTOMATİK İLK DEĞER VERME İŞLEMİ:
//
//
//3  5  9
//4  6  1
//1  8  2
//Matrisinin ataması:
//
//int A[3][3]={ {3,5,9}, {4,6,1}, {1,8,2} }; doğrudan atama.




//ÇOK BOYUTLU DİZİLER:
//A[3][5][4] ifadesi şu anlama gelir:
//4 adet 3 satır, 5 sütun.
//double A[][][]=new double[10][7][3]; 210 elemanlı bir dizi



//KARAKTER DİZİLERİ(STRİNG METOTLARI):
//char A[]="HANZAR";
//A[0]="H" ifade eder.
//
//System.out.println(A.charAt(0));==H ifadesini verir

//System.out.println((int)'\0'); //0 sonucunu verir.
//System.out.println((int)'0'); //48 sonucunu verir.

//String veri grubu i.in next()-nextLine() metotları 
//kullanılır.

//next()--> boşluk kısma kadar veri alır.
//nextLine()--> tüm satırı veri alır.

//String ifadeleri karşılaştırılerken == ifadesi değil
//equals() metodu kullanılır.
//örnek: if(A.equals(B)) A ve B nin eşitliğini kıyaslayacaktır

//String metotlarına internetten ulaşabilirsin.
//Character sınıfıne ait metotları internetten bulabilirsin.




//StringBuilder SINIFI:
//İfade birleştirme ve ekleme için kullanılır.
//
//StringBuilder A = new StringBuilder();
//
//append() karakter dizisinin en sonuna ekleme yapar.
//capacity() geçerli kapasite değerini döndürür
//delete(int start, int stop); start ve stop indisleri arasındaki karakteri
//siler.
//replace(int start, int stop, String str); start ve stop indisleri arasındaki 
//karakterleri yeni karakterlerle değiştirir.
//deleteCharAt(int index) indis numarası verilen karakteri siler.
//insert(int eklemeyeri, String str)Karakter dizisinin istenen yerine ekleme
//yapar
//reverse() karakter dizisini ters çevirir
//setCharAt(int indis, char ch) indis numarası ile belirtilen yere istenilen 
//karakteri ekler
//setLength(int yeniBoyut) karakter dizisinin uzunluğunu arttır veya kısaltır.




//String->sayısal dönüşümleri:
//toString()-valueOf() metotları kullanılır.
//sayısal->string dönüşümleri:
//parse() metodu kullanılır.








