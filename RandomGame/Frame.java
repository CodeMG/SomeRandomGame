import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    
    private Gamepanel panel;
    public Frame(){
        pack();
        setSize(800,600);
        setTitle("BLUB");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        
        int decorationWidth = getInsets().left + getInsets().right;
		int decorationHeight = getInsets().top + getInsets().bottom;
		int frameWidth = getWidth() - decorationWidth;
		int frameHeight = getHeight() - decorationHeight;
		
		setSize(800+decorationWidth,600+decorationHeight);
		panel = new Gamepanel(800,600);
		panel.setVisible(true);
		add(panel);
		
		setVisible(true);
    }
    
    
    
}