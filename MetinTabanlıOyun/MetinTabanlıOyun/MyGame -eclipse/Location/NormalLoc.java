package Location;
import java.util.Random;

import Manager.Camp;
import Manager.People;
import Manager.Player;


public abstract class NormalLoc extends Location{
    private int maxN = 11;
    
    protected NormalLoc(Player player, People people, Camp camp, String name){
        super(player, people, camp);
        this.name = name;
    }
    public boolean getLocation(){
        return true;
    }
    public int lootCount(){
        Random r = new Random();
        return r.nextInt(this.maxN)+1;
    }
    public void aSleep(){
        try{
            for(int i=3; i>0; i--){
                Thread.sleep(1000);
            }
        }catch(Exception e){
            System.out.println("Something get wrong");
        }
    }
}
