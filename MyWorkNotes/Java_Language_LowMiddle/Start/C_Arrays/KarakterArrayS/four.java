package C_Arrays.KarakterArrayS;
/*
public class four {
    public static void main(String[] args) {
        String name="Sakarya";
        System.out.println("0123456");
        System.out.printf(name);
        System.out.printf("\n%.3s\n",name);
        System.out.println(name.charAt(5));
        System.out.println(name.substring(3));
        System.out.println(name.length());
        
    }
    
}
*/

/*
import java.util.Scanner;
public class four {

    private static Scanner scan;
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        System.out.println("Cümle:");
        String str = scan.nextLine();
        int uz=str.length();
        for(int i=uz-1; i>=0; i--){
            System.out.print(str.charAt(i));
        }
    }
}
*/

/*
public class four {

    public static void main(String[] args) {
        String B, C;
        char A[]={'H', 'A', 'N', 'Z', 'A', 'R'};
        B=String.copyValueOf(A, 0, 4);
        System.out.println(B);
        C=String.valueOf(A, 0, 3);
        System.out.println(C);
    }
}
*/

/*
import java.util.Scanner;
public class four {
public static void main(String[] args) {
    int sayac=0;
    String parola="java";
    Scanner gir = new Scanner(System.in);


    do{
        System.out.print("Parola?");
        String girilen=gir.next();
        if(parola.equals(girilen)){
            System.out.println("Parolayı bildiniz!");
            break;
        }
        sayac++;
    }while(sayac<3);


    if(sayac>=3){
        System.out.println("HATALI.");
    }
} 
}
*/

/*
import java.util.Scanner;
public class four {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("kelime:");
        String x = scan.nextLine();
        x.toLowerCase();
        char[]A=x.toCharArray();

        System.out.printf("\nşifrelenmiş kelime:");
        for(int i=0; i<x.length(); i++){
            A[i]=(char)(x.codePointAt(i)+4);
            System.out.printf("%c", A[i]);
        }
    }
}
*/











