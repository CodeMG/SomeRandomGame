import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel{
    private Scene scene;
    private int verschiebungX,verschiebungY;
    public Gamepanel(int width,int height){
        setSize(width,height);
        setBackground(Color.BLACK);
        addKeyListener(new Controller(this));
        new Pictures(); 
        new SceneManager();
        scene = SceneManager.getScenes().get(0);
        new Gameloop(this);
        verschiebungX = -(int)(scene.getPlayer().getX());
        verschiebungY = -(int)(scene.getPlayer().getY());
    }
    
    public void berechnen(){
        verschiebungX = -(int)(scene.getPlayer().getX());
        verschiebungY = -(int)(scene.getPlayer().getY());
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < getWidth()/64;i++){
            for(int j = 0; j < getHeight()/64;j++){
                g.drawRect(i*64,j*64,64,64);
            }
        }
        
        scene.zeichnen(g,this,verschiebungX,verschiebungY);
        requestFocus();
    }
    
    public Player getPlayer(){
        return scene.getPlayer();
    }
    
    public Scene getScene(){
        return scene;
    }
    
}