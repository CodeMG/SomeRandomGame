import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Unit extends Drawobject{
    protected boolean moveRight,moveLeft,moveUp,moveDown;
    private int xOffset,yOffset;
    public Unit(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }

    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){

    }

    public void calculate(){
        System.out.print(x);
        if(moveRight){
            xOffset+=Gamepanel.getGRIDSIZE()/8;
            x+=Gamepanel.getGRIDSIZE()/8;
            if(xOffset>=Gamepanel.getGRIDSIZE()){
                moveRight = false;
                xOffset = 0;
            }
        }
        else if(moveLeft){
            xOffset-=Gamepanel.getGRIDSIZE()/8;
            x-=Gamepanel.getGRIDSIZE()/8;
            if(xOffset<=-Gamepanel.getGRIDSIZE()){
                moveLeft = false;
                xOffset = 0;
            }
        }
        else if(moveDown){
            yOffset+=Gamepanel.getGRIDSIZE()/8;
            y+=Gamepanel.getGRIDSIZE()/8;
            if(yOffset>=Gamepanel.getGRIDSIZE()){
                moveDown = false;
                yOffset = 0;
            }
        }
        else if(moveUp){
            yOffset-=Gamepanel.getGRIDSIZE()/8;
            y-=Gamepanel.getGRIDSIZE()/8;
            if(yOffset<=-Gamepanel.getGRIDSIZE()){
                moveUp = false;
                yOffset = 0;
            }
        }
    }

    public void moveRight(){
        if((!moveLeft)&&(!moveUp)&&(!moveDown)){
            if(!collision((int)(x+Gamepanel.getGRIDSIZE()),(int)y)){
                moveRight = true;
            }
        }
    }

    public void moveLeft(){
        if((!moveRight) && (!moveUp) && (!moveDown)){
            if(!collision((int)(x-Gamepanel.getGRIDSIZE()),(int)y)){
                moveLeft = true;
            }
        }
    }

    public void moveUp(){
        if((!moveRight) && (!moveLeft) && (!moveDown)){
            if(!collision((int)(x),(int)(y-Gamepanel.getGRIDSIZE()))){
                moveUp = true;
            }
        }
    }

    public void moveDown(){
        if((!moveLeft) && (!moveRight) && (!moveUp)){
            if(!collision((int)(x),(int)(y+Gamepanel.getGRIDSIZE()))){
                moveDown = true;
            }
        }
    }

    public boolean collision(int futureX,int futureY){
        Rectangle rect1 = new Rectangle(futureX,futureY,Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE());
        Rectangle rect2;
        ArrayList<Obstacle> obstacles = scene.getObstacles();

        for(int i = 0; i < obstacles.size();i++){
            rect2 = new Rectangle((int)(obstacles.get(i).getX()*obstacles.get(i).getWidth()),(int)(obstacles.get(i).getY()*obstacles.get(i).getHeight()),(int)obstacles.get(i).getWidth(),(int)obstacles.get(i).getHeight());
            if(rect1.intersects(rect2)){
                return true;
            }
        }
        return false;
    }
}