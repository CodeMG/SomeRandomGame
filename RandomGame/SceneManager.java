import java.util.*;

public class SceneManager{
    private static ArrayList<Scene> scenes;
    private SceneReader reader;
    public SceneManager(){
        scenes = new ArrayList<Scene>();
        
        reader = new SceneReader();
        //scenes.add(reader.createScene("level1.lvl"));
        scenes.add(new Dungeon(100,100,20));
    }
    
    public static ArrayList<Scene> getScenes(){
        return scenes;
    }
    
    
}