import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class Foreground extends Drawobject{
    private BufferedImage image;
    public Foreground(double x,double y,double width,double height,Scene scene,BufferedImage image){
        super(x,y,width,height,scene);
        this.image = image;
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        g.drawImage(image,(int)((x+verschiebungX)*width),(int)((y+verschiebungY)*height),(int)(width),(int)(height),panel);
        
        //g.setColor(Color.GRAY);
        //g.fillRect((int)x,(int)y,2,2);
    }
}