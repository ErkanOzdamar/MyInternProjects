

package GUI.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import GUI.Entity.entity;
import GUI.Entity.player;
import GUI.tile.TileManager;


public class GamePanel extends JPanel implements Runnable{
    
    //screen settings
    public final int originalTileSize = 16;
    public final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 40;
    public final int maxScreenRow = 20;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 100;

    //FPS
    int FPS = 60;
    

    //System
    TileManager tileManager = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    Sound music = new Sound();
    Sound se = new Sound();
    public ColissionChecker cChecker = new ColissionChecker(this);
    public assetSetter aSetter = new assetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);

    //entity and Object
    public player player = new player(this, keyH);
    public entity obj[] = new entity[10];
    public entity npc[] = new entity[10];
    public entity monster[] = new entity[20];
    ArrayList<entity> entityList = new ArrayList<>();
    public ArrayList<entity> projectileList = new ArrayList<>();

    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        playMusic(0);
        gameState = titleState;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            
            if(delta > 0.50){
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update(){
        if(gameState == playState){
            //player
            player.update();
            //npc
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            for(int i = 0; i < monster.length; i++){
                if(monster[i] != null){
                    if(monster[i].aLive == true && monster[i].dying == false){
                        monster[i].update();
                    }
                    if(monster[i].aLive == false){
                        monster[i] = null;
                    }
                }
            }
            for(int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    if(projectileList.get(i).aLive == true){
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).aLive == false){
                        projectileList.remove(i);
                    }
                }
            }
        }
        if(gameState == pauseState){
            //nothing
        }
    }
    public void paintComponent(Graphics g){

        //DEBUG
        long drawStart = 0;
        if(keyH.checkDebugText == true){
            drawStart = System.nanoTime();
        }
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //tittle screen
        if(gameState == titleState){
            ui.draw(g2);
        }
        //others
        else{
            //tile
        tileManager.draw(g2);

        entityList.add(player);

        for(int i = 0; i < npc.length; i++){
            if(npc[i] != null){
                entityList.add(npc[i]);
            }
        }
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                entityList.add(obj[i]);
            }
        }
        for(int i = 0; i < monster.length; i++){
            if(monster[i] != null){
                entityList.add(monster[i]);
            }
        }
        for(int i = 0; i < projectileList.size(); i++){
            if(projectileList.get(i) != null){
                entityList.add(projectileList.get(i));
            }
        }
        //sort
        Collections.sort(entityList, new Comparator<entity>(){

            public int compare(entity e1, entity e2){

                int result = Integer.compare(e1.worldX, e2.worldY);
                return result;
            }
        });
        //draw entity
        for(int i = 0; i < entityList.size(); i++){
            entityList.get(i).draw(g2);
        }
        //reset list
        entityList.clear();
        //uı
        ui.draw(g2);
        }
        
        //DEBUG
        if(keyH.checkDebugText == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;

            g2.setFont(new Font("Arial", Font.PLAIN, 20));
            g2.setColor(Color.white);
            int x = 20;
            int y = 400;
            int lineHeight = 20;

            g2.drawString("WorldX: " + player.worldX, x, y);
            y += lineHeight;
            g2.drawString("WorldY: " + player.worldY, x, y);
            y += lineHeight;
            g2.drawString("COL: " + (player.worldX + player.solidArea.x)/tileSize, x, y);
            y += lineHeight;
            g2.drawString("ROW: " + (player.worldY + player.solidArea.y)/tileSize, x, y);
            y += lineHeight;
            g2.drawString("Draw Time: "+passed, x, y);
        }
        g2.dispose();
    }
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
