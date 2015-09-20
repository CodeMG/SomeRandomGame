import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public abstract class GUITextInteractionScript extends GUIElement{
    protected int interaction;
    public GUITextInteractionScript(int x,int y,int width,int height){
        super(x,y,width,height);
        this.interaction = interaction;
    }
    
    public abstract void interactionLoad();
    
    public void delete(){
        GUIManager.get().removeElement(this);
    }
    
}