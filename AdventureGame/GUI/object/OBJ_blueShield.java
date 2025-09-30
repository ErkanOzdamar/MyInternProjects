package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_blueShield extends entity{
    public OBJ_blueShield(GamePanel gp){
        super(gp);
        type = type_shield;
        name = "Mavi Kalkan";
        down1 = setup("/GUI/res/object/shield_blue", gp.tileSize, gp.tileSize);

        defendValue = 2;
        description = "[" + name + "] \n Eski Mavi Kalkan.";
    }
}
