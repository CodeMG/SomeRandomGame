import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

public class Interaction1 extends GUITextInteractionScript{
    private GUITextWindow first,second;
    private GUIChooseWindow firstChoice;
    public Interaction1(int x,int y,int width,int height){
        super(x,y,width,height);
        interactionLoad();
    }
    
    public void type(KeyEvent e){
        
    }
    
    public void calculate(){
        if(first.getCurrentPage() == first.getTotalAmountOfPages() && firstChoice == null){
            firstChoice = GUIManager.get().openChooseWindow(x,(int)(Frame.getSizeHeight()*0.5),"Bob","Steve");
        }
        if(firstChoice != null && second == null){
            if(firstChoice.getAnswer() == 0){
                first.delete();
                second = GUIManager.get().openTextWindow(x,y,width,height,"Are you stupid dude?");
                delete();
            }
            else if(firstChoice.getAnswer() == 1){
                first.delete();
                second = GUIManager.get().openTextWindow(x,y,width,height,"That was correct!");
                delete();
            }
        }
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        
    }
    
    public void interactionLoad(){
        first = GUIManager.get().openTextWindow(x,y,width,height,"I will let you pass if you say me       my Name");
    }
    
    
}