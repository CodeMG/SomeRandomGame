import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
        currentPage = 0;
        textAnalyser(text);
        
    }

    private void textAnalyser(String text){
        int amountOfChars = 0;
        amountOfChars = text.length();
        if((((int)(amountOfChars/charsPerLine)) % 2) != 0){
            textPieces = new char[(int)(amountOfChars/charsPerLine)+1][charsPerLine];
        }else{
            textPieces = new char[(int)(amountOfChars/charsPerLine)+2][charsPerLine];
        }
        for(int i = 0; i < textPieces.length;i++){
            for(int j = 0; j < textPieces[i].length;j++){
                if(text.length()> ((i*20)+j)){
                    textPieces[i][j] = text.charAt((i*20)+j);
                }
            }
        }
        if( ((int)((textPieces.length)) % 2) == 0){
            pages = (int)((textPieces.length/2)-1);
        }
        else {
            pages = (int)((textPieces.length/2));
        }
    }

    public void type(KeyEvent key){
        if(key.getKeyCode() == Controller.getAttack()){
            if(currentPage >= pages){
                delete();
            }
            currentPage+=1;
        }
    }

    public void zeichnen(Graphics g,JPanel panel){
        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
        g.setColor(Color.WHITE);
        int width = (int)(this.width/charsPerLine);

        g.setFont(new Font("Arial", Font.BOLD, 30)); 

        for(int i = currentPage*2; i < (currentPage*2+2);i++){
            for(int j = 0; j < textPieces[i].length;j++){
                int k = 0;
                for(int z = 0; z < i;z++){
                    k+=1;
                    if(k == 2){
                        k = 0;
                    }
                }
                if(i*20+j < text.length()){
                    g.drawString(""+textPieces[i][j],x+(j*(width)),y+(((k)*((this.height/2))))+20);
                }
            }
        }
    }

    public void calculate(){

    }

    public void delete(){
        GUIManager.get().removeElement(this);
    }
    
    public int getCurrentPage(){
        return currentPage;
    }
    
    public int getTotalAmountOfPages(){
        return pages;
    }
    
}