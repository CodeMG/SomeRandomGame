import javax.swing.*;
import java.awt.*;

public class NPC extends Unit{
    public NPC(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }

    public void onCollision(Unit unit,int futureX,int futureY){
        talk();
    }
    
    public void talk(){

    }
    /*
    public void zeichnen(Graphics g,JPanel panel){
        
    }
    */
}