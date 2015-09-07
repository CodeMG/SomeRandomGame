import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
public class GUIManager{
    private static GUIManager manager;
    private ArrayList<GUIElement> gui;
    public GUIManager(){
        manager = this;
        gui = new ArrayList<GUIElement>();
    }
    
    public static GUIManager get(){
        if(manager == null){
            manager = new GUIManager();
        }
        return manager;
    }
    
    public void openTextWindow(int x,int y,int width,int height,String text){
        gui.add(new GUITextWindow(x,y,width,height,text));
        Gamepanel.changeDrawMode(false);
    }
    
    public void removeElement(GUIElement e){
        gui.remove(e);
        if(gui.size() == 0){
            Gamepanel.changeDrawMode(true);
        }
    }
    
    public void type(KeyEvent key){
        for(int i = 0; i < gui.size();i++){
            gui.get(i).type(key);
        }
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        for(int i = 0; i < gui.size();i++){
            gui.get(i).zeichnen(g,panel);
        }
    }
    
}