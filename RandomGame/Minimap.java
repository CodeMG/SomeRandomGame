import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Minimap{
    private ArrayList<Obstacle> obstacles;
    private int x,y;
    public Minimap(int x,int y,ArrayList<Obstacle> obstacles){
        this.obstacles = obstacles;
        this.x = x;
        this.y = y;
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        g.setColor(Color.WHITE);
        for(int i = 0; i < obstacles.size();i++){
            g.drawRect((int)(x+obstacles.get(i).getX()*2),(int)(y+obstacles.get(i).getY()*2),(int)2,(int)2);
        }
    }
    
}