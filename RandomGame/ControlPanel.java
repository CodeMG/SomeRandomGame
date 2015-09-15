import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;

public class ControlPanel extends JPanel implements ActionListener,KeyListener{
    private int leftCode,rightCode,upCode,downCode,sp1Code,sp2Code,attackCode;
    private Button back,save,left,right,up,down,sp1,sp2,attack;
    private JTextArea upT,downT,leftT,rightT,sp1T,sp2T,attackT;
    private OptionPanel container;
    public ControlPanel(int width,int height,OptionPanel container){
        setSize(width,height);
        setBackground(Color.BLACK);
        setLayout(null);
        addKeyListener(this);
        this.container = container;

        readControlls();
        
        //createButtons
        int buttonWidth = (int)(width*0.25);
        int buttonHeight = (int)(height * 0.1);

        left = new Button((int)((width*0.25)-(buttonWidth*0.5)),(int)((height*0.3)-(buttonHeight*0.5)),buttonWidth,buttonHeight,KeyEvent.getKeyText(leftCode),this);
        left.addActionListener(this);
        add(left);
        
        right = new Button((int)((width*0.75)-(buttonWidth*0.5)),(int)((height*0.3)-(buttonHeight*0.5)),buttonWidth,buttonHeight,KeyEvent.getKeyText(rightCode),this);
        right.addActionListener(this);
        add(right);
        
        up = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.2)-(buttonHeight*0.5)),buttonWidth,buttonHeight,KeyEvent.getKeyText(upCode),this);
        up.addActionListener(this);
        add(up);
        
        down = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.3)-(buttonHeight*0.5)),buttonWidth,buttonHeight,KeyEvent.getKeyText(downCode),this);
        down.addActionListener(this);
        add(down);
        
        sp1 = new Button((int)((width*0.25)-(buttonWidth*0.5)),(int)((height*0.7)-(buttonHeight*0.5)),buttonWidth,buttonHeight,KeyEvent.getKeyText(sp1Code),this);
        sp1.addActionListener(this);
        add(sp1);
        
        sp2 = new Button((int)((width*0.5)-(buttonWidth*0.5)),(int)((height*0.7)-(buttonHeight*0.5)),buttonWidth,buttonHeight,KeyEvent.getKeyText(sp2Code),this);
        sp2.addActionListener(this);
        add(sp2);
        
        attack = new Button((int)((width*0.75)-(buttonWidth*0.5)),(int)((height*0.7)-(buttonHeight*0.5)),buttonWidth,buttonHeight,KeyEvent.getKeyText(attackCode),this);
        attack.addActionListener(this);
        add(attack);
        
        //createText
        
        buttonWidth = (int)(width*0.1);
        buttonHeight = (int)(height*0.05);
        
        leftT = new JTextArea("Left");
        leftT.setBackground(Color.BLACK);
        leftT.setForeground(Color.WHITE);
        leftT.setBounds((int)((width*0.1)-(buttonWidth*0.5)),(int)((height*0.3)-(buttonHeight*0.4)),buttonWidth,buttonHeight);
        add(leftT);
        
        rightT = new JTextArea("Right");
        rightT.setBackground(Color.BLACK);
        rightT.setForeground(Color.WHITE);
        rightT.setBounds((int)((width*0.95)-(buttonWidth*0.5)),(int)((height*0.3)-(buttonHeight*0.4)),buttonWidth,buttonHeight);
        add(rightT);
        
        upT = new JTextArea("Up");
        upT.setBackground(Color.BLACK);
        upT.setForeground(Color.WHITE);
        upT.setBounds((int)((width*0.5)-(buttonWidth*0.10)),(int)((height*0.1)-(buttonHeight*0.4)),buttonWidth,buttonHeight);
        add(upT);
        
        downT = new JTextArea("Down");
        downT.setBackground(Color.BLACK);
        downT.setForeground(Color.WHITE);
        downT.setBounds((int)((width*0.5)-(buttonWidth*0.2)),(int)((height*0.4)-(buttonHeight*0.4)),buttonWidth,buttonHeight);
        add(downT);
        //createBackButton
        
        buttonWidth = (int)(width*0.20);
        buttonHeight = (int)(height * 0.05);

        back = new Button((int)((width*0.1)-(buttonWidth*0.5)),(int)((height*0.9)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Back",this);
        back.addActionListener(this);
        add(back);
        
        save = new Button((int)((width*0.9)-(buttonWidth*0.5)),(int)((height*0.9)-(buttonHeight*0.5)),buttonWidth,buttonHeight,"Save",this);
        save.addActionListener(this);
        add(save);
        
        
        
        
        
        requestFocus();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        requestFocus();
        
        try{
            Thread.sleep(10);
        }catch(Exception e){
            
        }
        repaint();
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == save){
            saveControlls();
        }
        else if(e.getSource() == back){
            container.showChoosePanelAndRemove(this);
        }
        else if(e.getSource() == right){
            enableAllButtons();
            right.setEnabled(false);;
        }
        else if(e.getSource() == left){
            enableAllButtons();
            left.setEnabled(false);
        }
        else if(e.getSource() == up){
            enableAllButtons();
            up.setEnabled(false);
        }
        else if(e.getSource() == down){
            enableAllButtons();
            down.setEnabled(false);
        }
        else if(e.getSource() == sp1){
            enableAllButtons();
            sp1.setEnabled(false);
        }
        else if(e.getSource() == sp2){
            enableAllButtons();
            sp2.setEnabled(false);
        }
        else if(e.getSource() == attack){
            enableAllButtons();
            attack.setEnabled(false);
        }
    }
    
    public void keyPressed(KeyEvent e){
        if(!right.isEnabled()){
            rightCode = e.getKeyCode();
            right.setText(KeyEvent.getKeyText(rightCode));
            right.setEnabled(true);
        }
        else if(!left.isEnabled()){
            leftCode = e.getKeyCode();
            left.setText(KeyEvent.getKeyText(leftCode));
            left.setEnabled(true);
        }
        else if(!up.isEnabled()){
            upCode = e.getKeyCode();
            up.setText(KeyEvent.getKeyText(upCode));
            up.setEnabled(true);
        }
        else if(!down.isEnabled()){
            downCode = e.getKeyCode();
            down.setText(KeyEvent.getKeyText(downCode));
            down.setEnabled(true);
        }
        else if(!sp1.isEnabled()){
            sp1Code = e.getKeyCode();
            sp1.setText(KeyEvent.getKeyText(sp1Code));
            sp1.setEnabled(true);
        }
        else if(!sp2.isEnabled()){
            sp2Code = e.getKeyCode();
            sp2.setText(KeyEvent.getKeyText(sp2Code));
            sp2.setEnabled(true);
        }
        else if(!attack.isEnabled()){
            attackCode = e.getKeyCode();
            attack.setText(KeyEvent.getKeyText(attackCode));
            attack.setEnabled(true);
        }
    }
    
    public void keyTyped(KeyEvent e){
        
    }
    
    public void keyReleased(KeyEvent e){
        
    }
    
    private void enableAllButtons(){
        right.setEnabled(true);
        left.setEnabled(true);
        up.setEnabled(true);
        down.setEnabled(true);
        sp1.setEnabled(true);
        sp2.setEnabled(true);
        attack.setEnabled(true);
    }
    
    public  void saveControlls(){
        try{
            FileOutputStream output=new FileOutputStream("einstellungen.opt");
            DataOutputStream dataout=new DataOutputStream(output);           
            try{
                dataout.writeInt(leftCode);
                dataout.writeInt(rightCode);
                dataout.writeInt(upCode);
                dataout.writeInt(downCode);
                dataout.writeInt(sp1Code);
                dataout.writeInt(sp2Code);
                dataout.writeInt(attackCode);
            }catch(IOException e){e.printStackTrace();}
            try{
                output.close();
            }catch(IOException e1){}
        }catch(IOException e){e.printStackTrace();}
    }
    
    public  void readControlls(){
        try{
            FileInputStream iostream=new FileInputStream("einstellungen.opt");
            DataInputStream diostream=new DataInputStream(iostream);
            try{
                leftCode=diostream.readInt();
                rightCode = diostream.readInt();
                upCode = diostream.readInt();
                downCode = diostream.readInt();
                sp1Code = diostream.readInt();
                sp2Code = diostream.readInt();
                attackCode = diostream.readInt();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e){}
    }
}