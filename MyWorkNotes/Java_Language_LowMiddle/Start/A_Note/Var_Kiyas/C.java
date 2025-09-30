package Var_Kiyas;

//(var) Veri tipi nedir?
//
//Yerel değişken tanimlanirken kullanilir,global değişken tanimlamalarinda kullanilmaz.
//Başlangiçta bir değer tanimlanmasi zorunludur ve ilk tanimlanilan değişken tipi sonradan değiştirilemez
//String ise String kalir sayiysa sayi.
/*
import java.util.ArrayList;
class testLambda{
    public static void main(String[] args) {
        var integer = new ArrayList<Integer>();//dizi oluşturuldu tam sayi elemanlari barindiracaği belirtildi.
        integer.add(5); integer.add(9); integer.add(8);//diziye tam sayi atandi.
        integer.forEach( (n) -> {out.println(n); } );//dizinin elemanlari sirayla yazdiridi.
    }
}
*/



//KIYASLAMA
/*
import static java.lang.System.*;
class Java{
    public static void main(String[] args) {
        int a=12,b=5,c=28;
        out.println(Math.max(a,Math.max(b, c)));//a değeri önce b ile kiyaslanir ardindan büyük olan c ile kiyaslanir.
    }
}
*/

/*
class Java{
    public static void main(String[] args) {
        int A=5,B=4,C=3;
        boolean x,y,z;
        x=(A>=0) && (B==C);//(&&)iki koşulda doğruysa true değilse false.
        y=(A>=0) || (B==C);//(||)iki koşuldan birinin true olmasi çiktiyi true yapar.
        z=!(C>A) ^ (B<=C);//(^)iki koşulda ayni ise false değilse true
        System.out.print("x="+x+"\ny="+y+"\nz="+z);
    }
}
*/