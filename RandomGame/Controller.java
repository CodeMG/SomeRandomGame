import java.awt.event.*;

public class Controller implements KeyListener{
    private Gamepanel panel;
    public Controller(Gamepanel panel){
        this.panel = panel;
    }

    public void keyReleased(KeyEvent e){
        Player player = panel.getPlayer();
        if(player != null){
            if(e.getKeyCode() == KeyEvent.VK_D){

            }
            else if(e.getKeyCode() == KeyEvent.VK_A){
                //player.setLinks(false);
            }
            else if(e.getKeyCode() == KeyEvent.VK_W){
                //player.setOben(false);
            }
            else if(e.getKeyCode() == KeyEvent.VK_S){
                //player.setUnten(false);
            }
        }
    }

    public void keyPressed(KeyEvent e){
        Player player = panel.getPlayer();
        if(Gamepanel.getDrawMode() && Gamepanel.getCalculateMode()){
            if(player != null){
                if(e.getKeyCode() == KeyEvent.VK_D){
                    player.moveRight();
                }
                else if(e.getKeyCode() == KeyEvent.VK_A){
                    player.moveLeft();
                }
                else if(e.getKeyCode() == KeyEvent.VK_W){
                    player.moveUp();
                }
                else if(e.getKeyCode() == KeyEvent.VK_S){
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

}