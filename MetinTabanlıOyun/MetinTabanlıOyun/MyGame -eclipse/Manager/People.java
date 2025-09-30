package Manager;
import java.util.*;

import Inventory.PeopleInventory;
import Inventory.Storage;

public class People{
    private int dmg,heal,communityLimit,community;
    protected Storage str;
    PeopleInventory peopleInv;
    Scanner scan = new Scanner(System.in);
    
    public People(){
        this.peopleInv = new PeopleInventory();
        this.str = new Storage();
        this.community = 1;
        this.communityLimit = 2;
        this.heal = 10;
        this.dmg = 5; 
    }

    public int getDamage(){
        return dmg;
    }
    public void setDamage(int dmg){
        this.dmg = dmg;
    }
    public int getHeal(){
        return heal;
    }
    public void setHeal(int heal){
        this.heal = heal;
    }
    public int getCommunity(){
        return community;
    }
    public void setCommunity(int community){
        this.community = community;
    }
    public int getCommunityLimit(){
        return communityLimit;
    }
    public void setCommunityLimit(int communityLimit){
        this.communityLimit = communityLimit;
    }
    public PeopleInventory getPeopleInv(){
        return peopleInv;
    }
    public void setPeopleInv(PeopleInventory peopleInv){
        this.peopleInv = peopleInv;
    }
}    
