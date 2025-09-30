package Inheritance.class3;

class Vasita2{
    protected int A_Hiz=0;
    private String renk="sarı";
    private boolean durum=false;

    public void run(int Hiz){
        durum=true;
        if(durum==true){
            A_Hiz=A_Hiz+Hiz;
        }
    }

    public void stop(){
        if(durum==true){
            A_Hiz=0;
            durum=false;
        }
    }

    public void goster(){
        
        System.out.println("\nÇalışma:"+durum+"\nHızı:"+A_Hiz);
        System.out.println("Rengi:"+renk);
    }

    public class Otomobil2 extends Vasita2 {
        public void speedUp(){
            A_Hiz=A_Hiz+20;
            System.out.println("Şuanki hızı:"+A_Hiz);
        }
    }

    public class Kamyon2 extends Vasita2{}


    public static void main(String[] args) {
        Otomobil2 mercedes=new Vasita2().new Otomobil2();
        Kamyon2 BMC=new Vasita2().new Kamyon2();

        mercedes.run(30);
        mercedes.goster();
        mercedes.speedUp();
        mercedes.goster();

        BMC.run(10);
        BMC.goster();
        BMC.stop();
        BMC.goster();
    }
}



