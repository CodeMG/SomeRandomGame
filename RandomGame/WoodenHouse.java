import java.awt.image.*;
import java.awt.*;
public class WoodenHouse extends House{
    
    public WoodenHouse(double x,double y,double width,double height,Scene scene,BufferedImage image){
        super(x,y,width,height,scene,image);
        //inside = SceneReader.createScene("house.lvl");
        inside = new Dungeon(50,50,3,5);
    }
    
    public void onCollision(Unit unit,int futureX,int futureY){
        Rectangle rect = new Rectangle((int)futureX,(int)futureY,(int)unit.getWidth(),(int)unit.getHeight());
        Rectangle door = new Rectangle((int)(x+48),(int)(y+(48*3)),48,48);
        if(rect.intersects(door)){
            SceneManager.load(inside);
            GUIManager.get().openTextWindow(0,400,800,200,"*Entering a Wormhole*");
        }
    }
    
    
}