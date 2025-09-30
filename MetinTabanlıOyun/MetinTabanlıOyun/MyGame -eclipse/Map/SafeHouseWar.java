package Map;
import Location.BattleLoc;
import Manager.Camp;
import Manager.People;
import Manager.Player;

public class SafeHouseWar extends BattleLoc{
    protected boolean warLoop = true;
    public SafeHouseWar(Player player, People people, Camp camp, String name){
        super(player, people, camp, "Üs Baskını");
    }
    
    public boolean getLocation(){
        clean();
        warWave();
        warGif2();
        if(winerLoserCamp()){
            return true;
        }else{
            
            return false;
        }
    }
}
