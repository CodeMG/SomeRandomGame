import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class Background extends Drawobject{
    private BufferedImage image;
    public Background(double x,double y,double width,double height,Scene scene,BufferedImage image){
        super(x,y,width,height,scene);
        this.image = image;
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        g.drawImage(image,(int)x+verschiebungX,(int)y+verschiebungY,(int)width,(int)height,panel);
    }
    
    public void calculate(){
        
    }
}