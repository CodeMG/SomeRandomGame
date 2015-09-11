import javax.swing.*;
import java.awt.*;

public class Button extends JButton{
    private JPanel container;
    private String text;
    public Button(int x,int y,int width,int height,String text,JPanel container){
        this.container = container;
        setBounds(x,y,width,height);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setText(text);
    }
    
    public void setText(String text){
        this.text = text;
    }
    
    public String getText(){
        return text;
    }
    
}