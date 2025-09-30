package Inventory;

public class PeopleInventory{
    private String aName,wName;
    private int armor,damage;

    public PeopleInventory(){
        this.aName = "YOK!";
        this.wName = "YOK!";
        this.armor = 0;
        this.damage = 0;
    }
    
    public String getAname(){
        return aName;
    }
    public void setAname(String aName){
        this.aName = aName;
    }
    public String getWname(){
        return wName;
    }
    public void setWname(String wName){
        this.wName = wName;
    }
    public int getArmor(){
        return armor;
    }
    public void setArmor(int armor){
        this.armor = armor;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
}
