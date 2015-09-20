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
    
    public GUITextWindow openTextWindow(int x,int y,int width,int height,String text){
        GUITextWindow w = new GUITextWindow(x,y,width,height,text);
        gui.add(w);
        Gamepanel.changeCalculateMode(false);
        return w;
    }
    
    public GUIChooseWindow openChooseWindow(int x,int y,String... options){
        GUIChooseWindow w = new GUIChooseWindow(x,y,options);
        gui.add(w);
        Gamepanel.changeCalculateMode(false);
        return w;
    }
    
    public GUITextInteractionScript openInteraction(int x,int y,int width,int height,int interaction){
        if(interaction == 1){
            Interaction1 i = new Interaction1(x,y,width,height);
            gui.add(i);
            Gamepanel.changeCalculateMode(false);
            return i;
        }
        return null;
    }
    
    public void removeElement(GUIElement e){
        gui.remove(e);
        if(gui.size() == 0){
            Gamepanel.changeCalculateMode(true);
        }
    }
    
    public void calculate(){
        for(int i = 0; i < gui.size();i++){
            gui.get(i).calculate();
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