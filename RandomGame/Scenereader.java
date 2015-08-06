import java.io.*;

public class SceneReader{

    public SceneReader(){
    }

    public Overworld createScene(String verz){
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
                        level.addForeground(new Foreground(x,y,64,64,level,Pictures.getSprite(read,readZahl)));
                        case 'S':
                        switch(readZahl){

                        }
                        break;
                        case 'E':
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