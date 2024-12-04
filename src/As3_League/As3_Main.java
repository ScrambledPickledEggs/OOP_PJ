package As3_League;

import Examples.Ex3_Client;

import java.io.*;
import java.util.ArrayList;

public class As3_Main {

    public static void run(){

        ArrayList <As3_Team> allTeams = new ArrayList<>();

        loadFile("data/SnowfallSurf.csv", allTeams);


        System.out.println("\n\n\nWelcome to the snowfall surfers (also known as avalanche chasers) team database, it holds the information for the ten most popular teams!");

        boolean gus = true;
        while(gus){
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Print all teams\n2. Find highest stat\n3. View proficiency\n4. Sort by casualties\n5. Update stats\n6. Save and Exit");
            String choice = Library.input.nextLine();
            System.out.println();

            if (choice.equals("1")){

                for (int i = 0; i < allTeams.size(); i++) {
                    allTeams.get(i).printMe();

                }

            }//---------------------------------------------------------------------------------------------------------print method
            else if(choice.equals("2")){


                int temp = 0;
                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getGamesWon()>allTeams.get(temp).getGamesWon()){
                        temp = i;
                    }
                }

                int temp2 = 0;
                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getPlayersLost()>allTeams.get(temp2).getPlayersLost()){
                        temp2 = i;
                    }
                }

                int temp3 = 0;
                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getMountainsVisited()>allTeams.get(temp3).getMountainsVisited()){
                        temp3 = i;
                    }
                }

                System.out.println("The team with the most games won is the " + allTeams.get(temp).getName());
                System.out.println("The team with the most players lost is the " + allTeams.get(temp2).getName());
                System.out.println("The team with the most mountains visited is the " + allTeams.get(temp3).getName());

            }//---------------------------------------------------------------------------------------------------------find highest
            else if(choice.equals("3")){

                System.out.println("What proficiency level would you like to see?");
                String answer = Library.input.nextLine();

                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getProficiency().equalsIgnoreCase(answer)){
                        System.out.println("The " + allTeams.get(i).getCity() + " " + allTeams.get(i).getName() + " have a proficiency level of " + answer);
                        System.out.println("They also have raced on " + allTeams.get(i).getMountainsVisited() + " mountains and have lost " + allTeams.get(i).getPlayersLost() + " players.\n");
                    }
                }


            }//---------------------------------------------------------------------------------------------------------sort by proficiency
            else if(choice.equals("6")){
                saveFile("data/ClientDataAfter.csv", allTeams);

                break;
            }
            else {
                System.out.println("obligatory error message");
            }



        }//-------------------------------------------------------------------------------------------------------------while loop


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

    public static void saveFile(String filename, ArrayList <As3_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getCity();
                toSave +="," + tempList.get(i).getProficiency();
                toSave +="," + tempList.get(i).getGamesWon();
                toSave +="," + tempList.get(i).getPlayersLost();
                toSave +="," + tempList.get(i).getMountainsVisited();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile
}
