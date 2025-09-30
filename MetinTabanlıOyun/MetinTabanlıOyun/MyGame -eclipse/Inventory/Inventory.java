package Inventory;

public class Inventory{
    protected int farmFood,food,wood,rock,team,money,dayTime,day;
    protected String wName,aName;
    protected int damage,armor;
    

    public Inventory(){
        this.food = 10;
        this.farmFood = 20;
        this.wood = 0;
        this.rock = 0;
        this.damage = 0;
        this.armor = 0;
        this.dayTime = 24;
        this.day = 1;
        this.wName = "YOK!";
        this.aName = "YOK!";
    }

    public int getDayTime(){
        return dayTime;
    }
    public void setDayTime(int dayTime){
        this.dayTime = dayTime;
    }
    public int getDay(){
        return day;
    }
    public void setDay(int day){
        this.day = day;
    }
    public int getFarmFood(){
        return farmFood;
    }
    public void setFarmFood(int farmFood){
        this.farmFood = farmFood;
    }
    public int getFood(){
        return food;
    }
    public void setFood(int food){
        this.food = food;
    }
    public int getWood(){
        return wood;
    }
    public void setWood(int wood){
        this.wood = wood;
    }
    public int getRock(){
        return rock;
    }
    public void setRock(int rock){
        this.rock = rock;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getArmor(){
        return armor;
    }
    public void setArmor(int armor){
        this.armor = armor;
    }
    public String getWname(){
        return wName;
    }
    public void setWname(String wName){
        this.wName = wName;
    }
    public String getAname(){
        return aName;
    }
    public void setAname(String aName){
        this.aName = aName;
    }
}
