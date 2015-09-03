import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel{
    private final static int GRIDSIZE = 48;
    private Scene scene;
    private int verschiebungX,verschiebungY;
    private static int width,height;
    public Gamepanel(int width,int height){
        setSize(width,height);
        this.width = width;
        this.height = height;
        setBackground(Color.BLACK);
        addKeyListener(new Controller(this));
        new Pictures(); 
        new SceneManager();
        scene = SceneManager.getScenes().get(0);
        new Gameloop(this);
        verschiebungX = -(int)(scene.getPlayer().getX()-(8*Gamepanel.getGRIDSIZE()));
        verschiebungY = -(int)(scene.getPlayer().getY()-(6*Gamepanel.getGRIDSIZE()));
    }
    
    public void berechnen(){
        verschiebungX = -(int)(scene.getPlayer().getX()-(8*Gamepanel.getGRIDSIZE()));
        verschiebungY = -(int)(scene.getPlayer().getY()-(6*Gamepanel.getGRIDSIZE()));
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
    
    public static int getW(){
        return width;
    }
    
    public static int getH(){
        return height;
    }
}