package GUI.main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool{
    
    public BufferedImage scaleImage(BufferedImage origins1, int width, int height){
            
            BufferedImage scaleImage = new BufferedImage(width, height, origins1.getType());
            Graphics2D g2 = scaleImage.createGraphics();
            g2.drawImage(origins1, 0, 0, width, height, null);
            g2.dispose();

            return scaleImage;
    }
}
