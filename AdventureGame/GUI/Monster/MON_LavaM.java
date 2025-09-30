package GUI.Monster;
import java.util.Random;
import GUI.Entity.entity;
import GUI.main.GamePanel;

public class MON_LavaM extends entity{
    GamePanel gp;
    public MON_LavaM(GamePanel gp){
        super(gp);
        this.gp = gp;
        type = type_monster;
        name = "Lava Slime";
        speed = 2;
        maxLife = 4;
        life = maxLife;
        attack = 5;
        defense = 0;
        exp = 2;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage(){
        up1 = setup("/GUI/res/monster/monster_left",gp.tileSize,gp.tileSize);
        up2 = setup("/GUI/res/monster/monster_right",gp.tileSize,gp.tileSize);
        down1 = setup("/GUI/res/monster/monster_left",gp.tileSize,gp.tileSize);
        down2 = setup("/GUI/res/monster/monster_right",gp.tileSize,gp.tileSize);
        right1 = setup("/GUI/res/monster/monster_left",gp.tileSize,gp.tileSize);
        right2 = setup("/GUI/res/monster/monster_right",gp.tileSize,gp.tileSize);
        left1 = setup("/GUI/res/monster/monster_left",gp.tileSize,gp.tileSize);
        left2 = setup("/GUI/res/monster/monster_right",gp.tileSize,gp.tileSize);
    }
    public void setAction(){
        actionLockCounter++;
        
        if(actionLockCounter == 120){
            
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }
        actionLockCounter = 0;    
        }
    }
    public void damageReaction(){

        actionLockCounter = 0;
        switch (gp.player.direction){
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "right":
                direction = "left";
                break;
            case "left":
                direction = "right";
                break;            
        }
    }
}
