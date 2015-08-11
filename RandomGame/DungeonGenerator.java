import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DungeonGenerator{
    private Drawobject[][] grid;
    private ArrayList<Room> rooms;
    public DungeonGenerator(int width,int height,int amountOfRooms,int type){
        grid = new Drawobject[width][height];
        rooms = new ArrayList<Room>();
        if(type == 1){
            generateForest(amountOfRooms);
        }
    }

    public Drawobject[][] getGrid(){
        return grid;
    }

    public void generateForest(int amountOfRooms){
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[i].length;j++){
                grid[i][j] = new Obstacle(i,j,64,64,null);
            }
        }

        System.out.println(grid.length);
        for(int i  = 0; i < amountOfRooms;i++){
            int width = (int)((Math.random()*(grid.length/10))+20);
            int height = (int)((Math.random()*(grid[0].length/10)+20));
            int x = (int)(Math.random()*(grid.length-width));
            int y = (int)(Math.random() * (grid[0].length-height));
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
    }

    public void addRoomToGrid(Room room){
        for(int i = room.getX(); i < room.getX()+room.getWidth();i++){
            for(int j = room.getY(); j < room.getY()+room.getHeight();j++){
                grid[i][j] = new Foreground(i,j,64,64,null,null);
            }
        }
    }

    public void createPath(Room room1,Room room2){
        createHPath(room1.getCenterX(),room2.getCenterX(),room1.getCenterY());
        createVPath(room1.getCenterY(),room2.getCenterY(),room2.getCenterX());
    }

    public void createHPath(int x1,int x2,int y){
        if(x2 > x1){
            for(int i = x1; i < x2;i++){
                grid[i][y] = new Foreground(i,y,64,64,null,null);
            }
        }
        else if(x2 < x1){
            for (int i = x2; i < x1;i++){
                grid[i][y] = new Foreground(i,y,64,64,null,null);
            }
        }
    }

    public void createVPath(int y1,int y2,int x){
        if(y2 > y1){
            for(int i = y1; i < y2;i++){
                grid[x][i] = new Foreground(x,i,64,64,null,null);
            }
        }
        else if(y2 < y1){
            for(int i = y2; i < y1;i++){
                grid[x][i] = new Foreground(x,i,64,64,null,null);
            }
        }
    }
}
