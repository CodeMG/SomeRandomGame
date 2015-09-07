import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel{
    private final static int GRIDSIZE = 48;
    private Scene scene;
    private SceneManager manager;
    private int verschiebungX,verschiebungY;
    private static int width,height;
    private static boolean debugMode;
    private static boolean draw,calculate;
    public Gamepanel(int width,int height){
        setSize(width,height);
        this.width = width;
        this.height = height;
        this.draw = true;
        this.calculate = true;
        setBackground(Color.BLACK);
        addKeyListener(new Controller(this));
        new Pictures(); 
        manager = new SceneManager(this);
        scene = SceneManager.getScenes().get(0);
        new Gameloop(this);
        verschiebungX = -(int)(scene.getPlayer().getX()-(8*Gamepanel.getGRIDSIZE()));
        verschiebungY = -(int)(scene.getPlayer().getY()-(6*Gamepanel.getGRIDSIZE()));
    }

    public void berechnen(){
        if(calculate){
            verschiebungX = -(int)(scene.getPlayer().getX()-(8*Gamepanel.getGRIDSIZE()));
            verschiebungY = -(int)(scene.getPlayer().getY()-(6*Gamepanel.getGRIDSIZE()));
            getPlayer().calculate();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(draw){
            for(int i = 0; i < getWidth()/GRIDSIZE;i++){
                for(int j = 0; j < getHeight()/GRIDSIZE;j++){
                    g.drawRect(i*GRIDSIZE,j*GRIDSIZE,GRIDSIZE,GRIDSIZE);
                }
            }

            scene.zeichnen(g,this,verschiebungX,verschiebungY);
        }
        else{
            GUIManager.get().zeichnen(g,this);
        }
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
    
    public static void changeDrawMode(boolean d){
        draw = d;
    }
    
    public static void chagneCalculateMode(boolean c){
        calculate = c;
    }
    
    public static boolean getDrawMode(){
        return draw;
    }
    
    public static boolean getCalculateMode(){
        return calculate;
    }
}