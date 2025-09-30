package D_DuzenlIf.Ifadeler;

/*
public class A {
    public static void main(String[] args) {
        String[] str= {"12","34", "02", "5", "07", "9"};
        String regex="([0-9]{2})";
        
        for(var s:str){
            if(s.matches(regex)==true){
                System.out.println(s);
            }
        }
    }
}
*/


/*
public class A {

    public static void main(String[] args) {
        String[] str={"ali", "ayse", "mehmet", "can", "bade", "berat"};
        String regex="^[ab].*e$";
        for(var s:str){
            if(s.matches(regex)==true){
                System.out.println(s);
            }
        }
    }
}
*/


/*
import java.util.regex.*;
public class A {

    static final String REGEX="\\bmüdür\\b";
    static final String METIN="müdür, müdür müdür?müdüriyet";

    public static void main(String[] args) {
        Pattern p=Pattern.compile(REGEX);
        Matcher m=p.matcher(METIN);
        int sayac=0;
        while(m.find()){
            sayac++;
            System.out.println(sayac+".eşleşmenin:");
            System.out.println("Başlangıç indisi:"+m.start());
            System.out.println("Bitiş indisi:"+m.end());
        }
    }
}
*/



































