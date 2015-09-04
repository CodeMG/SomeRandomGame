import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class House extends Obstacle{
    protected Scene inside;
    protected boolean open;
    public House(double x,double y,double width,double height,Scene scene,BufferedImage image){
        super(x,y,width,height,scene,image);
    }
    
    public void onCollision(Unit unit,int futureX,int futureY){
        
    }
    
}