import java.awt.event.*;
import java.io.*;
import java.io.IOException;
public class Controller implements KeyListener{
    private Gamepanel panel;
    private static int left,right,up,down,sp1,sp2,attack;
    public Controller(Gamepanel panel){
        this.panel = panel;
        loadControlls();
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyPressed(KeyEvent e){
        Player player = panel.getPlayer();
        if(Gamepanel.getDrawMode() && Gamepanel.getCalculateMode()){
            if(player != null){
                if(e.getKeyCode() == right){
                    player.moveRight();
                }
                else if(e.getKeyCode() == left){
                    player.moveLeft();
                }
                else if(e.getKeyCode() == up){
                    player.moveUp();
                }
                else if(e.getKeyCode() == down){
                    player.moveDown();
                }
            }
        }
        else if(!Gamepanel.getCalculateMode()){
            if(player != null){
                GUIManager.get().type(e);
            }
        }
    }

    public void keyTyped(KeyEvent e){
    }

    public  void loadControlls(){
        try{
            FileInputStream iostream=new FileInputStream("einstellungen.opt");
            DataInputStream diostream=new DataInputStream(iostream);
            try{
                left=diostream.readInt();
                right = diostream.readInt();
                up = diostream.readInt();
                down = diostream.readInt();
                sp1 = diostream.readInt();
                sp2 = diostream.readInt();
                attack = diostream.readInt();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e){}
    }
    
    public static int getRight(){
        return right;
    }
    
    public static void setRight(int r){
        right = r;
    }
    
     public static int getLeft(){
        return left;
    }
    
    public static void setLeft(int l){
        left = l;
    }
    
    public static int getUp(){
        return up;
    }
    
    public static void setUp(int u){
        up = u;
    }
    
    public static int getDown(){
        return down;
    }
    
    public static void setDown(int d){
        down = d;
    }
    
    public static int getSP1(){
        return sp1;
    }
    
    public static void setSP1(int s){
        sp1 = s;
    }
    
    public static int getSP2(){
        return sp2;
    }
    
    public static void setSP2(int s){
        sp2 = s;
    }
    
    public static int getAttack(){
        return attack;
    }
    
    public static void setAttack(int a){
        attack = a;
    }
    
}