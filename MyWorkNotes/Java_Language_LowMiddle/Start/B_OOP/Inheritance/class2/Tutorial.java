package Inheritance.class2;

public class Tutorial {
    
    public static void main(String[] args) {
        Kamyon vasita1=new Kamyon(3, 620, "Volvo", "Siyah");
        Otomobil vasita2=new Otomobil(5, 150, "Mercedes", "Kirmizi");
        vasita1.message();
        vasita2.message();
    }
}
