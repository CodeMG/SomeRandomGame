import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Dungeon extends Scene{
    private Drawobject[][] gridObstacles;
    private Drawobject[][] gridForeground;
    private ArrayList<Unit> gridUnits;
    public Dungeon(int width,int height,int rooms){
        DungeonGenerator gen = new DungeonGenerator(width,height,rooms,1,this);

        gridObstacles = gen.getGridObstacles();
        gridForeground = gen.getGridForeground();
        gridUnits = gen.getGridUnits();
    }

    public Player getPlayer(){
        return (Player)gridUnits.get(0);
    }
    
    public void zeichnen(Graphics g,JPanel panel,int verschiebungX,int verschiebungY){
        for(int i = 0; i < gridForeground.length;i++){
            for(int j = 0; j < gridForeground[i].length;j++){
                if(gridForeground[i][j] != null){
                    gridForeground[i][j].zeichnen(g,panel,verschiebungX,verschiebungY);
                }
            }
        }
        for(int i = 0; i < gridObstacles.length;i++){
            for(int j = 0; j < gridObstacles[i].length;j++){
                if(gridObstacles[i][j] != null){
                    gridObstacles[i][j].zeichnen(g,panel,verschiebungX,verschiebungY);
                }
            }
        }

        for(int i = 0; i < gridUnits.size();i++){
            gridUnits.get(i).zeichnen(g,panel,verschiebungX,verschiebungY);
        }

    }

}