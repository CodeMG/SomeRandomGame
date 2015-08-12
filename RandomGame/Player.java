import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Player extends Unit{
    public Player(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        g.setColor(Color.RED);
        g.fillRect((int)6*64,(int)4*64,(int)width,(int)height);
    }
    
    public void moveRight(){
        x+=1;
    }
    
    public void moveLeft(){
        x-=1;
    }
    
    public void moveUp(){
        y-=1;
    }

    public void moveDown(){
        y+=1;
    }
}