package G_Class;

public class recursion {
int i;
    public recursion(int i){
        this.i = i;
    }
    
    public static int recursivePrint(int i){
            if(i % 2 == 0){
                System.out.print(i+"-");
                return recursivePrint(i/2);
            }else if(i == 1){
                System.out.print(i+"-");
                System.out.println();
                System.out.println("Döngü kırılamadı!");
                System.out.println();
                System.out.println();
                return i;
            }else{
                System.out.print(i+"-");
                return recursivePrint(i*3+1);
            }
        }
        public static void main(String[] args){
            int x = 1000000;
            while(x>0){
                recursivePrint(x);
                x--;
            }
    }
}
