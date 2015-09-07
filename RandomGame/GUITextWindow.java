import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
public class GUITextWindow extends GUIElement{
    private String text;
    private char[][] textPieces;
    private int charsPerLine = 20;
    private int pages;
    private int currentPage;
    public GUITextWindow(int x,int y,int width,int height,String text){
        super(x,y,width,height);
        this.text = text;
        pages = 0;
        currentPage = 1;
        textAnalyser(text);
    }

    private void textAnalyser(String text){
        int amountOfChars = 0;
        amountOfChars = text.length();
        textPieces = new char[(int)(amountOfChars/charsPerLine)+1][charsPerLine];
        for(int i = 0; i < textPieces.length;i++){
            for(int j = 0; j < textPieces[i].length;j++){
                if(text.length()> ((i*20)+j)){
                    textPieces[i][j] = text.charAt((i*20)+j);
                }
            }
        }
        pages = (int)((textPieces.length/2));
    }

    public void type(KeyEvent key){
        currentPage+=1;
        if(currentPage > pages){
            GUIManager.get().removeElement(this);
        }
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
        g.setColor(Color.WHITE);
        int width = (int)(this.width/charsPerLine);

        g.setFont(new Font("Arial", Font.BOLD, 30)); 

        for(int i = 0; i < textPieces.length;i++){
            for(int j = 0; j < textPieces[i].length;j++){
                if(i*20+j < text.length()){
                    g.drawString(""+textPieces[i][j],x+(j*(width)),y+(((i)*((this.height/2))))+20);
                }
            }
        }
    }

    public void calculate(){
        
    }

}