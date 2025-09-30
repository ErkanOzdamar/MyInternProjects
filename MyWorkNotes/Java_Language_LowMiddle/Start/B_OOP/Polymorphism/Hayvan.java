package Polymorphism;

class Hayvan{
    public void speak(){
        System.out.println("Ben bir hayvanım.");
    }  
}

class Inek extends Hayvan{
    public void speak(){
        System.out.println("Möö");
    }
}

class Kedi extends Hayvan{
    public void speak(){
        System.out.println("Miav");
    }
}

class Köpek extends Hayvan{
    public void speak(){
        System.out.println("Hav");
    }
}

class Alem{
    public static void main(String[] args) {
        Hayvan[] a= new Hayvan[3];
        a[0]=new Kedi();
        a[1]=new Köpek();
        a[2]=new Inek();
        for(int i=0; i<3;i++){
            a[i].speak();
        }
    }
}
