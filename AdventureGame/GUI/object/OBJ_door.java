package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_door extends entity{

    public OBJ_door(GamePanel gp){
        super(gp);
        name = "door";
        down1 = setup("/GUI/res/object/door",gp.tileSize,gp.tileSize);
        collision = true;
    }
}