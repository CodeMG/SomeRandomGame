import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    
    private Gamepanel panel;
    public Frame(){
        pack();
        setSize(64*13,64*10);
        setTitle("BLUB");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(true);
        
        int decorationWidth = getInsets().left + getInsets().right;
		int decorationHeight = getInsets().top + getInsets().bottom;
		int frameWidth = getWidth() - decorationWidth;
		int frameHeight = getHeight() - decorationHeight;
		
		setSize((64*13)+decorationWidth,(64*10)+decorationHeight);
		panel = new Gamepanel(64*13,64*10);
		panel.setVisible(true);
		add(panel);
		
		setVisible(true);
    }
    
    
    
}