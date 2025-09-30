package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_axe extends entity{
    public OBJ_axe(GamePanel gp){
        super(gp);
        type = type_axe;
        name = "Odun Balta";
        down1 = setup("/GUI/res/object/axe", gp.tileSize, gp.tileSize);

        attackValue = 2;
        description = "[" + name + "] \n Eski Balta.";

        attackArea.width = 30;
        attackArea.height = 30;
    }
}
