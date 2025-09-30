package GUI.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import GUI.main.GamePanel;
import GUI.main.UtilityTool;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        TileImage();
        loadMap("/GUI/res/maps/mapp.txt");
    }

    public void TileImage(){
            setup(0, "grass", false);
            setup(1, "wall", true);
            setup(2, "see", true);
            setup(3, "sand", false);
            setup(4, "tree", true);
            setup(5, "dirt", false);
    }
    public void setup(int index, String imagePath, boolean collision){
        UtilityTool uToo1 = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/GUI/res/tiles/"+imagePath+".png"));
            tile[index].image = uToo1.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (Exception e) {
            
        }
    }
    public void loadMap(String string){
        try {
            InputStream is = getClass().getResourceAsStream("/GUI/res/maps/mapp.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){}
    }
    
    //row-satır col-sütun
    public void draw(Graphics2D g2){
        int WorldCol = 0;
        int WorldRow = 0;

        while(WorldCol < gp.maxWorldCol && WorldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[WorldCol][WorldRow];

            int worldX = WorldCol * gp.tileSize;
            int worldY = WorldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            WorldCol++;
            
            if(WorldCol == gp.maxWorldCol){
                WorldCol = 0;
                WorldRow++;
            }
        }
    }
}
