package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_shield extends entity{
    public OBJ_shield(GamePanel gp){
        super(gp);
        type = type_shield;
        name = "Odun Kalkan";
        down1 = setup("/GUI/res/object/shield_wood", gp.tileSize, gp.tileSize);

        defendValue = 1;
        description = "[" + name + "] \n Eski Kalkan.";
    }
}
