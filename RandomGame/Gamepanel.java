import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel{
    private final static int GRIDSIZE = 48;
    private Scene scene;
    private int verschiebungX,verschiebungY;
    private static int width,height;
    private static boolean debugMode;
    public Gamepanel(int width,int height){
        setSize(width,height);
        this.width = width;
        this.height = height;
        setBackground(Color.BLACK);
        addKeyListener(new Controller(this));
        new Pictures(); 
        new SceneManager(this);
        scene = SceneManager.getScenes().get(0);
        new Gameloop(this);
        verschiebungX = -(int)(scene.getPlayer().getX()-(8*Gamepanel.getGRIDSIZE()));
        verschiebungY = -(int)(scene.getPlayer().getY()-(6*Gamepanel.getGRIDSIZE()));
    }
    
    public void berechnen(){
        verschiebungX = -(int)(scene.getPlayer().getX()-(8*Gamepanel.getGRIDSIZE()));
        verschiebungY = -(int)(scene.getPlayer().getY()-(6*Gamepanel.getGRIDSIZE()));
        System.out.println(verschiebungX + "/" + verschiebungY);
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
    
    public void setScene(Scene scene){
        this.scene = scene;
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
    
    public static boolean getDebugMode(){
        return debugMode;
    }
}