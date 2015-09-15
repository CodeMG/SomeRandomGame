import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SoundPanel extends JPanel implements ActionListener{
    private OptionPanel container;
    private Button back;
    public SoundPanel(int width,int height,OptionPanel container){
        setSize(width,height);
        this.container = container;
        
        int buttonWidth = (int)(width*0.20);
        int buttonHeight = (int)(height * 0.05);
        
        back = new Button((int)((width*0.1)-(buttonWidth*0.5)),(int)((height*0.9)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Back",this);
        back.addActionListener(this);
        add(back);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            container.showChoosePanelAndRemove(this);
        } 
    }
    
}