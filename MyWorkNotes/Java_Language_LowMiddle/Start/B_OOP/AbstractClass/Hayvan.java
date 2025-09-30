package AbstractClass;

abstract class Hayvan {
    
    public abstract void speak();
}

class Cow extends Hayvan{
    public void speak(){
        System.out.println("Mö");
    }
}
class Cat extends Hayvan{
    public void speak(){
        System.out.println("Miav");
    }
}
class Dog extends Hayvan{
    public void speak(){
        System.out.println("Haav");
    }
}

class testSoyut{
    public static void main(String[] args) {
       // Hayvan= new Hayvan  Hata soyut sınıftan nesne türetilemez. 

    Hayvan[] a=new Hayvan[3];
    a[0]=new Cow();
    a[1]=new Cat();
    a[2]=new Dog();
    System.out.println("**Hayvanlar konuşuyor**");
    for(int i=0;i<3;i++){
        a[i].speak();
    }
    }
}