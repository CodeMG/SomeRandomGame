import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GUIChooseWindow extends GUIElement{
    private int optionChosen;
    private String[] options;
    private int focus = 0;
    public GUIChooseWindow(int x,int y,String... options){
        super(x,y,0,0);
        optionChosen = -1;
        focus = 0;
        this.options = options;
    }

    public void type(KeyEvent e){
        if(e.getKeyCode() == Controller.getDown()){
            if(focus < options.length-1){
                focus+=1;
            }
        }
        else if(e.getKeyCode() == Controller.getUp()){
            if(focus > 0){
                focus-=1;
            }
        }
        else if(e.getKeyCode() == Controller.getAttack()){
            optionChosen = focus;
            delete();
        }
    }

    public void calculate(){

    }

    public void zeichnen(Graphics g,JPanel panel){
        Font arial = new Font("Arial",Font.BOLD,30);
        FontMetrics fm = g.getFontMetrics(arial);
        g.setFont(arial); 

        int maxWidth = 0;
        for(int i = 0; i < options.length;i++){
            int currentWidth = fm.stringWidth(options[i]);
            if(currentWidth>maxWidth){
                maxWidth = currentWidth;
            }
        }

        int maxHeight = 0;

        for(int i = 0; i < options.length;i++){
            maxHeight+=fm.getHeight();
        }

        g.setColor(Color.WHITE);
        g.fillRect(x,y,maxWidth+10,maxHeight+10);
        g.setColor(Color.BLACK);
        g.fillRect(x+5,y+5,maxWidth,maxHeight);
        for(int i = 0; i < options.length;i++){
            if(focus == i){
                g.setColor(new Color(1,0,0,0.5f));
                g.fillRect(x+5,5+y+(i*fm.getHeight()),maxWidth,fm.getHeight());
            }
            g.setColor(Color.WHITE);
            g.drawString(options[i],x+5,(int)(fm.getHeight()*0.8)+y+(i*fm.getHeight()));
        }
    }

    public int getAnswer(){
        return optionChosen;
    }
    
    public void delete(){
        GUIManager.get().removeElement(this);
    }
    
}