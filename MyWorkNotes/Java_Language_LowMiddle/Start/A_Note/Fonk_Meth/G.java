package Fonk_Meth;

import javax.swing.JOptionPane;

//Fonksiyonlar-Metotlar(java)
//Metotlar ikiye ayrılır,parametreli(dışarıdan değer alan) veya parametresiz(dışarıdan değer almayan). 
//parametresiz metotların isminden önce void kullanılır.
//parametreli metotlar return ile kullanılır.

//1.yol
/*
class Java{
    void Kartvizit(){
        System.out.println("Dr.Özdamar");
    }
    public static void main(String[] args) {
        Java nesne = new Java();
        nesne.Kartvizit();
    }
}
*/
//2.yol
/*
class Java{
    static void Kartvizit(){
        System.out.println("Dr.Özdamar");
    }
    public static void main(String[] args) {
        
        Kartvizit();
    }
}
*/

/*
import javax.swing.JOptionPane;
class Java{
static void FizzBuzz(){
String message1="FizzBuzz";
String message2="Fizz";
String message3="Buzz";
    for(int i=1; i<=100; i++){
        if(i%15==0){
            JOptionPane.showMessageDialog(null, message1, "Game", 2);
        }
        else if(i%5==0){
            JOptionPane.showMessageDialog(null, message2, "Game", 2);
        }
        else if(i%3==0){
            JOptionPane.showMessageDialog(null, message3, "Game", 2);
        }
        else{
            String message4=i+",";
            JOptionPane.showMessageDialog(null, message4, "Game", 2);
        }
    }
}
public static void main(String[] args) {
    FizzBuzz();
}
}
*/


//Static belirteci:
//Global değişken tanımlamada kullanılır,global değişkenler static özelliktedir.
//Bir static değişken programın çalışması boyunca bellekten kaybolmaz.
//Yerel değişkenler static ön ekini almazlar.
//Static değişken new metotu kullanılmadan doğrudan çağrılabilir.
/*
class Java{
    
    static int enb(int x, int y, int z){
        return Math.max(Math.max(x,y),z);
    }
    static int enk(int x, int y, int z){
        return Math.min(Math.min(y, z),x);
    }

    public static void main(String[] args) {
        int a=12, b=16, c=3;
        System.out.println("max:"+enb(a, b, c));
        System.out.println("min:"+enk(a, b, c));
    }
}
*/

//Bir metoda dışardan değer aktarılabilir;argüman denir.
//iki şekilde aktarım yapılabilir 
//Doğrudan değer aktarımı 
//Referans ile değer aktarımı
//Aksi bildirilmedikçe doğrudan aktarım yapılır
//ve ana programdaki değerlerini korurlar.

/*
import java.util.Scanner;
class Java{
    private static Scanner gir;

    static double cevir(double n){
        return ((n-32)/1.8);
    }
    public static void main(String[] args) {
        double F, C;
        System.out.println("Fahrenayt değeri:");
        gir = new Scanner(System.in);
        F = gir.nextDouble();
        C = cevir(F);
        System.out.println(C+" derecedir");
    }
}
*/

//Eğer programa değer değilde referansları aktarılırsa
//değişken değerinde yapılan değişiklik ana programda da etkili olacaktır.
//Metotlara değişken referansı aktarmak için 'SınıfAdı.değişken'
//yapısı kullanılır.

/*
class Java{
    static int s1= 4;

    static void refFonk(int s1){
        Java.s1 = 8;
    }

    static void degFonk(int s1){
        s1 = 8;
    }

    public static void main(String[] args) {
        System.out.println("Değeri al işle");
        degFonk(s1);
        System.out.println("S1:"+s1);
        System.out.println("Referans al işle");
        refFonk(s1);
        System.out.println("S1:"+s1);

    }
}
*/

//Özette de belirtildiği gibi değere göre fonksiyonda değişken
//değişmez ancak referansa göre atanmış fonksiyonlarda değişken
//değişir.

/*
import javax.swing.JOptionPane;
class Java{
    static int s1 = 0;
static void Fonk(int s1){
    String message3=s1+":Çift";
    String message2=s1+":Tek";
    if(s1%2==0){
JOptionPane.showMessageDialog(null, message3);    
    }
    else{
JOptionPane.showMessageDialog(null, message2);
    }
}
public static void main(String[] args) {   
String message1="Rastgele 10 sayinin tek/çift olduğunu belirleyen program:";
JOptionPane.showMessageDialog(null, message1);    
for(int i=0; i <=9; i++){
    s1 = (int)(Math.random()*100);
    Fonk(s1);
        }
    }
}
*/


//Metotların Aşırı Yüklenmesi(Method Overloading):
//Aymı metot adıyla farklı veri tiplerine ve parametrelere sahip birden fazla
//metot tanımlanabilir.

/*
class Java{
    static int num(int x , int y){
        return x+y;
    }
    static double num(double a, double b, double c){
        return a+b+c;
    }

    public static void main(String[] args) {
        int message1=num(3, 5);
        double message2=num(3.2, 4.5, 6.7);
        JOptionPane.showMessageDialog(null, message1, null, 0);
        JOptionPane.showMessageDialog(null, message2, null, 0);
    }
}
*/

//Özyinelemeli Metotlar(Recursive Methods):
//Kendini doğrudan veya dolaylı olarak çağıran metotlara denir.
//Faktöriyel işlem özyinelemeye örnektir;
//int i,f=1;
//int n=(girilen değişken);
//for(i=n; i>=1; i--){
//f=f*i;
//}
//Bu tekrarlı döngüsel bir algoritmadır çünkü,koşul gerçekleştiği
//sürece aynı işlemler gerçekleşmektedir.
//Bu algoritmanın özyinelemeli hali şu şekilde kodlanmalıdır:
 
/*
class Java{

    static int fakt(int n){
        //n<=1 ? return n:n*fakt(n-1)
        //=>
        if(n <= 1){
            return n;
        }
        else{
            return (n * fakt(n-1));
        }
    }
    public static void main(String[] args){

int n=Integer.parseInt(JOptionPane.showInputDialog("A:"));
        String message=n+"!="+fakt(n);
        JOptionPane.showMessageDialog(null, message, null, 2);
    }
}
*/