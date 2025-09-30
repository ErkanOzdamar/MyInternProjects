package GUI.object;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class OBJ_potionRed extends entity{

    GamePanel gp;
    int value = 5;
    
    public OBJ_potionRed(GamePanel gp){
        super(gp);
        this.gp = gp;
        
        type = type_consumable;
        down1 = setup("/GUI/res/object/potion_red",gp.tileSize,gp.tileSize);
        name = "Can İksiri";
        collision = false;
        description = "[" + name + "] \n Büyülü can iksiri \n5 kalp doldurur!";
    }

    public void use(entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "Can iksiri içtin!\n canın doluyor!";
        entity.life += value;
        if(gp.player.life > gp.player.maxLife){
            gp.player.life = gp.player.maxLife;
        }
    }
}