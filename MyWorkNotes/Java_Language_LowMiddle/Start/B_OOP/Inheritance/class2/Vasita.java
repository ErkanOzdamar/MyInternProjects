package Inheritance.class2;

import javax.swing.JOptionPane;

public class Vasita {
    
int koltuk;
int beygir;
String marka;
String renk;

Vasita(int koltuk, int beygir, String marka, String renk){
    this.koltuk=koltuk;
    this.beygir=beygir;
    this.marka=marka;
    this.renk=renk;
}

void message(){
        String message="Koltuk:"+koltuk+" Beygir:"+beygir+" Marka:"+marka+" Renk:"+renk;
        JOptionPane.showMessageDialog(null, message);
    }

}