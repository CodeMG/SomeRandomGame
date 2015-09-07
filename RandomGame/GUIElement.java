import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
public abstract class GUIElement{
    protected int x,y,width,height;
    
    public GUIElement(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void zeichnen(Graphics g,JPanel panel);
        
    public abstract void calculate();
    
    public abstract void type(KeyEvent key);
    
}