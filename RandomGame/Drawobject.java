import javax.swing.*;
import java.awt.*;
public abstract class Drawobject{
    protected double x,y,width,height;
    protected Scene scene;
    public Drawobject(double x,double y,double width,double height,Scene scene){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scene = scene;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public abstract void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY);
        
    public abstract void calculate();
}