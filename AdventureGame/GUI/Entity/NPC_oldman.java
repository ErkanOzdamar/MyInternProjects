package GUI.Entity;
import java.util.Random;

import GUI.main.GamePanel;


public class NPC_oldman extends entity{
    
    public NPC_oldman(GamePanel gp){
        super(gp);

        type = 1;
        direction = "down";
        speed = 3;

        getImage();
        setDialogue();
    }

    public void getImage(){
        up1 = setup("/GUI/res/npc/npc1_up1",gp.tileSize,gp.tileSize);
        up2 = setup("/GUI/res/npc/npc1_up2",gp.tileSize,gp.tileSize);
        down1 = setup("/GUI/res/npc/npc1_down1",gp.tileSize,gp.tileSize);
        down2 = setup("/GUI/res/npc/npc1_down2",gp.tileSize,gp.tileSize);
        right1 = setup("/GUI/res/npc/npc1_right1",gp.tileSize,gp.tileSize);
        right2 = setup("/GUI/res/npc/npc1_right2",gp.tileSize,gp.tileSize);
        left1 = setup("/GUI/res/npc/npc1_left1",gp.tileSize,gp.tileSize);
        left2 = setup("/GUI/res/npc/npc1_left2",gp.tileSize,gp.tileSize);
    }
    public void setDialogue(){
        dialogues[0] = "Hello, Sam!";
        dialogues[1] = "So you will come to this \n ısland to find the treasure?";
        dialogues[2] = "I used to be a great wizard \n but now... I am a bit too old for \n taking an adventure.";
        dialogues[3] = "Well, good luck on you.";
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
    public void speak(){
        super.speak();
    }
}
