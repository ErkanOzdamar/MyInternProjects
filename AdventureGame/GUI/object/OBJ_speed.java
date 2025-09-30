package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_speed extends entity{
    
    public OBJ_speed(GamePanel gp){
        super(gp);
        down1 = setup("/GUI/res/object/speed",gp.tileSize,gp.tileSize);
        name = "speed";
        collision = false;
    }
}
