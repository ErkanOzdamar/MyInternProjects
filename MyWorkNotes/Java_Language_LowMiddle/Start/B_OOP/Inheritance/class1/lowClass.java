package Inheritance.class1;
import javax.swing.JOptionPane;

class lowClass extends upClass{
    float money;
    lowClass(int id, String name, float money){
        super(id, name);
        this.money=money;
    }

    void message(){
        String message=id+"-"+name+"-"+money;
        JOptionPane.showMessageDialog(null, message);
    }

    
}