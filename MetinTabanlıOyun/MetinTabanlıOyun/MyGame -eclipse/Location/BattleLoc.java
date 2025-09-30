package Location;
import Manager.Camp;
import Manager.People;
import Manager.Player;

public class BattleLoc extends Location{

    protected BattleLoc(Player player, People people, Camp camp, String name){
        super(player, people, camp);
        this.name = name;
    }

    public boolean getLocation(){
        return true;
    }

    public void warWave(){
        if(player.getInv().getDay() >= 12 && player.getInv().getDay() < 20){
            camp.setWarWave(2000);
        }
        else if(player.getInv().getDay() >= 20 && player.getInv().getDay() < 30){
            camp.setWarWave(3500);
        }else{
            camp.setWarWave(4500);
        }
    }
    public void warWaveWalk(){
        if(player.getInv().getDay() < 7){
            camp.setWarWaveWalk(100);
        }
        else if(player.getInv().getDay() >= 7 && player.getInv().getDay() < 20){
            camp.setWarWaveWalk(200);
        }
        else if(player.getInv().getDay() >= 20 && player.getInv().getDay() < 30){
            camp.setWarWaveWalk(3000);
        }else{
            camp.setWarWaveWalk(4200);
        }
    }
}
