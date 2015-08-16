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
            panel.berechnen();
            panel.repaint();
            try{
                sleep(10);
            }catch(Exception e){
                
            }
        }
    }
    
}