import java.util.*;;
public abstract class Scene{
    private ArrayList<Unit> units;
    private ArrayList<Background> background;
    private ArrayList<Foreground> foreground;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Special> specials;
    
    public Scene(){
        units = new ArrayList<Unit>();
        background = new ArrayList<Background>();
        foreground = new ArrayList<Foreground>();
        obstacles = new ArrayList<Obstacle>();
        specials = new ArrayList<Special>();
    }
    
    public ArrayList<Unit> getUnits(){
        return units;
    }
    
    public ArrayList<Background> getBackground(){
        return background;
    }
    
    public ArrayList<Foreground> getForeground(){
        return foreground;
    }
    
    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }
    
    public ArrayList<Special> getSpecials(){
        return specials;
    }
}