import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Player extends Unit{
    
    public Player(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y,(int)width,(int)height);
    }
    
    public void moveRight(){
        x+=64;
    }
    
    public void moveLeft(){
        x-=64;
    }
    
    public void moveUp(){
        y-=64;
    }

    public void moveDown(){
        y+=64;
    }
}