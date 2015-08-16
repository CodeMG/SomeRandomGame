import javax.swing.*;
import java.awt.*;

public class Unit extends Drawobject{
    protected boolean moveRight,moveLeft,moveUp,moveDown;
    private int xOffset,yOffset;
    public Unit(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        
    }
    
    public void calculate(){
        if(moveRight){
            xOffset+=Gamepanel.getGRIDSIZE()/4;
            x+=Gamepanel.getGRIDSIZE()/4;
            if(xOffset>=Gamepanel.getGRIDSIZE()){
                moveRight = false;
                xOffset = 0;
            }
        }
        else if(moveLeft){
            xOffset-=Gamepanel.getGRIDSIZE()/4;
            x-=Gamepanel.getGRIDSIZE()/4;
            if(xOffset<=-Gamepanel.getGRIDSIZE()){
                moveLeft = false;
                xOffset = 0;
            }
        }
        else if(moveDown){
            yOffset+=Gamepanel.getGRIDSIZE()/4;
            y+=Gamepanel.getGRIDSIZE()/4;
            if(yOffset>=Gamepanel.getGRIDSIZE()){
                moveDown = false;
                yOffset = 0;
            }
        }
        else if(moveUp){
            yOffset-=Gamepanel.getGRIDSIZE()/4;
            y-=Gamepanel.getGRIDSIZE()/4;
            if(yOffset<=-Gamepanel.getGRIDSIZE()){
                moveUp = false;
                yOffset = 0;
            }
        }
    }
    
    public void moveRight(){
        if((!moveLeft)&&(!moveUp)&&(!moveDown)){
            moveRight = true;
        }
    }

    public void moveLeft(){
        if((!moveRight) && (!moveUp) && (!moveDown)){
            moveLeft = true;
        }
    }

    public void moveUp(){
        if((!moveRight) && (!moveLeft) && (!moveDown)){
            moveUp = true;
        }
    }

    public void moveDown(){
        if((!moveLeft) && (!moveRight) && (!moveUp)){
            moveDown = true;
        }
    }
}