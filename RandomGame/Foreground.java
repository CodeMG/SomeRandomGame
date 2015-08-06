import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class Foreground extends Drawobject{
    private BufferedImage image;
    public Foreground(double x,double y,double width,double height,Scene scene,BufferedImage image){
        super(x,y,width,height,scene);
        this.image = image;
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        g.drawImage(image,(int)(x*0.5),(int)(y*0.5),(int)(width*0.5),(int)(height*0.5),panel);
    }
}