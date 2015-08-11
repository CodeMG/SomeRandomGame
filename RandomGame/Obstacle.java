import javax.swing.*;
import java.awt.*;

public class Obstacle extends Drawobject{
    
    public Obstacle(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        g.setColor(Color.WHITE);
        g.fillRect((int)x,(int)y,2,2);
    }
}