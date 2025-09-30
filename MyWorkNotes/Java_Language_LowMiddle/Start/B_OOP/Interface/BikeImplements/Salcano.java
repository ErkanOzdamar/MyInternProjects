package Interface.BikeImplements;

class Salcano implements Bike{
    int speed=0;
    public void speedUp(int up){
        speed=speed+up;
    }
    public void speedDown(int down){
        speed=speed-down;
    }

    void show(){
        System.out.println("Speed:"+speed);
    }

    public static void main(String[] args) {
        Salcano a=new Salcano();
        a.speedUp(15);
        a.show();
        a.speedDown(5);
        a.show();
    }
}
