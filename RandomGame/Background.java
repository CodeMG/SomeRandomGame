import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class Background extends Drawobject{
    private BufferedImage image;
    public Background(Scene scene,BufferedImage image){
        super(0,0,Gamepanel.getW(),Gamepanel.getH(),scene);
        this.image = image;
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        g.drawImage(image,(int)x,(int)y,(int)width,(int)height,panel);
    }
    
    public void calculate(){
        
    }
}