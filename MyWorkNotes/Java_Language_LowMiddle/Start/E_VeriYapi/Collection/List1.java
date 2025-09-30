package E_VeriYapi.Collection;


//Vector ve ArrayList:
/*
import java.util.Vector;
public class List {
    public static void main(String[] args) {
        Vector<String>name=new Vector<String>();
        String[] StaticArray= {"abc", "def", "hir", "klm"};
        
        for(String names : StaticArray){
            name.add(names);
        }
            System.out.println("Vektörün ilk hali:");
            System.out.println(name);
            System.out.println("Eleman sayisi:"+name.size());

            name.set(2,"osman");
            name.add("ali");
            name.add("ayşe");

            System.out.println("Vektörün son hali:");
            System.out.println(name);
            System.out.println("Eleman sayisi:"+name.size());
            System.out.println("Ilk eleman:"+name.firstElement());
            System.out.println("Son eleman:"+name.lastElement());
        
    }
}
*/


//Dinamik dizi(ArrayList):
/*
import java.util.*;
public class List1 {
    public static void main(String[] args) {
        List<String> name=new ArrayList<String>();
        name.add("Adem");
        name.add("Ali");
        name.add("Nuh");
        name.add(1, "Musa");

        System.out.println("Eleman sayisi:"+name.size());
        System.out.println("Liste:"+name);

        System.out.println("Ilk eleman:"+name.get(0));
        name.remove(0);
        System.out.println("Yeni liste:"+name);
        boolean A=name.contains("Ali");
        System.out.println("Ali mevcut mu:"+A);
        name.clear();
        System.out.println("Boş liste:"+name);
    }
}
*/





//LinkedList:
/*
import java.util.*;
public class List1 {
    public static void main(String[] args) {
        LinkedList<String> bList=new LinkedList<>();
        //Bağlı liste tanımlandı.
        bList.add("Mavi");
        bList.add("Gri");
        bList.add("Sari");
        bList.add(2, "Mor");
        //Bağlı listeye eleman eklendi
        System.out.println("Boyutu:"+bList.size());
        System.out.println("Renk listesi:"+bList);

        bList.addFirst("Siyah");
        bList.addLast("Beyaz");
        System.out.println("Boyutu:"+bList.size());
        System.out.println("Renk listesi"+bList);

        bList.removeLast();
        bList.remove(2);
        System.out.println("Boyutu:"+bList.size());
        System.out.println("Renk listesi:"+bList);

        bList.sort(null);
        System.out.println("Sirali liste:"+bList);
        
        var pointer1=bList.listIterator();
        //bir iteretör nesnesi oluşturuldu.
        System.out.println("\nBaştan sona gezinti:");
        while(pointer1.hasNext()){
            System.out.println(pointer1.next()+"->");
        }
        System.out.println("");
        System.out.println("\nSondan başa gezinti:");
        while(pointer1.hasPrevious()){
            System.out.println(pointer1.previous()+"<-");
        }
    }
}
*/







//Queue yapısı:
/*
import java.util.*;
public class List1 {
    public static void main(String[] args) {
        List<String> list = List.of("AJ", "BJ", "CJ");

        Queue<String> kyrk = new LinkedList<String>(list);
        kyrk.offer("Sare");
        kyrk.add("Rana");
        System.out.println(kyrk);
        kyrk.poll();
        System.out.println(kyrk);

        System.out.println("Kuyruktan elemanlar çikartiliyor:");
        while(!kyrk.isEmpty()){
            System.out.println(kyrk.remove());
        }
        System.out.println(kyrk);
    }
}
*/




//Priority Queue:
/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
        List<String> list=List.of("Bade", "Ali", "Can");

        PriorityQueue<String> kyrk=new PriorityQueue<String>(list);
        kyrk.offer("Sare");
        kyrk.add("Rana");
        System.out.println(kyrk);

        System.out.println("Elemanlar çikartiliyor");
        while(!kyrk.isEmpty()){
            System.out.println(kyrk.remove());
        }
        System.out.println(kyrk);
    }
}
*/



/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
        Deque<String> ygn = new LinkedList<String>();
        ygn.push("Bade");
        ygn.push("Erkan");
        ygn.push("Samet");
        System.out.println(ygn);
        System.out.println(ygn.peek());
        System.out.println("Elemanlar sıra ile çıkartılıyor:");
        while(!ygn.isEmpty()){
            System.out.println(ygn.pop());
        }
        System.out.println(ygn);
    }
}
*/




/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
        Set<Integer> küme1 = Set.of(2, 3, 5);
        Set<Integer> küme2 = Set.of(7, 3, 5, 9);
        Set<Integer> küme = new HashSet<Integer>(küme1);

        küme.add(4);
        küme.addAll(küme2);
        System.out.println(küme);
    }
}
*/



/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
        TreeSet<String> ts1 = new TreeSet<String>();
        ts1.add("A");
        ts1.add("B");
        ts1.add("7");
        ts1.add("C");
        ts1.add("C");

        System.out.println(ts1);

        var ts2 = new TreeSet<String>(Collections.reverseOrder());

        for(String s:ts1){
            ts2.add(s);
        }

        System.out.println(ts2);
    }
}
*/





/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
LinkedHashSet<Integer> km=new LinkedHashSet<Integer>(Arrays.asList(5, 7, 2, 9));
km.add(6);
System.out.println(km);
km.remove(7);

        var array=km.toArray();
        int s=0;
        for(var i:array){
    System.out.println("\n"+s+".eleman:"+i);
    s++;
      }
   }
}
*/





/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
        Map<String, String> szlk =new HashMap<>();
        szlk.put("bir", "one");
        szlk.put("iki", "two");
        szlk.put("üç", "three");
        szlk.put("dört", "four");
        szlk.put("beş", "five");
        System.out.println(szlk);
    }
}
*/





/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Map<String, String>szlk = new TreeMap<>();
        szlk.put("bir", "one");
        szlk.put("iki", "two");
        szlk.put("uc", "three");
        szlk.put("dört", "four");
        szlk.put("bes", "five");
        
        System.out.println(szlk);
        System.out.println("Aranan kelime:");
        String ara=scan.next();
        
        if(szlk.containsKey(ara)){
            System.out.println(szlk.get(ara));
        }
        else{
            System.out.println("Sözlükte yoktur");
        }
    }
}
*/








/*
import java.util.*;
public class List1 {

    public static void main(String[] args) {
        Hashtable<Integer, String> il=new Hashtable<>();
        il.put(6, "Ankara");
        il.put(24, "Erzincan");
        il.put(26, "Eskişehir");
        il.put(34, "İstanbul");
        il.put(60,  "Tokat");
        System.out.println(il);

        Iterator<Integer> plaka=il.keySet().iterator();
        Iterator<String> ilAd=il.values().iterator();
        while(plaka.hasNext()){
            System.out.println(plaka.next()+":"+ilAd.next());
        }
    }
}
*/















































