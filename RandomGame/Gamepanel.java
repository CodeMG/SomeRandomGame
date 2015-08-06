import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel{
    private Scene scene;
    public Gamepanel(int width,int height){
        setSize(width,height);
        new Pictures();
        new SceneManager();
        scene = SceneManager.getScenes().get(0);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        scene.zeichnen(g,this);
    }
    
}