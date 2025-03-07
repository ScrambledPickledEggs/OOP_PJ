//Teams assignment 100%
//Players assignment 40% - class created but nothing further

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


            }//---------------------------------------------------------------------------------------------------------filter by proficiency
            else if(choice.equals("4")){

                System.out.println("Sorting by casualties");

                ArrayList <As3_Team> tempArray = new ArrayList<>();

                loadFile("data/SnowfallSurf.csv", tempArray);

                for(int i=0; i<tempArray.size()-1; i++){
                    int lowestIndex = i;
                    for(int j=i+1; j<tempArray.size(); j++){
                        if(tempArray.get(j).getPlayersLost() < tempArray.get(lowestIndex).getPlayersLost()){
                            lowestIndex = j;
                        }
                    }

                    String temp = tempArray.get(i).getName();
                    tempArray.get(i).setName(tempArray.get(lowestIndex).getName());
                    tempArray.get(lowestIndex).setName(temp);

                    String temp2 = tempArray.get(i).getCity();
                    tempArray.get(i).setCity(tempArray.get(lowestIndex).getCity());
                    tempArray.get(lowestIndex).setCity(temp2);

                    String temp3 = tempArray.get(i).getProficiency();
                    tempArray.get(i).setProficiency(tempArray.get(lowestIndex).getProficiency());
                    tempArray.get(lowestIndex).setProficiency(temp3);

                    int temp4 = tempArray.get(i).getGamesWon();
                    tempArray.get(i).setGamesWon(tempArray.get(lowestIndex).getGamesWon());
                    tempArray.get(lowestIndex).setGamesWon(temp4);

                    int temp5 = tempArray.get(i).getPlayersLost();
                    tempArray.get(i).setPlayersLost(tempArray.get(lowestIndex).getPlayersLost());
                    tempArray.get(lowestIndex).setPlayersLost(temp5);

                    int temp6 = tempArray.get(i).getMountainsVisited();
                    tempArray.get(i).setMountainsVisited(tempArray.get(lowestIndex).getMountainsVisited());
                    tempArray.get(lowestIndex).setMountainsVisited(temp6);

                }

                for (int i = 0; i < tempArray.size(); i++) {
                    tempArray.get(i).printMe();
                }




            }//---------------------------------------------------------------------------------------------------------sort by casualties
            else if(choice.equals("5")){
                System.out.println("Enter the info for the most recent avalanche");
                System.out.println("Which team played?");
                String answer = Library.input.nextLine();

                int irrel = -1;
                for (int i = 0; i < allTeams.size(); i++) {
                    if(answer.equalsIgnoreCase(allTeams.get(i).getName())){
                        irrel = i;
                    }
                }
                if(irrel==-1){
                    System.out.println("error");
                }else {

                    allTeams.get(irrel).setMountainsVisited(allTeams.get(irrel).getMountainsVisited() + 1);
                    System.out.println("Ah so the " + allTeams.get(irrel).getName() + " played again? Then they've gone to " + allTeams.get(irrel).getMountainsVisited() + " mountains now.");
                    if (allTeams.get(irrel).getMountainsVisited() > 10) {
                        allTeams.get(irrel).setProficiency("Grey Diamond");
                        if (allTeams.get(irrel).getMountainsVisited() > 20) {
                            allTeams.get(irrel).setProficiency("Black Diamond");
                            if (allTeams.get(irrel).getMountainsVisited() > 30) {
                                allTeams.get(irrel).setProficiency("Double Black Diamond");
                            }
                        }
                    }
                    System.out.println("Their proficiency level is now " + allTeams.get(irrel).getProficiency());

                    System.out.println("Did they win?");
                    String answer2 = Library.input.nextLine();
                    if (answer2.equalsIgnoreCase("yes")) {
                        allTeams.get(irrel).setGamesWon(allTeams.get(irrel).getGamesWon() + 1);
                        System.out.println("Oh joy");
                    } else {
                        System.out.println("Aw sad");
                    }

                    System.out.println("Now be honest, how many people did they lose?");
                    int answer3 = Library.input.nextInt();
                    Library.input.nextLine();
                    allTeams.get(irrel).setPlayersLost(allTeams.get(irrel).getPlayersLost() + answer3);

                    System.out.println("The teams stats now look like this:");
                    allTeams.get(irrel).printMe();

                }
                saveFile("data/SnowfallSurf.csv", allTeams);
            }

            else if(choice.equals("6")){
                saveFile("data/SnowfallSurf.csv", allTeams);

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
