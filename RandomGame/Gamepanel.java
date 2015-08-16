import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel{
    private final static int GRIDSIZE = 64;
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
        getPlayer().calculate();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < getWidth()/GRIDSIZE;i++){
            for(int j = 0; j < getHeight()/GRIDSIZE;j++){
                g.drawRect(i*GRIDSIZE,j*GRIDSIZE,GRIDSIZE,GRIDSIZE);
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
    
    public static int getGRIDSIZE(){
        return GRIDSIZE;
    }
    
}