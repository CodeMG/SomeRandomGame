import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    private Gamepanel panel;
    private Mainmenu menu;
    public Frame(){
        pack();
        setSize(64*13,64*10);
        setTitle("BLUB");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        
        int decorationWidth = getInsets().left + getInsets().right;
        int decorationHeight = getInsets().top + getInsets().bottom;
        int frameWidth = getWidth() - decorationWidth;
        int frameHeight = getHeight() - decorationHeight;
        
        setSize((64*13)+decorationWidth,(64*10)+decorationHeight);
        
        //panel = new Gamepanel(64*13,64*10);
        //add(panel);
        
        
        menu = new Mainmenu(64*13,64*10);
        menu.setVisible(true);
        add(menu);
        setVisible(true);
    }
    
    
    
}