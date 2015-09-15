import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mainmenu extends JPanel{
    private CreditsPanel credits;
    private OptionPanel options;
    private Gamepanel game;
    private MenuPanel menu;
    public Mainmenu(int width,int height){
        setSize(width,height);
        setLayout(null);
        setBackground(Color.BLACK);

        menu = new MenuPanel(width,height,this);
        add(menu);

    }

    public void showCredits(){
        remove(menu);
        credits = new CreditsPanel(getWidth(),getHeight(),this);
        add(credits);
        repaint();
    }

    public void showGame(){
        remove(menu);
        game = new Gamepanel(getWidth(),getHeight());
        add(game);
        repaint();
    }

    public void showOptions(){
        remove(menu);
        options = new OptionPanel(getWidth(),getHeight(),this);
        add(options);
        repaint();
    }

    public void showMenuAndRemove(JPanel panel){
        remove(panel);
        menu = new MenuPanel(getWidth(),getHeight(),this);
        add(menu);
        repaint();
    }
}