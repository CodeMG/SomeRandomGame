import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame{
    private TestPanel panel;
    private Drawobject[][] grid;
    private DungeonGenerator gen;
    public TestFrame(){
        setSize(800,600);
        gen = new DungeonGenerator(400,400,10,1);
        grid = gen.getGrid();
        panel = new TestPanel(800,600,this,grid);
        add(panel);
        setVisible(true);
    }
    
}