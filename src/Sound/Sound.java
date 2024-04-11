/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sound;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author zedan.net
 */
public class Sound {
   private Clip clip ;
    private  URL soundUrl[] = new URL[30];

    public Sound() {
        soundUrl[0]= getClass().getResource("/circus1.wav");
        soundUrl[1]= getClass().getResource("/bomb.wav");
       // soundUrl[2]= getClass().getResource("/gameover.wav");
        soundUrl[3]= getClass().getResource("/point.wav");
 
        
    }
    public void setFile (int i) 
    {
        try {
            
            AudioInputStream stream = AudioSystem.getAudioInputStream(soundUrl[i]);
            clip = AudioSystem.getClip();
            clip.open(stream);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void play ()
    {
        clip.start();
     }
    public void stop()
    {
        
        clip.stop();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
   }
    
    
}
