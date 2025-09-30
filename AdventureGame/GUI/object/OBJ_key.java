package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_key extends entity{

    public OBJ_key(GamePanel gp){
        super(gp);
        name = "Anahtar";
        down1 = setup("/GUI/res/object/key",gp.tileSize,gp.tileSize);
        collision = false;
        description = "[" + name + "] \n Kadim Anahtar.";
    }
}
