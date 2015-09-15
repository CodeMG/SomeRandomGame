import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionPanel extends JPanel{
    private OptionChoosePanel option;
    private ControlPanel control;
    private SoundPanel sound;
    private SizePanel size;
    private Mainmenu container;
    public OptionPanel(int width,int height,Mainmenu container){
        setSize(width,height);
        setLayout(null);
        setBackground(Color.BLACK);

        this.container = container;
        
        option = new OptionChoosePanel(width,height,this);
        add(option);

    }

    public void showControl(){
        remove(option);
        control = new ControlPanel(getWidth(),getHeight(),this);
        add(control);
        repaint();
    }
    
    public void showSound(){
        remove(option);
        sound = new SoundPanel(getWidth(),getHeight(),this);
        add(sound);
        repaint();
    }
    
    public void showSize(){
        
    }
    
    public void showChoosePanelAndRemove(JPanel panel){
        remove(panel);
        option = new OptionChoosePanel(getWidth(),getHeight(),this);
        add(option);
        repaint();
    }
    
    public void showMenuAndRemove(JPanel panel){
        remove(panel);
        container.showMenuAndRemove(this);
    }
    
}