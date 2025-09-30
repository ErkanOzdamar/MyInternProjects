package GUI.main;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){
        soundURL[0] = getClass().getResource("/GUI/res/sound/Game.wav");
        soundURL[1] = getClass().getResource("/GUI/res/sound/coin.wav");
        soundURL[2] = getClass().getResource("/GUI/res/sound/powerUp.wav");
        soundURL[3] = getClass().getResource("/GUI/res/sound/unlock.wav");
        soundURL[4] = getClass().getResource("/GUI/res/sound/fanfare.wav");
        soundURL[5] = getClass().getResource("/GUI/res/sound/hitmonster.wav");
        soundURL[6] = getClass().getResource("/GUI/res/sound/receivedamage.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream sis = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(sis);
        } catch (Exception e) {
            
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
