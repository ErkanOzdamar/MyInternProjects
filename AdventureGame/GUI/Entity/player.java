package GUI.Entity;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GUI.main.GamePanel;
import GUI.main.KeyHandler;
import GUI.object.OBJ_fireball;
import GUI.object.OBJ_key;
import GUI.object.OBJ_shield;
import GUI.object.OBJ_sword;


public class player extends entity{
    
    
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public ArrayList<entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;

    public player(GamePanel gp, KeyHandler keyH){

        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        //solid area
        solidArea = new Rectangle();
        solidArea.x = 6;
        solidArea.y = 12;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultX = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 24;

        defaultValues();
        PlayerImage();
        getPlayerAttackImage();
        setItems();
    }

    public void defaultValues(){
        worldX = gp.tileSize * 21;
        worldY = gp.tileSize * 23;
        speed = 6;
        direction = "down";
        type = 0;

        //player state
        level = 1;
        maxLife = 6;
        life = maxLife;
        strength = 1; // more strength, more damage
        dexterity = 1;//more dexterity, less damage
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        projectile = new OBJ_fireball(gp);
        currentWeapon = new OBJ_sword(gp);
        currentShield = new OBJ_shield(gp);
        attack = getAttack();//total damage
        defense = getDefense();//total defense
    }
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(currentShield);
        inventory.add(new OBJ_key(gp));
        inventory.add(new OBJ_key(gp));
    }
    public int getAttack(){
        attackArea = currentWeapon.attackArea;
        return attack = strength * currentWeapon.attackValue;
    }
    public int getDefense(){
        return defense = dexterity * currentShield.defendValue;
    }
    public void PlayerImage(){
        up1 = setup("/GUI/res/player/boy_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/GUI/res/player/boy_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/GUI/res/player/boy_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/GUI/res/player/boy_down_2",gp.tileSize,gp.tileSize);
        right1 = setup("/GUI/res/player/boy_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/GUI/res/player/boy_right_2",gp.tileSize,gp.tileSize);
        left1 = setup("/GUI/res/player/boy_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/GUI/res/player/boy_left_2",gp.tileSize,gp.tileSize);
    }
    public void getPlayerAttackImage(){

        if(currentWeapon.type == type_sword){
            up1Attack = setup("/GUI/res/player/boy_attack_up_1",gp.tileSize,gp.tileSize*2);
            up2Attack = setup("/GUI/res/player/boy_attack_up_2",gp.tileSize,gp.tileSize*2);
            down1Attack = setup("/GUI/res/player/boy_attack_down_1",gp.tileSize,gp.tileSize*2);
            down2Attack = setup("/GUI/res/player/boy_attack_down_2",gp.tileSize,gp.tileSize*2);
            right1Attack = setup("/GUI/res/player/boy_attack_right_1",gp.tileSize*2,gp.tileSize);
            right2Attack = setup("/GUI/res/player/boy_attack_right_2",gp.tileSize*2,gp.tileSize);
            left1Attack = setup("/GUI/res/player/boy_attack_left_1",gp.tileSize*2,gp.tileSize);
            left2Attack = setup("/GUI/res/player/boy_attack_left_2",gp.tileSize*2,gp.tileSize);
        }
        if(currentWeapon.type == type_axe){
            up1Attack = setup("/GUI/res/player/boy_axe_up_1",gp.tileSize,gp.tileSize*2);
            up2Attack = setup("/GUI/res/player/boy_axe_up_2",gp.tileSize,gp.tileSize*2);
            down1Attack = setup("/GUI/res/player/boy_axe_down_1",gp.tileSize,gp.tileSize*2);
            down2Attack = setup("/GUI/res/player/boy_axe_down_2",gp.tileSize,gp.tileSize*2);
            right1Attack = setup("/GUI/res/player/boy_axe_right_1",gp.tileSize*2,gp.tileSize);
            right2Attack = setup("/GUI/res/player/boy_axe_right_2",gp.tileSize*2,gp.tileSize);
            left1Attack = setup("/GUI/res/player/boy_axe_left_1",gp.tileSize*2,gp.tileSize);
            left2Attack = setup("/GUI/res/player/boy_axe_left_2",gp.tileSize*2,gp.tileSize);
        }
        
    } 
    public void update(){

        if(attackState == true){
            attack();
        }else if(keyH.upPressed == true || keyH.downPressed == true || keyH.upPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPress == true){
            if(keyH.upPressed == true){
                direction = "up";
            }else if(keyH.downPressed == true){
                direction = "down";
            }else if(keyH.leftPressed == true){
                direction = "left";
            }else if(keyH.rightPressed == true){
                direction = "right";
            }
            //check tile
            collisionOn = false;
            gp.cChecker.checkTile(this);
            //check object
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            //check npc collesion
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);
            //check monster collesion
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            interactMonster(monsterIndex);
            //check event
            gp.eHandler.checkEvent();
            //check key
            
            //ıf collısıon is false, player can move
            if(collisionOn == false && keyH.enterPress == false){
                switch (direction){
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right":  worldX += speed; break;        
                }
            }

            

            gp.keyH.enterPress = false;


            spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    if(gp.keyH.shotKeyPress == true && projectile.aLive == false && shotAvailableCounter == 30){
        //set default cordinates, directions and users
        projectile.set(worldX, worldY, direction, true, this);
        //add ıt to the list
        gp.projectileList.add(projectile);

        shotAvailableCounter = 0;
    }


    if(invincible == true){
        invincibleCounter ++;
        if(invincibleCounter > 60){
            invincible = false;
            invincibleCounter = 0;
        }
    }
    if(shotAvailableCounter < 30){
        shotAvailableCounter++;
    }
}
    public void attack(){
        spriteCounter++;

        if(spriteCounter <= 15){
            spriteNum = 1;
        }
        if(spriteCounter > 15 && spriteCounter <= 30){
            spriteNum = 2;

            // save the current worldX,worldY,solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            //adjust players worldX/Y for the attackArea
            switch (direction){
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;
                
            }

            //attack area becomes solidarea
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            //check monster collision with the updated worldX worldY and solidarea
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex, attack);

            //afer cChecking collision resotre the original data 
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(spriteCounter > 30){
            spriteNum = 1;
            spriteCounter = 0;
            attackState = false;
        }
    }
    public void pickUpObject(int i){
        if(i != 999){
            String text;
            if(inventory.size() != maxInventorySize){
                inventory.add(gp.obj[i]);
                text = gp.obj[i].name + " aldın!";
            }else{
                text = "Envanterin dolu!";
            }
            gp.ui.addMessage(text);
            gp.obj[i] = null;
        }
    }
    public void interactNPC(int i){

        if(gp.keyH.enterPress == true){
            if(i != 999){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }else{
                attackState = true;
            }
        }
    }
    public void interactMonster(int i){
        if(i != 999){
            if(invincible == false && gp.monster[i].dying == false){
                gp.playSE(6);

                int damage = gp.monster[i].attack - defense;
                if(damage < 0){
                    damage = 0;
                }

                life -= damage;
                invincible = true;
            }
        }
    }
    public void damageMonster(int i, int attack){
        if(i != 999){
            if(gp.monster[i].invincible == false){

                gp.playSE(5);

                int damage = attack - gp.monster[i].defense;
                if(damage < 0){
                    damage = 0;
                }

                gp.ui.addMessage(damage + " Damage!");
                gp.monster[i].life -= damage;
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();

                if(gp.monster[i].life <= 0){
                    gp.monster[i].dying = true; 
                    gp.ui.addMessage("Killed the " + gp.monster[i].name + "!");
                    gp.ui.addMessage("Exp + " + gp.monster[i].exp);
                    exp += gp.monster[i].exp;
                    checkLevelUp();
                }
            }
        }
    }
    public void checkLevelUp(){
        if(exp >= nextLevelExp){
            level++;
            nextLevelExp = nextLevelExp*2;
            maxLife += 2;
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You are level " + level + " now!\n" + "You feel stronger!";
        }
    }
    public void selectItem(){
        int itemIndex = gp.ui.getItemIndexOnSlot();

        if(itemIndex < inventory.size()){
            entity selectedItem = inventory.get(itemIndex);

            if(selectedItem.type == type_sword || selectedItem.type == type_axe){
                currentWeapon = selectedItem;
                attack = getAttack();
                getPlayerAttackImage();
            }
            if(selectedItem.type == type_shield){
                currentShield = selectedItem;
                defense = getDefense();
            }
            if(selectedItem.type == type_consumable){
                selectedItem.use(this);
                inventory.remove(itemIndex);
            }
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch (direction){
            case "up":
            if(attackState == false){
                if(spriteNum == 1) {image = up1;}
                if(spriteNum == 2) {image = up2;}
            }
            if(attackState == true){
                tempScreenY = screenY - gp.tileSize;
                if(spriteNum == 1) {image = up1Attack;}
                if(spriteNum == 2) {image = up2Attack;}
            }
            break;
            case "down":
            if(attackState == false){
                if(spriteNum == 1) {image = down1;} 
                if(spriteNum == 2) {image = down2;}
            }    
            if(attackState == true){
                if(spriteNum == 1) {image = down1Attack;} 
                if(spriteNum == 2) {image = down2Attack;}
            }
            break;
            case "right":
            if(attackState == false){
                if(spriteNum == 1) {image = right1;}
                if(spriteNum == 2) {image = right2;} 
            }
            if(attackState == true){
                if(spriteNum == 1) {image = right1Attack;}
                if(spriteNum == 2) {image = right2Attack;}
            }
            break;
            case "left":
            if(attackState == false){
                if(spriteNum == 1) {image = left1;}    
                if(spriteNum == 2) {image = left2;}
            }
            if(attackState == true){
                tempScreenX = screenX - gp.tileSize;
                if(spriteNum == 1) {image = left1Attack;}    
                if(spriteNum == 2) {image = left2Attack;}
            }
            break;    
        }

        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image, tempScreenX, tempScreenY, null);

        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
