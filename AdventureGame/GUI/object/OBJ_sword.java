package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_sword extends entity{
    
    public OBJ_sword(GamePanel gp){
        super(gp);
        type = type_sword;
        name = "Çelik Kılıç";
        down1 = setup("/GUI/res/object/sword_normal", gp.tileSize, gp.tileSize);
        attackValue = 1;
        description = "[" + name + "] \n Eski Kılıç.";
        attackArea.width = 36;
        attackArea.height = 36;
    }
}
