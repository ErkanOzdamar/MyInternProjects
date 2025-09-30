package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_Heart extends entity{
    
    public OBJ_Heart(GamePanel gp){
        super(gp);
        name = "Heart";
        image = setup("/GUI/res/object/heart_full",gp.tileSize,gp.tileSize);
        image2 = setup("/GUI/res/object/heart_half",gp.tileSize,gp.tileSize);
        image3 = setup("/GUI/res/object/heart_blank",gp.tileSize,gp.tileSize);
        collision = true;
    }
}
