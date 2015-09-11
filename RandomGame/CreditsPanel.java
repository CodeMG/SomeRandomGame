import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CreditsPanel extends JPanel implements ActionListener{
    private Mainmenu container;
    private Button back;
    private String[][] text;
    private int y;
    public CreditsPanel(int width,int height,Mainmenu container){
        this.container = container;
        setSize(width,height);
        setBackground(Color.BLACK);
        
        y = height;
        
        text = new String[3][2];
        text[0][0] = "MAIN DESIGNER";
        text[0][1] = "Mehmet Gül";
        text[1][0] = "MAIN ARTIST";
        text[1][1] = "Mehmet Gül";
        text[2][0] = "MAIN PROGRAMMER";
        text[2][1] = "Mehmet Gül";
        
        int buttonWidth = (int)(width*0.20);
        int buttonHeight = (int)(height * 0.05);
        
        back = new Button((int)((width*0.1)-(buttonWidth*0.5)),(int)((height*0.9)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Back",this);
        back.addActionListener(this);
        add(back);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        int newY = y;
        for(int i = 0; i < text.length;i++){
            g.setFont(new Font("Arial", Font.BOLD, 30)); 
            
            newY = y+(i*100);
            
            g.setColor(new Color(1,1,1,(float)((Math.sin((newY*0.0088)-1.2)+1)*0.5)));
            
            g.drawString(text[i][0],(int)((getWidth()*0.5)-(g.getFontMetrics().stringWidth(text[i][0])*0.5)),newY);
            for(int j = 1; j < text[i].length;j++){
                g.setFont(new Font("Arial", Font.BOLD, 20)); 
                
                newY = y+(i*100)+(j*50);
                
                g.setColor(new Color(1,1,1,(float)((Math.sin((newY*0.0088)-1.2)+1)*0.5)));
                
                g.drawString(text[i][j],(int)((getWidth()*0.5)-(g.getFontMetrics().stringWidth(text[i][j])*0.5)),newY);
            }
        }
        y-=1;
        try{
            Thread.sleep(10);
        }catch(Exception e){
            
        }
        repaint();
    }
    
    public void actionPerformed(ActionEvent e){
        container.showMenuAndRemove(this);
    }
    
}