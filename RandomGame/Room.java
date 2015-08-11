import java.awt.*;

public class Room{
    private int x,y,width,height;
    private int centerX,centerY;
    
    public Room(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        centerX = (int)(x+((width*0.5)+1));
        centerY = (int)(y+((height*0.5)+1));
    }
    
    public int getCenterX(){
        return centerX;
    }
    
    public int getCenterY(){
        return centerY;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public boolean intersects(int x,int y,int width,int height){
        Rectangle rect = new Rectangle(x,y,width,height);
        Rectangle rect2 = new Rectangle(this.x,this.y,this.width,this.height);
        return rect.intersects(rect2);
    }
    
}