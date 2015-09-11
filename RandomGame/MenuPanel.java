import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener{
    private Button start,options,credits,exit;
    
    private Mainmenu container;
    
    private CreditsPanel creditsPanel;
    public MenuPanel(int width,int height,Mainmenu container){
        setSize(width,height);
        setLayout(null);
        setBackground(Color.BLACK);
        
        this.container = container;
        
        int buttonWidth = (int)(width*0.25);
        int buttonHeight = (int)(height * 0.1);
        
        start = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.5)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Start",this);
        start.addActionListener(this);
        add(start);
        
        options = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.65)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Options",this);
        options.addActionListener(this);
        add(options);
        
        credits = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.8)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Credits",this);
        credits.addActionListener(this);
        add(credits);
        
        exit = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.95)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Exit",this);
        exit.addActionListener(this);
        add(exit);
        
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == start){
            container.showGame();
        }
        else if(e.getSource() == options){
            container.showOptions();
        }
        else if(e.getSource() == credits){
            container.showCredits();
        }
        else if(e.getSource() == exit){
            System.exit(0);
        }
    }
    
}