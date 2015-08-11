import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel{
    private TestFrame container;
    private Drawobject[][] grid;
    public TestPanel(int width,int height,TestFrame container,Drawobject[][] grid){
        setSize(width,height);
        setLayout(null);
        setVisible(true);
        this.container = container;
        this.grid = grid;
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[i].length;j++){
                if(grid[i][j] != null){
                    grid[i][j].zeichnen(g,this);
                    System.out.println("test");
                }
            }
        }
    }
}