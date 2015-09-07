import java.util.*;

public class SceneManager{
    private static ArrayList<Scene> scenes;
    private SceneReader reader;
    private static Gamepanel panel;
    public SceneManager(Gamepanel panel){
        
        this.panel = panel;
        scenes = new ArrayList<Scene>();
        
        reader = new SceneReader();
        Scene test = reader.createScene("level1.lvl");
        test.addObstacles(new WoodenHouse(0,0,48*5,48*4,test,Pictures.getHouseWooden()));
        scenes.add(test);
        //scenes.add(new Dungeon(50,50,5,10));
    }
    
    public static ArrayList<Scene> getScenes(){
        return scenes;
    }
    
    public static void load(Scene scene){
        panel.setScene(scene);
    }
}