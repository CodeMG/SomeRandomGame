import javax.swing.*;
import java.awt.*;

public class SceneLoader extends Special{
    private Scene toLoad;
    public SceneLoader(double x,double y,double width,double height,Scene scene,Scene toLoad){
        super(x,y,width,height,scene);
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        if(Gamepanel.getDebugMode()){
            g.setColor(Color.RED);
            g.drawRect((int)x+verschiebungX,(int)y+verschiebungY,(int)width,(int)height);
        }
    }

    public void calculate(){
        
    }
    
    public void onCollision(Unit unit){
        SceneManager.load(scene);
    }
}