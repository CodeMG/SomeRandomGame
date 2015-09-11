import javax.swing.*;
import java.awt.*;

public class Steve extends NPC{
    
    public Steve(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }
    
    public void talk(){
        GUIManager.get().openTextWindow(0,(int)(Frame.getSizeHeight()*0.8),Frame.getSizeWidth(),(int)(Frame.getSizeHeight()*0.2),"Hi, my name ist Steve.");
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        g.setColor(Color.BLUE);
        g.fillRect((int)(x*width)+verschiebungX,(int)(y*height)+verschiebungY,(int)width,(int)height);
    }
    
}