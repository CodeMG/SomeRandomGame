import java.util.*;
import java.awt.*;
import javax.swing.*;
public abstract class Scene{
    protected ArrayList<Unit> units;
    protected ArrayList<Background> background;
    protected ArrayList<Foreground> foreground;
    protected ArrayList<Obstacle> obstacles;
    protected ArrayList<Special> specials;
    
    public Scene(){
        units = new ArrayList<Unit>();
        background = new ArrayList<Background>();
        foreground = new ArrayList<Foreground>();
        obstacles = new ArrayList<Obstacle>();
        specials = new ArrayList<Special>();
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        for(int i = 0; i < units.size();i++){
            units.get(i).zeichnen(g,panel);
        }
         for(int i = 0; i < background.size();i++){
            background.get(i).zeichnen(g,panel);
        }
         for(int i = 0; i < foreground.size();i++){
            foreground.get(i).zeichnen(g,panel);
        }
         for(int i = 0; i < obstacles.size();i++){
            obstacles.get(i).zeichnen(g,panel);
        }
         for(int i = 0; i < specials.size();i++){
            specials.get(i).zeichnen(g,panel);
        }
    }
    
    public ArrayList<Unit> getUnits(){
        return units;
    }
    
    public void addUnit(Unit unit){
        units.add(unit);
    }
    
    public ArrayList<Background> getBackground(){
        return background;
    }
    
    public void addBackground(Background background){
        this.background.add(background);
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