package Atamalar;


/*
class Java{
    public static void main(String[] args) {

        System.out.printf("");//%d-%f gibi kisaltmalari
//kullanabilmek için printf kullanilir.

        System.out.println("");//("b1:"+A)-Atanmiş bir
//A değişkeni varsa %d gibi bir ifade kullanmadan direkt yazdirmayi sağlar ve otomatik alt satira geçer

        System.out.print("");//println ile ayni ancak alt satira geçmez

    }
}
*/


//boolean           true/false        8bit
//char              {'a','b','c'}     16bit

//byte        8bit   *
//short       16bit    *
//                      *Tam sayi veri tipleri.
//int         32bit    *
//long        64bit  *

//float      32bit ***
//                     *Kesirli sayi veri tipleri.
//double     64bit ***

//boolean örnek:
/*
class Java{
    public static void main(String[] args) {
        boolean b1=true;
        boolean b2=false;
        System.out.println("b1:"+b1);
        System.out.println("b2:"+b2);
    }
}
*/

/*
class Java{
    public static void main(String[] args) {
        
int integer1=1;
long integer2=2L;
short integer3=3;
byte integer4=4;

double double1=1.1D;
float float2=2.2F;

char charA='A';

System.out.printf("%d\n%d\n%d\n%d\n%f\n%f\n%c",integer1, integer2, integer3, integer4, double1, float2, charA);

    }
}
*/

//Veri tipi dönüşümleri:
//
//byte->short->int->long->float->double(otomatik dönüşümler)
//
//float price=45; ifadesi geçerlidir ancak
//int price=3.2; ifadesi geçersizdir.
//
//Dönüşüm:
//(dönüştürülecek veri tipi) değişken;//(int)(4.3); !Yuvarlama değildir daima tam kisim alinir !4!
//

/*
class Java{
    public static void main(String[] args) {
        int price=5;
        double average=price/2;
        System.out.println("average:"+average);//sonuç:2

        double average1=(double)price/2;
        System.out.println("average1:"+average1);//sonuç:2.5
    }
}
*/

//String/Sayisal veri tiplerinin birbirine dönüşümü:
//
//int veri tipi string tipine dönüştürülürken integer şeklinde yazilir;
//int i=Integer.parseInt("42"); gibi.
//
//byte-Byte
//short-Short
//int-Integer
//long-Long
//double-Double
//float-Float
//boolean-Boolean
//char-Character
//
//
//
//
//valueOf();-toString();
//ifadeleri sayi tipini string tipine çevirir.
//
//String A=Integer.toString(18);
//String B=String.valueOf(18);
//System.out.println(A+B);//sonuç:1818
//
//
//
//valueOf();-parseInt/Long/Double();
//ifadeleri string tipini sayi tipine çevirir.
//
//String A="18";
//double s1=Double.parseDouble(A);
//double s2=Double.valueOf(A);
//System.out.println(s2+s1);//sonuç:36.0

//final int integer=5;
//final sözcüğü integer değişkeninin sabit olduğunu belirtir.

//enum kullanimi:
//enum dizilere benzer şekilde kullanilir,içinde bulunan değişkenler 0-1-2-3  şeklinde indexlerle belirtilir
//kullanim örneği:

/*
class Java{
    enum days{pazartesi,sali,çarşamba,perşembe,cuma,cumartesi,pazar};
    public static void main(String[] args) {
        
        System.out.println("gün:"+days.pazartesi);
        System.out.println(days.sali);
        System.out.println(days.çarşamba);
        System.out.println(days.perşembe);
        System.out.println(days.cuma);
        System.out.println(days.cumartesi);
        System.out.println(days.pazar);

    }
}
*/



















































































