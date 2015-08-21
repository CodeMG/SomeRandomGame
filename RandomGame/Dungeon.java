import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Dungeon extends Scene{
    private Minimap map;
    public Dungeon(int width,int height,int rooms){
        DungeonGenerator gen = new DungeonGenerator(width,height,rooms,1,this);

        for(int i = 0; i < gen.getGridForeground().length;i++){
            for (int j = 0; j < gen.getGridForeground()[i].length;j++){
                if(gen.getGridForeground()[i][j] != null){
                    addForeground(gen.getGridForeground()[i][j]);
                }
            }
        }
        
        for(int i = 0; i < gen.getGridObstacles().length;i++){
            for (int j = 0; j < gen.getGridObstacles()[i].length;j++){
                if(gen.getGridObstacles()[i][j] != null){
                    addObstacles(gen.getGridObstacles()[i][j]);
                }
            }
        }
        
        units = gen.getGridUnits();
        
        map = new Minimap(50,50,getObstacles());
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        super.zeichnen(g,panel,verschiebungX,verschiebungY);
        map.zeichnen(g,panel);
    }
}