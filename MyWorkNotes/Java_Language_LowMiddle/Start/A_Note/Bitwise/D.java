package Bitwise;

//Bit işlem(Bitwise) Operatörleri:
//
//ikilikleri decimal hale getirmek:
//
//1101 ikilik sayısının; sağdan sola doğru konumlarını belirleyin.
//3210 birler basamağı 0dan başlar her konum 2^x olarak değerlendirilir.
//basamak 1 ise işleme alınır basamak 0 ise işleme alınmaz.
//tek tek her bitin katkısı 2^x den belirlenip toplanır:
//8+4+0+1=13 ikili bitsel olarak 1101 olarak temsil edilir. 
//
//&(ve)   3 & 5 sonuç:1  true&true=true
//        0011           true&false=false
//        0101           false&false=false
//        0001------->1
//|(veya) 3 | 5 sonuç:7  true&true=true
//        0011           true&false=true
//        0101           false&false=false
//        0111------->7
//^(özel veya) 3 ^ 5 sonuç:6  true&true=false
//             0011           false&false=false
//             0101           true&false-false&true=true
//             0110------->6
//>> sağa kaydır 9>>2 sonuç:2
//             1001
//             >> 2
//             0010-------->2 
//<< sola kaydır 3<<2 sonuç:12
//             0011
//             << 2
//             1100-------->12
//>>> sağa kaydır(işaretsizler) -4>>>28 sonuç:15
//bu operatörler(=)eşitlik ile kıyaslamalarda kullanılabilir.
//
//Javada Sayı Sistemlerinin Birbirine Döünüşümü
//
//ikili-Integer.toBinaryString(15)****decimal sayıları string tipinde 
//onaltılı-Integer.toHexString(15)  **bit versiyona dönüşümü.
//sekizli-Integer.toOctalString(15)**
//
//string tipli bitlerin, decimal sayılar hale getirilmesi.
//parseInt("sayı", taban) komutu kullanılır.
//
//ikili-Integer.parseInt("1111", 2)=15 
//onaltılı-Integer.parseInt("F", 16)=15  
//sekizli-parseInt("17", 8)=15

/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        int X;
        String Y;                                             
          //burada string-int dönüşümü yapılır             //burada veri string tipinde alınır çünkü showInput böyle çalışır.
        X=Integer.parseInt(JOptionPane.showInputDialog("bit versiyona Dönüştürmek istediğiniz decimal veriyi giriniz:")); 
        //int tipindeki decimal sayının bit versiyonu kullanıcıya gösterilebilmesi için tekrar string tipinde bit versiyona çevrilir. 
        String ikili=Integer.toBinaryString(X);
        JOptionPane.showMessageDialog(null, ikili, "Start", 2);

        //zaten bit string tipinde olduğu için int tipine çevirmeye ihtiyaç duyulmaz.
        Y=(JOptionPane.showInputDialog("Decimal versiyona dönüştürmek istediğiniz bit veriyi giriniz:"));
        //ikili-bit tipindeki sayının tekrar int tipine dönüşümü sağlanır.
        int ikili_onluk=Integer.parseInt(Y, 2);
        JOptionPane.showMessageDialog(null, ikili_onluk, "Start", 2);
    }
}
*/