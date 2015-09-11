import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Unit extends Drawobject{
    protected boolean moveRight,moveLeft,moveUp,moveDown;

    public Unit(double x,double y,double width,double height,Scene scene){
        super(x,y,width,height,scene);
    }

    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){

    }

    public void calculate(){
        
    }

    public void onCollision(Unit unit,int futureX,int futureY){
        
    }
    
    public void moveRight(){
        if((!moveLeft)&&(!moveUp)&&(!moveDown)){
            Obstacle o = collisionWithObstacle((int)(x+Gamepanel.getGRIDSIZE()),(int)y);
            if(o == null){
                moveRight = true;
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
            }else{
                o.onCollision(this,(int)(x),(int)(y+Gamepanel.getGRIDSIZE()));
            }
        }
    }

    public Obstacle collisionWithObstacle(int futureX,int futureY){
        Rectangle rect1 = new Rectangle(futureX,futureY,Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE());
        Rectangle rect2;
        ArrayList<Obstacle> obstacles = scene.getObstacles();

        for(int i = 0; i < obstacles.size();i++){
            rect2 = new Rectangle((int)(obstacles.get(i).getX()*obstacles.get(i).getWidth()),(int)(obstacles.get(i).getY()*obstacles.get(i).getHeight()),(int)obstacles.get(i).getWidth(),(int)obstacles.get(i).getHeight());
            if(rect1.intersects(rect2)){
                return obstacles.get(i);
            }
        }
        return null;
    }
}