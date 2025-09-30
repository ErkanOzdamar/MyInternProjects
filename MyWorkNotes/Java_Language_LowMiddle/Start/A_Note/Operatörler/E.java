package Operatörler;

//[if-else-else if-switch case]:
//-Eğer koşuldan sonra tek bir satır yazılacaksa süslü parantez kullanılmayabilir.
//if(A||B && C||D){} duruma göre kullanılabilir method.
//Switch(değişken){} için değişken kesir sayı (float,double) olamaz.
//switch(A/2){
//case 48: 
//out.print(A); break;
//case 24:
//out.print(A); break;
//case 12:
//out.print(A); break;
//case 6:
//out.print(A); break;
//case 3:
//out.print(A); break;
//default:
// out.print("0"); break; }
//
//break case yolundan çıkış için gereklidir.aksi takdirde switch tüm caseleri gezer break kullanarak kırılmadığı takdirde!
//default geçerli bir case yolu seçilmedğinde gidilecek yoldur.
//
//if alternatifi:
//y = (x>0)? 1:-1; (x 0dan büyük ise çıktı 1 değilse *1)

/* 
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        String[] options = {"Evet,teşekkürler.", "Hayir,teşekkürler.", "Birazdan"};//0-1-2 soldan sağa indexler.
        String message ="Kahve ister misiniz?";
        int choice = JOptionPane.showOptionDialog(null, message, "Start", 1 , 2, null, options, null);
        
        if(choice==2){
            int code=2;
            String message1 = "30 dakika sonra:Buyrun efendim ne alirdiniz?";
            String[] options1 = {"Süt lütfen", "Tatli lütfen", "kahve lütfen"};
            int choice1= JOptionPane.showOptionDialog(null, message1, "Start", 1 , 2, null, options1, null);
            String garson= (code>choice1)? "Afiyet olsun efendim.":"Buyrun efendim.";
            JOptionPane.showMessageDialog(null, garson, "Start", 2);
        }
        else{
        switch(choice){
            case 0: JOptionPane.showMessageDialog(null, "Buyrun efendim.", "Start", 2); break;
            case 1: JOptionPane.showMessageDialog(null, "Rica ederiz.", "Start", 2); break;
   }
  }
 }
}
*/



//[for-while-do/while]
//for sonu belirli olan döngüdür.
//while-do/while koşula bağlı döngüdür.
//
//for(s=0; s<=5; s+=1/s++/s=s+1){T=T+s;}
//s 5 olana kadar toplamda 6 defa for döngüsü çalışır ve parantez içindeki kodu 6 defa yürütür.
//
//s=0; t=0; while(s<5 || t<5){s+=1; t=t+s;} döngü iki koşuldan biri bile true olsa çalışmaya devam edecektir ikisi de false olduğu anda sonlanır.
//s=0; t=0; do{s+=1; t=t+s;}while(s<5 || t<5); döngünün do ile başlaması koşul sağlanmasa bile kodun bir kez başlangıçta yürütülmesini sağlar.
//
//while(true){kod} sonsuz döngü.
//for(;;){kod} sonsuz döngü.
//forEach metodu karşına çıkabilir.

/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        int elemans=0;
        int sum=0;
        String message1="Kaç sayinin ortalamasini almak istiyorsunuz?";
        String message2="Lütfen elemanlarinizi giriniz";
        int staff=Integer.parseInt(JOptionPane.showInputDialog(message1));
        JOptionPane.showMessageDialog(null, message2, "Start", 2);
        for(int i=0; i<staff; i++){
        elemans=Integer.parseInt(JOptionPane.showInputDialog("eleman:"));
        sum=sum+elemans;
        }
        float average= (float)sum/staff;
        String result="Ortalamaniz: "+average+"!";
        JOptionPane.showMessageDialog(null, result, "Start", 2);
    }
}
*/

/*
class Java{
    public static void main(String[] args) {

        System.out.print("\t1\t2\t3\t4\t5\t6\t7\t8\t9");
        System.out.print("\n\t------------------------------------------------------------------\n");
        for(int i=1; i<=9; i++){

            System.out.printf("%d\t|",i);
            for(int j=1; j<=9; j++){
                System.out.printf("%d\t", i*j);
            }
            System.out.println("");
        }
    }
}
*/



//java.lang import edilmeyebilir.Çünkü kütüphanede mevcuttur.
//java.util import edilmelidir.
//
//1-10 arası rastgele sayı üretmek:
//int rastgele = (int) (Math.random()*10)+1;
//+dan sonraki sayı başlangıç noktasını *dan sonraki sayı bitiş noktasını belirtir.
//----Alternatif-------------------------------------------------------------------
//Random rnd=new Random();
//int rastgele =1+rnd.nextInt(10);
//1-11 arası rastgele sayılar üretir.

/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        int rastgele;
        for(int i=0; i<=10; i++){
            rastgele = (int) (Math.random()*10)+1;
            JOptionPane.showMessageDialog(null, rastgele, null, 2);
        }
    }
}
*/

/*
import java.util.Random;
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        
String message1="Sayi tahmin oyununa hoşgeldiniz.";
String message2="Tahmininiz:";
String message3="Tahmininiz doğru sayidan büyük.";
String message4="Tahmininiz doğru sayidan küçük.";
int frequency=0;
int limit=0;
int True=0;
int points=0;
JOptionPane.showMessageDialog(null, message1, "Start", 2);
Random rnd=new Random();
True=0+rnd.nextInt(100);
while(true){
limit=Integer.parseInt(JOptionPane.showInputDialog(message2));
frequency+=1;
points+=10;

if(limit>True){
    JOptionPane.showMessageDialog(null, message3, "Start", 2);
}
else if(limit<True){
    JOptionPane.showMessageDialog(null, message4, "Start", 2);
}
else if(limit==True){
    String message5="Skorunuz:"+points+"  Tahmin sayiniz:"+frequency+"  Tebrikler.";
    JOptionPane.showMessageDialog(null, message5,"Start", 2);
    break;
}
       }
    }
}
*/