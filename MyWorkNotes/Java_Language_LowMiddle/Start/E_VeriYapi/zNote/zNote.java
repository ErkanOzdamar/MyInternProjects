package E_VeriYapi.zNote;





//START:
//
//                                          Collection
//           List                  Set                      Queue                   Map
//           
//           ArrayList             HashSet                  LinkedList              HashMap
//           LinkedList            LinkedHashSet            PriorittyQueue          Hashtable 
//           Vector                TreeSet                  Dequeue                 TreeMap



//COLLECTION SURFACE:
//Birden çok nesneyi aynı grupta toplar, bu nesneler için ortak metotlar
//barındıran bir arayüzdür.(küme(set)-Liste(List)-Kuyruk(Queue)olmak üzere 
//üç çeşit ana koleksiyon tipi vardır.



//LIST(liste) SURFACE:
//Aralarında belli bir öncelik sonralık sıralaması olan sıralı veri topluluğudur.
//Arama, sıralama, ters çevirme, ekleme, silme gibi işlemler yapılabilmesine sağlar
//bir çeşit dizi işlevi görür kullanım kolaylığı sağlar, hazır metotlarının bulunması kod
//tasarrufu sağlar.



//Liste türleri; küçük bir liste; List<String> ad = List.of("Ali", "Veli", "Bade");

//dinamik dizi   ArrayList        List<String> ad = new ArrayList<String>(); 
//Vektör         Vector           Vector<String> ad = new Vector<String>(); 
//Bağlı Liste    LinkedList       List<String> ad= new LinkedList<>();
//Not: Veri tipi olarak temel veri tiplerinin nesnesel karşılığı (Integer; String gibi) olan tipler kullanılır.




//Küme Türleri;   Küçük Bir Set;          Set<Integer> no = Set.of(2, 3, 5);

//Karma küme            HashSet                 Set<Integer> no = new HashSet<Integer>();
//Ağaç Kümesi           TreeSet                 TreeSet<Integer>no=new TreeSet<Integer>();
//Bağlı liste kümesi    LinkedHashSet           Set<Integer> no = now LinkedHashSet<Integer>();
//Not: Veri tipi olarak temel veri tiplerinin nesnesel karşılığı (Integer; String gibi) olan tipler kullanılır. 





//QUEUE SURFACE:
//Eleman ekleme işleminin listenin sonundan, çıkarma işlemlerinin listenin başında yapıldığı
//bir yapı çeşitidir.Ancak Deque yapısı listenin hem başından hem sonundan ekleme çıkarma işlemi
//yapma imkanı sağlar (First-in-first-out) mantığı ile çalışır.Yığın(stack) yapıları ise kuyruk yapılarından
//farklı olarak (last-ın-fırst-out) mantığı ile çalışır.



//Kuyruk Türleri     küçük bir kuyruk      List<String>lst=List.of("Ali","Veli","Bade");
//                                         Queue<String>ad=new LinkedList<>(lst);

//Bağlı Liste        LinkedList            Queue<String>ad=new LinkedList<String>();
//Öncelik kuyruğu    PrioritQueue          PriorityQueue<String>ad=new PriorityQueue<>();

//Yığın(Stack)       DeQue                 Deque<String>ad=new LinkedList<String>();
//                                         ArrayDeque<String>stack=new ArrayDeque<>();
//                                         Stack<String> stack=new Stack<String>();





//MAP(Eşlem) SURFACE:
//Map; birbirinden virgüllerle ayrılmış 'anahtar, değeri'/'key, value' eşleşen veri yapılarıdır.
//bir anahtar sadece bir değer ile eşleşebilir anahtar bu yüzden tekildir.
//
//Hashmap yapısı elemanları karışık yerleştirilir
//TreeMap yapısı elemanlar ağaç yapısında sıralı olarak yerleştirilir
//LinkedHashMap yapısı elemanları çift yönlü bağ ile birbirlerine bağlanır 


