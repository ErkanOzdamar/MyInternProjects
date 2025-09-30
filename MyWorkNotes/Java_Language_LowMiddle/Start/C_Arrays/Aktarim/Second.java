package C_Arrays.Aktarim;

/*
public class Second{
    static final int mevcut=50;
    static void TakeNote(int Nt[]){
        for(int i=0; i<mevcut; i++){
            Nt[i]=i+(int)(Math.random()*100);
            System.out.printf(" %d", Nt[i]);
        }
    }

    public static void main(String[] args) {
        System.out.printf("===Ders Başarı Durumu===");
        int i, kalan=0, gNot=50;
        int Not[]=new int[mevcut];
        System.out.printf("\nNotlar:");
        TakeNote(Not);
        
        for(i=0; i<mevcut; i++){
            if(Not[i]<gNot){
                kalan++;
            }
        }
        System.out.printf("\nKalanlar:%d", kalan);
        System.out.printf("\nGeçenler:%d",mevcut-kalan);
    }
}
*/

/*
public class Second{
    public static void main(String[] args) {
        int A[]={5, 4, 3, 2, 1};
        int B[]=new int[5];
        for(int i=0; i!=5; i++){
            B[i]=A[4-i];
            System.out.println(B[i]);
        }
        
    }
}
*/
/*
public class Second{
    public static void main(String[] args){
        int A[]={5, 4, 3, 2, 1};
        int B[]=new int[5];
        System.arraycopy(A, 0, B, 0, 5);
        for(int i=0; i<=5; i++){
            System.out.println(B[4-i]);
        }
    }
}
*/

/*
public class Second{
    final static int n=10;
    public static void main(String[] args) {
        int A[]={2, 5, 6, 1, 78, 43, 23, 89, 9, 14};
        int i, ekle;
        //Insertion Sort
        for(i=1; i<n; i++){
            ekle=A[i];
            while(i>0 && (A[i-1]<ekle)){
                A[i]=A[i-1];
                i=i-1;
            }
        A[i]=ekle;    
        }
    System.out.printf("Sırası:\n");
        for(i=0; i<n; i++){
            System.out.printf("%d ", A[i]);
        }    
    }
}
*/

/* 
public class Second{
    final static int n=10;
    public static void main(String[] args) {
        int A[]={2, 5, 6, 1, 78, 43, 23, 89, 9, 14};
        int i, j, enk;
        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                if(A[i]<A[j]){
                    enk=A[i];
                    A[i]=A[j];
                    A[j]=enk;
                }
            }
        }
        System.out.printf("Sırası:\n");
        for(i=0; i<n; i++){
            System.out.printf("%d ", A[i]);
        }        
    }
}
*/
/*
import static java.util.Arrays.sort;
public class Second{
    public static void main(String[] args) {
        char A[]={'i', 's', 't', 'a', 'n', 'b', 'u', '1'};
        sort(A);
        for(int i=0; i<A.length; i++){
            System.out.printf("%c", A[i]);
        }
        System.out.printf("\nEnk:%c\nEnb:%c", A[0], A[A.length-1]);
    }
}
*/

/*
import java.util.Scanner;
public class Second {

    private static Scanner scan;
    public static void main(String[] args) {
        int[]A={12, 3, 56, 76, 43, 23, 54, 64, 65};
        int i, scans, by=0;
        System.out.printf("Aranan sayı:");
        scan=new Scanner(System.in);
        scans=scan.nextInt();

        for(i=0; i<9; i++){
            if(scans == A[i]){
                System.out.printf("%d.Sırada bulundu", i+1);
                by=1;
                break;
            }
        }
        if(by==0){
            System.out.printf("Aranan bulunamadı.");
        }

    }
}
*/
/*
import java.util.Scanner;
public class Second{
    static int A[]={2, 3, 4, 6, 7, 12, 34, 67, 89};
    //Binary
    static int Bsrc(int A[], int N, int scan){
        int middle, low=0, high=N-1;
        while(low<=high){
            middle=(low+high)/2;
            if(scan>A[middle]){
                low=middle+1;
            }
            else if(scan<A[middle]){
                high=middle-1;
            }
            else{
                return 1;
            }
        }
    return 0;
    }
    public static void main(String[] args) {
        int search, by=0;
        System.out.printf("Aranan sayı:");
        search=new Scanner(System.in).nextInt();
        by=Bsrc(A, 9, search);
        if(by==1){
            System.out.println("Aranan bulundu.");
        }
        else{
            System.out.println("Aranan bulunamadı.");
        }
    }
}
*/




















