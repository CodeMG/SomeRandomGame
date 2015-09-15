import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionChoosePanel extends JPanel implements ActionListener{
    private OptionPanel container;
    
    private Button controls,sounds,size,back;
    public OptionChoosePanel(int width,int height,OptionPanel container){
        setSize(width,height);
        setLayout(null);
        this.container = container;
        setBackground(Color.BLACK);
        
        int buttonWidth = (int)(width*0.25);
        int buttonHeight = (int)(height * 0.1);
        
        controls = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.5)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Controls",this);
        controls.addActionListener(this);
        add(controls);
        
        sounds = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.65)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Sounds",this);
        sounds.addActionListener(this);
        add(sounds);
        
        size = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.8)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Size",this);
        size.addActionListener(this);
        add(size);
        
        buttonWidth = (int)(width*0.20);
        buttonHeight = (int)(height * 0.05);
        
        back = new Button((int)((width*0.1)-(buttonWidth*0.5)),(int)((height*0.9)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Back",this);
        back.addActionListener(this);
        add(back);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == controls){
            container.showControl();
        }
        else if(e.getSource() == sounds){
            container.showSound();
        }
        else if(e.getSource() == size){
            container.showSize();
        }
        else if(e.getSource() == back){
            container.showMenuAndRemove(this);
        }
    }
    
}