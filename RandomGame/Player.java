import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Player extends Unit{

    public Player(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }

    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        g.setColor(Color.RED);
        g.fillRect((int)6*Gamepanel.getGRIDSIZE(),(int)4*Gamepanel.getGRIDSIZE(),(int)width,(int)height);
    }

}