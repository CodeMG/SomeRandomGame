import java.io.*;

public class SceneReader{

    public SceneReader(){
    }

    public static Overworld createScene(String verz){
        Overworld level = new Overworld();

        try {
            FileInputStream iostream = new FileInputStream(verz);
            DataInputStream diostream = new DataInputStream(iostream);
            try {
                int breite = diostream.readInt();
                int hoehe = diostream.readInt();
                int anzahl=diostream.readInt();
                for(int i=0;i<anzahl;i++){
                    char read = diostream.readChar();
                    int readZahl = diostream.readInt();
                    int x = diostream.readInt(),y = diostream.readInt();

                    switch(read){
                        case 'F':
                        level.addForeground(new Foreground((int)(x/Gamepanel.getGRIDSIZE()),(int)(y/Gamepanel.getGRIDSIZE()),Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),level,Pictures.getSprite(read,readZahl)));
                        case 'S':
                        switch(readZahl){
                            case 0:level.addUnit(0,new Player(x,y,Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),(Scene)level));
                            break;
                        }
                        break;
                        case 'O':
                        level.addObstacles(new Obstacle((int)(x/Gamepanel.getGRIDSIZE()),(int)(y/Gamepanel.getGRIDSIZE()),Gamepanel.getGRIDSIZE(),Gamepanel.getGRIDSIZE(),level,Pictures.getSprite(read,readZahl)));
                        break;
                        case 'B':
                        break;
                    }
                }   
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {}
        
        return level;
    }
}