package As3_League;

import Examples.Ex3_Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class As3_Main {

    public static void run(){

        ArrayList <As3_Team> allTeams = new ArrayList<>();

        loadFile("data/SnowfallSurf.csv", allTeams);


        for (int i = 0; i < allTeams.size(); i++) {
            System.out.println(allTeams.get(i));
        }


    }



    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                list.add( new As3_Team(  tempArray[0],tempArray[1], (tempArray[2]), Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]),Integer.parseInt(tempArray[5])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile
}
