package C_Arrays.Iki_Boyut;

//Altın soru için ip ucu.
/*
public class Third {
    public static void main(String[] args) {
        int A[][]=new int[5][5];
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                if(i==j){
                    A[i][j]=1;
                }
                else{
                    A[i][j]=0;
                }
                System.out.print(A[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
*/


/* 
public class Third{
    public static void main(String[] args) {
        int A[][]=new int[5][5];
        
        for(int x=0; x<5; ++x){
            for(int y=0; y<5; ++y){
                if(x==y){
                    A[x][y]=0;
                }
                else if(x<y){
                    A[x][y]=1;
                }
                else{
                    A[x][y]=-1;
                }
                System.out.print(A[x][y]+"\t");
            }
            System.out.print("\n");
        }
    }
}
*/

/*
public class Third{
    public static void main(String[] args) {
        int A[][]=new int[3][5];
        for(int i=0; i<3; ++i){
            for(int j=0; j<5; ++j){
                A[i][j]=j;
                System.out.print(A[i][j]+" ");            
            }
        System.out.printf("\n");    
        }        
    }
}
*/

/*
public class Third {

    public static void main(String[] args) {
        int A[][]=new int[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(i==j || (i+j)==4){
                    System.out.printf("  *  ");
                }
                else{
                    System.out.printf("     ");
                }
            }
            System.out.println("");
        }
    }
}
*/


/*
public class Third{
    public static void main(String[] args) {
        int i, j;
        int A[][] = { { 0, 1 ,2 ,3}, {4, 5, 6, 7}, {8, 9 ,0 ,4} };
        int B[][]=new int[4][3];
        System.out.printf("A matrisi:\n");



        for(i=0 ; i<3; i++){
            for(j=0; j<4; j++){
                System.out.printf("   %d", A[i][j]);
                //transpoze:
                B[j][i]=A[i][j];
            }
            System.out.printf("\n");
        }


System.out.println("");

        for(i=0; i<4; i++){
            for(j=0; j<3; j++){
                System.out.printf("   %d", B[i][j]);
            }
            System.out.println("");
        }
    }
}
*/


/*
import java.util.Scanner;
public class Third {

    private static Scanner scan;
    public static void main(String[] args) {
        int j, i, N, syc0=0, syc1=0;
        System.out.printf("N değeri:");
        scan=new Scanner(System.in);
        N=scan.nextInt();
        System.out.println("");
        int A[][]=new int[N][N];

        for(i=0; i<N; ++i){
            for(j=0; j<N; ++j){
                A[i][j]=(int)(Math.random()*2);
                if(A[i][j]==0){
                    syc0++;
                }
                else{
                    syc1++;
                }
                System.out.printf("%d \t", A[i][j]);
            }
        System.out.printf("\n");    
        }
    System.out.printf("\n1 mevcudu:%d\n", syc1);
    System.out.printf("0 mevudu:%d\n", syc0);    
    }
}
*/


//METOTLARA PARAMETRE OLARAK MATRİS AKTARMA:
//Uygulamalı örnek third.
/*
public class Third{
    final static int N=2;


    static void f1(int V[]){
        V[1]=2;
    }
    static void f2(int M[][]){
        M[0][0]=4;
        M[1][0]=8;
    }

    public static void main(String[] args){
        int A[][]=new int[N][N];
        f1(A[0]);
        f2(A);
        System.out.printf("%d\t%d", A[0][0], A[0][1]);
        System.out.printf("\n%d\t%d", A[1][0], A[1][1]);
    }
}
*/

/*
public class Third {

    public static void main(String[] args) {
        int ort;
        int A[][][]=new int[10][7][3];

        for(int k=0; k<3; k++){
            for(int i=0; i<=9; i++){
                A[i][0][k]=i+1;
                for(int j=0; j<=5; j++){
                    A[i][j][k]=1+(int)(Math.random()*100);
                    ort=((A[i][1][k]*15)+(A[i][2][k]*15)+(A[i][3][k]*20)+(A[i][4][k]*50)
                    /100+(A[i][5][k]*70)/100);
                    A[i][6][k]=Math.round(ort);
                }
            }
        }
        System.out.printf("No\t KS-1\t KS-2\t Odev\t Vize\t  Final\t Basari Notu:");
        System.out.println("\n ===\t ===\t ===\t ===\t ===\t ===\t ===");
        for(int z=0; z<=9; z++){
            for(int x=0; x<=6; x++){
                for(int y=0; y<=6; y++){
                    System.out.print(" "+(A[x][y][z])+"\t");
                }
                System.out.println("");
            }
            System.out.printf("%d. dersin notudur\n", z+1);
        }
    }
}
*/










