import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel{
    private Scene scene;
    public Gamepanel(int width,int height){
        setSize(width,height);
        setBackground(Color.BLACK);
        addKeyListener(new Controller(this));
        new Pictures(); 
        new SceneManager();
        scene = SceneManager.getScenes().get(0);
        scene.addUnit(new Player(64,64,64,64,scene));
        new Gameloop(this);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < getWidth()/64;i++){
            for(int j = 0; j < getHeight()/64;j++){
                g.drawRect(i*64,j*64,64,64);
            }
        }
        
        scene.zeichnen(g,this);
        requestFocus();
    }
    
    public Scene getScene(){
        return scene;
    }
    
}