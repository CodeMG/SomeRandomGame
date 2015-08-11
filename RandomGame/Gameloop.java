import javax.swing.*;
import java.awt.*;

public class Gameloop extends Thread{
    private Gamepanel panel;
    public Gameloop(Gamepanel panel){
        this.panel = panel;
        start();
    }
    
    public void run(){
        while(true){
            
            panel.repaint();
            try{
                sleep(100);
            }catch(Exception e){
                
            }
        }
    }
    
}