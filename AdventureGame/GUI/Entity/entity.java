package GUI.Entity;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import GUI.main.GamePanel;
import GUI.main.UtilityTool;



public class entity {

    GamePanel gp;
    
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public BufferedImage up1Attack,up2Attack,down1Attack,down2Attack,left1Attack,left2Attack,right1Attack,right2Attack;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle();
    public int solidAreaDefaultX, solidAreaDefaultY;
    public BufferedImage image, image2, image3;
    public boolean collision = false;
    String dialogues[] = new String[20];

    //state
    public int worldX, worldY;
    public String direction = "down";
    public int spriteNum = 1;
    int dialogIndex = 0;
    public boolean collisionOn = false;
    public boolean invincible = false;
    boolean attackState = false;
    public boolean aLive = true;
    public boolean dying = false;
    boolean hpBarOn = false;

    //counter
    public int spriteCounter = 0;
    public int invincibleCounter = 0;
    public int actionLockCounter = 0;
    public int shotAvailableCounter = 0;
    int dyingCounter = 0;
    int hpBarCounter = 0;

    //character status
    public String name; 
    public int maxLife;
    public int life;
    public int maxMana;
    public int mana;
    public int speed;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public entity currentWeapon;
    public entity currentShield;
    public Projectile projectile;
    
    //Item attrıbuyes
    public int attackValue;
    public int defendValue;
    public String description = "";
    public int useCost;

    //type
    public int type; //0-player 1-npc 2-monster
    public final int type_player = 0;
    public final int type_npc = 1;
    public final int type_monster = 2;
    public final int type_sword = 3;
    public final int type_axe = 4;
    public final int type_shield = 5;
    public final int type_consumable = 6;


    public entity(GamePanel gp){
        this.gp = gp;
    }

    public void setAction(){}
    public void use(entity entity){}

    public void damageReaction(){}

    public void speak(){

        if(dialogues[dialogIndex] == null){
            dialogIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogIndex];
        dialogIndex++;

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
    
    public void update(){

        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        boolean  contractPlayer = gp.cChecker.checkPlayer(this);

        if(this.type == type_monster && contractPlayer == true){
            damagePlayer(attack);
        }

        //ıf collısıon is false, object can move
        if(collisionOn == false){
            switch (direction){
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right":  worldX += speed; break;        
            }
        }

            spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 40){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(shotAvailableCounter < 30){
            shotAvailableCounter++;
        }
    }

    public void draw(Graphics2D g2){


        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

                switch (direction){
                    case "up":
                    if(spriteNum == 1){
                        image = up1;
                    }
                    if(spriteNum == 2){
                        image = up2;
                    }
                        break;
                    case "down":
                    if(spriteNum == 1){
                        image = down1;
                    }
                    if(spriteNum == 2){
                        image = down2;
                    }
                        break;
                    case "right":
                    if(spriteNum == 1){
                        image = right1;
                    }
                    if(spriteNum == 2){
                        image = right2;
                    }
                        break;
                    case "left":
                    if(spriteNum == 1){
                        image = left1;
                    }
                    if(spriteNum == 2){
                        image = left2;
                    }
                        break;            
                }

                //monster hp bar
                if(type == 2 && hpBarOn == true){

                    double oneScale = (double)gp.tileSize/maxLife;
                    double hpbarValue = oneScale*life;

                    g2.setColor(new Color(35, 35, 35));
                    g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2, 12);
                    g2.setColor(new Color(255, 0, 30));
                    g2.fillRect(screenX, screenY - 15, (int)hpbarValue, 10);

                    hpBarCounter++;

                    if(hpBarCounter > 600){
                        hpBarCounter  = 0;
                        hpBarOn = false; 
                    }
                }
                

                if(invincible == true){
                    hpBarOn = true;
                    changeAlpha(g2, 0.4F);
                }
                
                if(dying == true){
                    dyingAnimation(g2);
                }
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
                //reset alpha
                changeAlpha(g2, 1f);
        }
    }
    public void damagePlayer(int attack){
        if(gp.player.invincible == false){

            int damage = attack - gp.player.defense;
            if(damage < 0){
                damage = 0;
            }

            gp.player.life -= damage;

            gp.player.invincible = true;
        }
    }
    public void dyingAnimation(Graphics2D g2){
        dyingCounter++;

        int i = 5;

        if(dyingCounter <= i){
            changeAlpha(g2, 0f);
        }
        if(dyingCounter > i && dyingCounter <= i*2){
            changeAlpha(g2, 1f);
        }
        if(dyingCounter > i*2 && dyingCounter <= i*3){
            changeAlpha(g2, 0f);
        }
        if(dyingCounter > i*3 && dyingCounter <= i*4){
            changeAlpha(g2, 1f);
        }
        if(dyingCounter > i*4 && dyingCounter <= i*5){
            changeAlpha(g2, 0f);
        }
        if(dyingCounter > i*5 && dyingCounter <= i*6){
            changeAlpha(g2, 1f);
        }
        if(dyingCounter > i*6 && dyingCounter <= i*7){
            changeAlpha(g2, 0f);
        }
        if(dyingCounter > i*7 && dyingCounter <= i*8){
            changeAlpha(g2, 1f);
        }
        if(dyingCounter > i*8){
            aLive = false;
        }
    }
    
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }

    public BufferedImage setup(String imagePath, int width, int height){

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
            image = uTool.scaleImage(image, width, height);
        }catch(Exception e) {

        }
        return image;
    }

}
