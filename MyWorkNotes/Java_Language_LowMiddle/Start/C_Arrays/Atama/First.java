package C_Arrays.Atama;



/*
public class First {
    public static void main(String[] args) {
        
        int A[]= new int[10];

        for(int i=0; i<10; i++){
            A[i]=i+1;
            System.out.println("Değer:"+A[i]);
        }
    }
}
*/

/*
public class First{
    public static void main(String[] args) {
        int A[]=new int[11];

        for(int i=0; i<=10; i++){
            if(i<=4){
            A[i]=i+1;
            }
            else{
            A[i]=11-i;    
            }
            System.out.println("değer:"+A[i]);
        }
    }
}
*/

/*
import java.util.Scanner;
public class First{
    private static Scanner input;
    public static void main(String[] args) {
        
        String Month[]={"", "ocak", "şubat", "mart", "nisan", "mayis", "haziran", "temmuz","ağustos",
    "eylül", "ekim", "kasim", "aralik"};
        input=new Scanner(System.in);
        int Months;
        System.out.print("Ay değerini giriniz:");
        Months=input.nextInt();
        if(Months>=0 && Months<=12){
            System.out.println(Months+".Ay:"+Month[Months]);
        }
        else{
            System.out.println("Hatalı ay numarası");
        }
    }
}
*/

/*
import java.util.Scanner;
public class First{
    private static Scanner input;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int b, a, i;
        int po= 0, ne =0;
        System.out.print("Kaç sayı gireceksiniz:");
        b = input.nextInt();
        
        for(i=1; i<=b; i++){
            System.out.print("\nSayıları giriniz:");
            a = input.nextInt();
            if(a>=0){
                po=po+1;
            }
            if(a<0){
                ne=ne+1;
            }
        }
        System.out.printf("pozitif sayısı:%d\n", po);
        System.out.printf("negatif sayısı:%d", ne);
    }
}
*/

/*
import java.util.Scanner;
public class First{
    public static void main(String[] args){

        int N=0, i=0, Random=0, x=0, num=0;
        Scanner input=new Scanner(System.in);
        System.out.print("Toplanacak eleman sayısı:");
        N=input.nextInt();
        int A[]=new int[N];
        System.out.println("Dizi boyutu:"+N+"\nDizi elemanları:");

        for(i=0; i<N; i++){
        Random=(int) (Math.random()*100)+1;
        A[i]=Random;
        num=num+A[i];
        System.out.println("A["+i+"]="+A[i]);
        }
        System.out.println("Toplam="+num);
    }
}
*/

/*
import java.util.Scanner;
public class First{
    public static void main(String[] args) {
       int toplam=0, i=0, Tam=0;
       int A[]={200, 100, 50, 20, 10, 5, 1};

       Scanner input=new Scanner(System.in);
       System.out.print("Veznedar girişi:");
       toplam=input.nextInt();
       input.close();

       for(i=0; i<=6; i++){
        Tam=(int)toplam/A[i];
        toplam=toplam-(A[i]*Tam);
        if(Tam!=0){
            System.out.println(Tam+" Adet "+A[i]+"TL");
        }
        
       }
       System.out.print("Vermelisiniz."); 
    }
}
*/

























































































































































































