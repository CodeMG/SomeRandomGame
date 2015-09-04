import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Minimap{
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Unit> units;
    private Player player;
    private int x,y,width,height;
    public Minimap(int x,int y,int width,int height,Player player,ArrayList<Obstacle> obstacles,ArrayList<Unit> units){
        this.obstacles = obstacles;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        this.units = units;
        this.player = player;
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
        g.setColor(Color.GRAY);
        for(int i = 0; i < obstacles.size();i++){
            g.drawRect((int)(x+obstacles.get(i).getX()*2),(int)(y+obstacles.get(i).getY()*2),(int)2,(int)2);
        }
        g.setColor(Color.RED);
        for(int i = 0; i < units.size();i++){
            if(units.get(i) != player){
                g.fillRect((int)(x+units.get(i).getX()*2),(int)(y+units.get(i).getY()*2),2,2);
            }
        }
        g.setColor(Color.YELLOW);
        g.fillRect((int)(x+(player.getX()/Gamepanel.getGRIDSIZE())*2), (int)(y+(player.getY()/Gamepanel.getGRIDSIZE())*2), 2,2);
    }
    
}