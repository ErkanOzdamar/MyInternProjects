package GUI.main;
import GUI.Entity.NPC_oldman;
import GUI.Monster.MON_LavaM;
import GUI.object.OBJ_axe;
import GUI.object.OBJ_blueShield;
import GUI.object.OBJ_key;
import GUI.object.OBJ_potionRed;


public class assetSetter{
    
    GamePanel gp;

    public assetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new OBJ_key(gp);
        gp.obj[0].worldX = gp.tileSize*24;
        gp.obj[0].worldY = gp.tileSize*19;

        gp.obj[1] = new OBJ_axe(gp);
        gp.obj[1].worldX = gp.tileSize*33;
        gp.obj[1].worldY = gp.tileSize*21;

        gp.obj[2] = new OBJ_blueShield(gp);
        gp.obj[2].worldX = gp.tileSize*20;
        gp.obj[2].worldY = gp.tileSize*20;

        gp.obj[3] = new OBJ_potionRed(gp);
        gp.obj[3].worldX = gp.tileSize*36;
        gp.obj[3].worldY = gp.tileSize*36;
    }

    public void setNPC(){

        gp.npc[0] = new NPC_oldman(gp);
        gp.npc[0].worldX = gp.tileSize*24;
        gp.npc[0].worldY = gp.tileSize*18;
    }
    public void setMonster(){

        gp.monster[0] = new MON_LavaM(gp);
        gp.monster[0].worldX = gp.tileSize*22;
        gp.monster[0].worldY = gp.tileSize*21;

        gp.monster[1] = new MON_LavaM(gp);
        gp.monster[1].worldX = gp.tileSize*24;
        gp.monster[1].worldY = gp.tileSize*21;

        gp.monster[2] = new MON_LavaM(gp);
        gp.monster[2].worldX = gp.tileSize*25;
        gp.monster[2].worldY = gp.tileSize*19;

        gp.monster[3] = new MON_LavaM(gp);
        gp.monster[3].worldX = gp.tileSize*24;
        gp.monster[3].worldY = gp.tileSize*23;

        gp.monster[4] = new MON_LavaM(gp);
        gp.monster[4].worldX = gp.tileSize*23;
        gp.monster[4].worldY = gp.tileSize*16;

        gp.monster[5] = new MON_LavaM(gp);
        gp.monster[5].worldX = gp.tileSize*23;
        gp.monster[5].worldY = gp.tileSize*25;

        gp.monster[6] = new MON_LavaM(gp);
        gp.monster[6].worldX = gp.tileSize*11;
        gp.monster[6].worldY = gp.tileSize*32;

        gp.monster[7] = new MON_LavaM(gp);
        gp.monster[7].worldX = gp.tileSize*10;
        gp.monster[7].worldY = gp.tileSize*31;

        gp.monster[8] = new MON_LavaM(gp);
        gp.monster[8].worldX = gp.tileSize*9;
        gp.monster[8].worldY = gp.tileSize*32;
    }
}
