package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_chest extends entity{

    public OBJ_chest(GamePanel gp){
        super(gp);
        name = "chest";
        down1 = setup("/GUI/res/object/chest",gp.tileSize,gp.tileSize);
        collision = true;
    }
}
