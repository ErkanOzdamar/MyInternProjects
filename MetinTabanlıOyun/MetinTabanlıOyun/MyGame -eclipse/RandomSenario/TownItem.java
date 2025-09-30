package RandomSenario;
import java.util.Random;

import Manager.Player;


public class TownItem{
    private int maxSelection = 11;
    Player player;

    public TownItem(Player player){
        this.player = player;
    }

    public int randomLoot(){
        Random r = new Random();
        return r.nextInt(maxSelection)+1;
    }

    public void selectionBigLoot(){
        
        switch(randomLoot()){
            case 1:
            if(!player.getStr().getM4()){
                player.getStr().setM4(true);
            }else{
                TownLoot();
            }
        break;
    case 2:
    if(!player.getStr().getAk47()){
        player.getStr().setAk47(true);
    }else{
        TownLoot();
    }  
        break;
    case 3:
    if(!player.getStr().getBalisticVest()){
        player.getStr().setBalisticVest(true);
    }else{
        TownLoot();
    }
        break;
    case 4:
    if(!player.getStr().getBulletProof()){
        player.getStr().setBulletProof(true);
    }else{
        TownLoot();
    }
        break;
    case 5:
    if(!player.getStr().getPolicE()){
        player.getStr().setPolicE(true);
    }else{
        TownLoot();
    }
        break;
    case 6:
    if(!player.getStr().getMachete()){
        player.getStr().setMachete(true);
    }else{
        TownLoot();
    }
        break;
    case 7:
    if(!player.getStr().getMilitary()){
        player.getStr().setMilitary(true);
    }else{
        TownLoot();
    }
        break; 
    case 8:
    if(!player.getStr().getNineMm()){
        player.getStr().setNineMm(true);
    }else{
        TownLoot();
    } 
        break;
    case 9:
    if(!player.getStr().getPlaka()){
        player.getStr().setPlaka(true);
    }else{
        TownLoot();
    }   
        break;
    case 10:
    if(!player.getStr().getPlaka()){
        player.getStr().setUzi(true);
    }else{
        TownLoot();
    }
        break;
        }
    }

    public void TownLoot(){
        int money=0, myMoney=0;
        switch (randomLoot()){
            case 1:
                selectionBigLoot();
                break;
            case 2:
                selectionBigLoot();
                break;
            case 3:
                selectionBigLoot();
                break;
            case 4:
                selectionBigLoot();
                break;
            case 5:
                money = player.getMoney();
                myMoney = 20+money;
                player.setMoney(myMoney);
                break;
            case 6:
                money = player.getMoney();
                myMoney = 20+money;
                player.setMoney(myMoney);
                break;
            case 7:
                money = player.getMoney();
                myMoney = 50+money;
                player.setMoney(myMoney);
                break; 
            case 8:
                money = player.getMoney();
                myMoney = 50+money;
                player.setMoney(myMoney);
                break;
            case 9:
                money = player.getMoney();
                myMoney = 50+money;
                player.setMoney(myMoney);
                break;
            case 10:
                money = player.getMoney();
                myMoney = 150+money;
                player.setMoney(myMoney);
                break;      
        }
    }

}
