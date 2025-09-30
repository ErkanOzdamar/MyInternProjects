package Veri_girişi;

//Konsoldan veri girişi:
//------------------------
//int a;
//a = new Scanner(System.in).nextInt();
//------------------------
//in = new Scanner(System.in);
//int a = in.nextInt();
//------Grafiksel---------
//int a;
//a = Integer.parseInt(JOptionePane.showInputDialog("parametre"));

//Scanner sinifina ait metotlar:
//nextInt();
//klavyeden girilen ifade tam sayi integer tipine çevrilir;
//int integer = new Scanner(System.in).nextInt();
//
//nextFloat();
//klavyeden girilen ifade ondalikli sayi türüne çevrilir;
//float a = new Scanner(System.in).nextFloat();
//
//nextDoulbe();
//klavyeden girilen ifade uzun ondalikli sayi türüne çevrilir;
//doubla a = new Scanner(System.in).nextDouble();
//
//next();
//klavyeden girilen kelimeyi okur,boşluk ifadesine kadar okumaya devam eder;
//String a = new Scanner(System.in).next();
//
//nextLine();
//klavyeden girilen tüm satiri okur;
//String a = new Scanner(System.in).nextLine();
//
//next().charAt(0);
//klavyeden girilen ifadenin ilk karakterini okur;
//char is = tara.next().charAt(0);

/*
import java.util.Scanner;
class Java{
    public static void main(String[] args) {
        
        float C;
        System.out.printf("Fahrenhayt:");
        Scanner tara = new Scanner(System.in);
        int F = tara.nextInt();
        C=(float)((F-32)/1.8);
        System.out.println("Celcius:"+C);

    }
}


/*
//Dik üçgen pisagor hesaplama:
import static java.lang.System.*;
import java.util.Scanner;
class Java{
    public static void main(String[] args) {
        Scanner tara = new Scanner(in);
        Float A,B,C;
        out.printf("A=");
        A = tara.nextFloat();
        out.printf("B=");
        B= tara.nextFloat();
        C = (A*A) + (B*B);
        C = (float)Math.sqrt(C);
        out.println("C="+C);
    }
}
*/


//Grafiksel veri giriş-çikişi:
//import javax.swing.JOptionPane;                    3-?, 2-!, 1-i, 0-X, -1-simge yok
//JOptionPane.showMessageDialog(null,"mesaj","başlik", simge numarasi);
//JOptionPane.showInputDialog(veri girişi-String tipinde-);
//JOptionPane.showConfirmDialog(onay-yes,no,cancel-);
//JOptionPane.showOptionDialog(seçim-seçenek sunabilme-);

/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hoşgeldiniz.", "Start", 2);
    }
}
*/
/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        String message = "A:Erkan Özdamar\n"+"B:Yaşar Özdamar\n"+"C:Emine Özdamar\n"+"D:Atakan Özdamar";
        JOptionPane.showMessageDialog(null, message, "Start", 2);
    }
}
*/
/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog("First integer:");
        String s2 = JOptionPane.showInputDialog("Second integer:");
        int num = Integer.parseInt(s1) + Integer.parseInt(s2);
        JOptionPane.showMessageDialog(null, num, "Start", 1);
    }
}
*/
/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        String s;
        float s1,s2;
        double num,minus,divided,multiply;
        s1 = Float.parseFloat(JOptionPane.showInputDialog("First:"));
        s2 = Float.parseFloat(JOptionPane.showInputDialog("Second:"));
        num = s1+s2;
        minus  = s1-s2;
        divided = s1*s2;
        multiply = s1/s2;
        s = s1 + "+" + s2 + "=" + num + "\n";
        s = s + s1 + "-" + s2 + "=" + minus + "\n";
        s = s + s1 + "*" + s2 + "=" + divided + "\n";
        s= s + s1 + "/" + s2 + "=" + multiply + "\n";
        JOptionPane.showMessageDialog(null, s, "Start", 1);
    }
}
*/
//JOptionPane.showConfirmDialog(null, "MESAJ", "BAŞLIK", düğmeler(-1,0,1,2), simgeler(0,1,2,3,-1));
//DÜĞMELER:
//0(yes-no)
//1(yes-no-cancel)
//2(ok-cancel)
//-1(default)
/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        out.println("Atakan bey:");
        int sonuc = JOptionPane.showConfirmDialog(null, "Kahve alir misiniz?", "Start", 0, 2);
        out.println((sonuc == 0) ? "Evet, lütfen" : "Hayir, teşekkürler");
    }
}
*/
//JOptinPane.showConfirmDialog(null,"MESAJ","BAŞLIK",DÜĞME,SİMGE,null,eklenen seçenekler,null);
//option kullanimi:
/*
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        
        String[] options = {"Evet", "Hayir", "Birazdan"};
        String message = "Kahve ister misiniz?";

        int choice = JOptionPane.showOptionDialog(null, message, "Start", 1, 2, null ,options, null);
        JOptionPane.showMessageDialog(null, options[choice]);
    }
}
*/
/*
import static java.lang.System.*;
import javax.swing.JOptionPane;
class Java{
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "Hoşgeldiniz", "Start", 2);
        String[] options = {"Kahve-95TL", "Su-10TL", "Çay-15TL", "Tatli-75TL", "Limonata-50TL"};
        String message = "Ne istersiniz?";
        int choice = JOptionPane.showOptionDialog(null, message, "Menü", 1, 2, null, options, null);
        JOptionPane.showMessageDialog(null, options[choice]);

    }
}
*/