//Map Türleri;        Küçük bir Map;               Map<String, Integer> adNo = Map.of("Ali", 1, "Veli", 2, "Bade",4);
//
//Karma Map           HashMap                      Map<String, Integer> adNo=new HashMap<String, Integer>();
//Ağaç Map            TreeMap                      Map<String, Integer> adNo=new TreeMap<String, Integer>();
//Bağlı Liste Map     LinkedHashMap                Map<String, Integer> adNo=new LinkedHashMap<String, Integer>();

//Karma Tablo
//Hashtable
//Hashtable<String, integer> adNo=new Hashtable<String, Integer>();
//Not: Veri tipi olarak temel veri tiplerinin nesnesel karşılığı (Integer; String gibi) olan tipler kullanılır. 









//Metotlar:                    Açıklama:
//
//add(e)                       'e'elemanını ekler

//addAll(c)                    'c'koleksiyonundaki tüm elemanları ekler

//remove(i)                    indis numarası verilen elemanı siler

//removeAll(c)                 'c'koleksiyonundaki tüm elemanları siler

//clear()                       Bütün elemanları siler, koleksiyonu boşaltır.

//size()                        toplam eleman sayısını verir

//contains(b)                   eğer 'b' elemanını içeriyorsa true değerini döndürür       

//containsAll(c)                'c'deki tüm elemanları içeriyorsa true değerini döndürür

//isEmpty()                      hiç eleman yoksa(boşsa) true değerini döndürür

//indexOf(e)                     'e' elemanının indisini verir.Eleman yoksa -1 değerini döndürür

//firstElement()                 ilk elemanı döndürür

//lastElement()                  en son elemanı döndürür

//get(indis)                     indis numarasının gösterdiği elemanı verir

//set(indis, "b");               İndis numarasının gösterdiği elemanı (b) olarak değiştirir

//toArray()                      koleksiyonu diziye dönüştürür

//listIterator()                 bir işaretçi(pointer)mantığı ile listedeki elemanlar üzerinde işlem
//yapar.


//sort()/reverse()               Listedeki elemanları sıralamak için Collections.sort(),ters sırada
//                               işlemek içinse Collections.reverse() metotları kullanılır.

//forEach()                      Tüm elemanları alt alta listeler.
//                               c.forEach(x->System.out.println(x));




//ITERATOR SURFACE:
//Klasik dizide o dizinin elemanlarına erişebilmek için indis numaraları kullanılır;
//ancak koleksiyon elemanlarına ulaşabilmek için onlara ait işaretçiler(Iterator) kullanılır.
//
//MAP yapıları için;
//Iterator<Integer> isaretci = mapNesnesi.keySet().iterator();
//Iterator<String> isaretci = mapNesnesi.values().iterator();

//ArrayList için;
//Iterator<Tip> isaretci =arrayNesnesi.iterator();





//Önce hangi koleksiyon sınıfı için gerekiyorsa,ona ait bir iterator değişkeni tanımlanır.
//sonra da bir döngü içerisinde bir sonraki eleman olduğu sürece
//(isaretci.hasnext()==true) isaretci.next() metodu ile koleksiyon elemanları taranır.
//
//while(isaretci.hasNext()){
//System.out.print(isaretci.next());
//}

//LISTITERATOR SURFACE:
//List arayüzünü kullanan sınıflar için Iterator yerine ListIterator kullanılır.Elemanlar arasına 
//ileri-geri yönlü hareket imkanı sağlar.Bir işaretçi(pointer) mantığı ile listedeki elemanlar üzerinde
//işlem yapar.
//
//ListIterator<Tip> isaretci = liste.listIterator();
//Önemli Metotları:
//
//next()              bir sonraki elemanı çağırır.
//hasNext()           bir sonraki eleman var mı kontrol eder
//previous()          bir önceki elemanı çağırır
//hasPrevious()       bir önceki eleman var mı kontrol eder 
//remove()            next() ile döndürülen son elemanı siler.





























































