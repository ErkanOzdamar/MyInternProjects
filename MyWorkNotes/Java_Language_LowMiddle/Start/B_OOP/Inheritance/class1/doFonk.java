package Inheritance.class1;

class doFonk{
    public static void main(String[] args) {
        lowClass person1= new lowClass(1, "Ali", 4500f);
        lowClass person2= new lowClass(2, "Veli", 3500f);
        person1.message();
        person2.message();
    }
}
