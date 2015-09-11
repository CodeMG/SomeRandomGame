import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class Player extends Unit{
    private int xOffset,yOffset;
    public Player(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }

    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        g.setColor(Color.RED);
        g.fillRect((int)8*Gamepanel.getGRIDSIZE(),(int)6*Gamepanel.getGRIDSIZE(),(int)width,(int)height);
    }

    public void calculate(){
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
            Obstacle o = collisionWithObstacle((int)(x+Gamepanel.getGRIDSIZE()),(int)y);
            if(o == null){
                moveRight = true;
                Unit u = collisionWithUnit((int)(x+Gamepanel.getGRIDSIZE()),(int)y);
                if(u == null){
                    moveRight = true;
                }else{
                    u.onCollision(this,(int)(x+Gamepanel.getGRIDSIZE()),(int)y);
                    moveRight = false;
                }
            }else{
                o.onCollision(this,(int)(x+Gamepanel.getGRIDSIZE()),(int)y);
            }
        }
    }

    public void moveLeft(){
        if((!moveRight) && (!moveUp) && (!moveDown)){
            Obstacle o = collisionWithObstacle((int)(x-Gamepanel.getGRIDSIZE()),(int)y);
            if(o == null){
                moveLeft = true;
                Unit u = collisionWithUnit((int)(x-Gamepanel.getGRIDSIZE()),(int)y);
                if(u == null){
                    moveLeft = true;
                }else{
                    u.onCollision(this,(int)(x-Gamepanel.getGRIDSIZE()),(int)y);
                    moveLeft = false;
                }
            }else{
                o.onCollision(this,(int)(x-Gamepanel.getGRIDSIZE()),(int)y);
            }
        }
    }

    public void moveUp(){
        if((!moveRight) && (!moveLeft) && (!moveDown)){
            Obstacle o = collisionWithObstacle((int)(x),(int)(y-Gamepanel.getGRIDSIZE()));
            if(o == null){
                moveUp = true;
                Unit u = collisionWithUnit((int)(x),(int)(y-Gamepanel.getGRIDSIZE()));
                if(u == null){
                    moveUp = true;
                }else{
                    u.onCollision(this,(int)(x),(int)(y-Gamepanel.getGRIDSIZE()));
                    moveUp = false;
                }
            }else{
                o.onCollision(this,(int)(x),(int)(y-Gamepanel.getGRIDSIZE()));
            }
        }
    }

    public void moveDown(){
        if((!moveLeft) && (!moveRight) && (!moveUp)){
            Obstacle o = collisionWithObstacle((int)(x),(int)(y+Gamepanel.getGRIDSIZE()));
            if(o == null){
                moveDown = true;
                Unit u = collisionWithUnit((int)(x),(int)(y+Gamepanel.getGRIDSIZE()));
                if(u == null){
                    moveDown = true;
                }else{
                    u.onCollision(this,(int)(x),(int)(y+Gamepanel.getGRIDSIZE()));
                    moveDown = false;
                }
            }else{
                o.onCollision(this,(int)(x),(int)(y+Gamepanel.getGRIDSIZE()));
            }
        }
    }

    public Unit collisionWithUnit(int futureX,int futureY){
        Rectangle rect1 = new Rectangle(futureX,futureY,Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE());
        Rectangle rect2;
        ArrayList<Unit> units = scene.getUnits();

        for(int i = 0; i < units.size();i++){
            rect2 = new Rectangle((int)(units.get(i).getX()*units.get(i).getWidth()),(int)(units.get(i).getY()*units.get(i).getHeight()),(int)units.get(i).getWidth(),(int)units.get(i).getHeight());
            if(rect1.intersects(rect2)){
                return units.get(i);
            }
        }
        return null;
    }
}