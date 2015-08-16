import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Dungeon extends Scene{
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
    }
}