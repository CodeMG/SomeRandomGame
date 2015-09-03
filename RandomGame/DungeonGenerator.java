import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DungeonGenerator{
    private Background background;
    private Obstacle[][] gridObstacles;
    private Foreground[][] gridForeground;
    private ArrayList<Unit> gridUnits;
    private ArrayList<Room> rooms;
    private Scene scene;
    public DungeonGenerator(int width,int height,int amountOfRooms,int sizeOfRooms,int type,Scene scene){
        gridObstacles = new Obstacle[width][height];
        gridForeground = new Foreground[width][height];
        gridUnits = new ArrayList<Unit>();
        rooms = new ArrayList<Room>();
        this.scene = scene;
        if(type == 1){
            generateForest(amountOfRooms,sizeOfRooms);
            background = new Background(scene,Pictures.getBackgroundForest());
        }
    }

    public Obstacle[][] getGridObstacles(){
        return gridObstacles;
    }

    public Foreground[][] getGridForeground(){
        return gridForeground;
    }

    public ArrayList<Unit> getGridUnits(){
        return gridUnits;
    }

    public Background getBackground(){
        return background;
    }
    
    public void generateForest(int amountOfRooms,int sizeOfRooms){

        for(int i = 0; i < gridForeground.length;i++){
            for(int j = 0; j < gridForeground[i].length;j++){
                gridForeground[i][j] = new Foreground(i,j,Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),scene,Pictures.getSprite('F',13));
            }
        }
        
        for(int i = 0; i < gridObstacles.length;i++){
            for(int j = 0; j < gridObstacles[i].length;j++){
                gridObstacles[i][j] = new Obstacle(i,j,Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),scene,Pictures.getSprite('O',0));
            }
        }
        
        for(int i  = 0; i < amountOfRooms;i++){
            int width = (int)((Math.random()*(gridForeground.length/sizeOfRooms))+(gridForeground.length/sizeOfRooms));
            int height = (int)((Math.random()*(gridForeground[0].length/sizeOfRooms)+(gridForeground[0].length/sizeOfRooms)));
            int x = (int)(Math.random()*(gridForeground.length-width));
            int y = (int)(Math.random() * (gridForeground[0].length-height));
            Room room =  new Room(x,y,width,height);
            boolean collides = false;
            //System.out.println("X: " + room.getX() + " Y: " + room.getY() + " Width: " + room.getWidth() + " Height: " + room.getHeight());
            if(rooms.size() == 0){
                rooms.add(room);
            }
            else{
                for(int j = 0; j < rooms.size();j++){
                    if(rooms.get(j) != room){
                        if(!rooms.get(j).intersects(x,y,width,height)){
                        }
                        else{
                            i-=1;
                            collides = true;
                            break;
                        }
                    }
                }
            }
            if(!collides){
                rooms.add(room);
            }
        }
        for(int i = 0; i < rooms.size();i++){
            addRoomToGrid(rooms.get(i));
        }
        for(int i = 0; i < rooms.size()-1;i++){
            createPath(rooms.get(i),rooms.get(i+1));
        }
        int roomnumber = (int)(Math.random()*(amountOfRooms-1));
        gridUnits.add(new Player(rooms.get(roomnumber).getCenterX()*Gamepanel.getGRIDSIZE(),rooms.get(roomnumber).getCenterY()*Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),scene));
        System.out.println(rooms.get(roomnumber).getCenterX());
        for(int i = 0; i < gridObstacles.length;i++){
            for(int j = 0; j < gridObstacles[i].length;j++){
                if(i == 0 || j == 0 || i == gridObstacles.length-1 || j == gridObstacles[i].length-1){
                    gridObstacles[i][j] = new Obstacle(i,j,Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),scene,Pictures.getSprite('O',0));
                }
            }
        }
    }

    public void addRoomToGrid(Room room){
        for(int i = room.getX(); i <= room.getX()+room.getWidth();i++){
            for(int j = room.getY(); j <= room.getY()+room.getHeight();j++){
                gridObstacles[i][j] = null;
            }
        }
        /*
        for(int i = room.getX(); i <= room.getX()+room.getWidth();i++){
            for(int j = room.getY(); j <= room.getY()+room.getHeight();j++){
                if(i == room.getX() || i == room.getX()+room.getWidth()){
                    gridObstacles[i][j] = new Obstacle(i,j,64,64,scene,Pictures.getSprite('O',0));
                }
                if(j == room.getY() || j == room.getY()+room.getHeight()){
                    gridObstacles[i][j] = new Obstacle(i,j,64,64,scene,Pictures.getSprite('O',0));
                }
            }
        }
        */
    }

    public void createPath(Room room1,Room room2){
        createHPath(room1.getCenterX(),room2.getCenterX(),room1.getCenterY());
       
        createVPath(room1.getCenterY(),room2.getCenterY(),room2.getCenterX());
       
    }

    public void createHPath(int x1,int x2,int y){
        if(x2 > x1){
            for(int i = x1; i <= x2;i++){
                gridObstacles[i][y] = null;
            }
        }
        else if(x2 < x1){
            for (int i = x2; i <= x1;i++){
                gridObstacles[i][y] =null;
            }
        }
    }

    public void createVPath(int y1,int y2,int x){
        if(y2 > y1){
            for(int i = y1; i <= y2;i++){
                gridObstacles[x][i] = null;
            }
        }
        else if(y2 < y1){
            for(int i = y2; i <= y1;i++){
                gridObstacles[x][i] =null;
            }
        }
    }
}
