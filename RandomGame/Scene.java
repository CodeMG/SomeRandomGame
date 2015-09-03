import java.util.*;
import java.awt.*;
import javax.swing.*;
public abstract class Scene{
    protected ArrayList<Unit> units;
    protected Background background;
    protected ArrayList<Foreground> foreground;
    protected ArrayList<Obstacle> obstacles;
    protected ArrayList<Special> specials;
    
    public Scene(){
        units = new ArrayList<Unit>();
        foreground = new ArrayList<Foreground>();
        obstacles = new ArrayList<Obstacle>();
        specials = new ArrayList<Special>();
    }
    
    public Player getPlayer(){
        return (Player)units.get(0);
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
         if(background != null){
            background.zeichnen(g,panel,verschiebungX,verschiebungY);
        }
         for(int i = 0; i < foreground.size();i++){
            foreground.get(i).zeichnen(g,panel,verschiebungX,verschiebungY);
        }
         for(int i = 0; i < obstacles.size();i++){
            obstacles.get(i).zeichnen(g,panel,verschiebungX,verschiebungY);
        }
         for(int i = 0; i < specials.size();i++){
            specials.get(i).zeichnen(g,panel,verschiebungX,verschiebungY);
        }
        for(int i = 0; i < units.size();i++){
            units.get(i).zeichnen(g,panel,verschiebungX,verschiebungY);
        }
    }
    
    public ArrayList<Unit> getUnits(){
        return units;
    }
    
    public void addUnit(Unit unit){
        units.add(unit);
    }
    
    public Background getBackground(){
        return background;
    }
    
    public void setBackground(Background background){
        this.background=background;
    }
    
    public ArrayList<Foreground> getForeground(){
        return foreground;
    }
    
    public void addForeground(Foreground foreground){
        this.foreground.add(foreground);
    }
    
    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }
    
    public void addObstacles(Obstacle obstacle){
        this.obstacles.add(obstacle);
    }
    
    public ArrayList<Special> getSpecials(){
        return specials;
    }
    
     public void addSpecials(Special special){
        this.specials.add(special);
    }
}