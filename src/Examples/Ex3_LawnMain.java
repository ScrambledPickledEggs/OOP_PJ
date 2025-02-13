package Examples;


import java.util.ArrayList;
import java.io.*;

public class Ex3_LawnMain {

    public static void run(){

        ArrayList <Ex3_Client> allClients = new ArrayList<>();

        loadFile("data/ClientDataAfter.csv", allClients);
        allClients.add(new Ex3_Client("McDavid", "100 Maple Drive", 1001, false));
        allClients.add(new Ex3_Client("Draisaitl", "102 Maple Drive", 1000, true));
        allClients.add(new Ex3_Client("Nugent", "56 Batcave", 500, false));
        allClients.add(new Ex3_Client("Skinner", "57 Batcave", 300, true));
        allClients.add(new Ex3_Client("Janmark", "102 Maple drive", 1000, false));

        for (int i = 0; i < allClients.size(); i++) {
            allClients.get(i).mowLawn();
        }
        System.out.println();

        for (Ex3_Client clientTemp  :  allClients) {
            System.out.println(clientTemp);
        }

        System.out.println("Welcome to Moe's Mowing");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print all Clients");
            System.out.println("2.  Mow all lawns");
            System.out.println("3.  Receive Payment");
            System.out.println("4.  Add new client");
            System.out.println("5.  Delinquent Payments");
            System.out.println("6.  Save and Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {

                for (int i = 0; i < allClients.size(); i++) {
                    System.out.println(allClients.get(i));

                }

            } else if (choice == 2) {
                for (int i = 0; i < allClients.size(); i++) {
                    allClients.get(i).mowLawn();

                }
            } else if (choice == 3) {
                System.out.println("Who is paying?");
                String name = Library.input.nextLine();
                System.out.println("How much?");
                double amount = Library.input.nextDouble();
                Library.input.nextLine();

                int foundClient = searchByName(allClients, name);
                allClients.get(foundClient).processPayment(amount);


            } else if (choice == 4) {

            } else if (choice == 5) {

                for (Ex3_Client clientTemp: allClients){
                    clientTemp.delinquent();
                }
            } else {
                saveFile("data/ClientDataAfter.csv", allClients);

                break;
            }
        } // while
        System.out.println("There is no use moanin as there is no mow like Moe's mowin.  \nGood bye.");


    }

    public static int searchByName( ArrayList<Ex3_Client> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }

    public static void loadFile(String filename, ArrayList<Ex3_Client> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                list.add( new Ex3_Client(  tempArray[0],tempArray[1], Integer.parseInt(tempArray[2]),Boolean.parseBoolean(tempArray[3]), Double.parseDouble(tempArray[4])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

    public static void saveFile(String filename, ArrayList <Ex3_Client> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getAddress();
                toSave += "," + tempList.get(i).getLawnSize();
                toSave +="," + tempList.get(i).getHasDog();
                toSave +="," + tempList.get(i).getOutstandingFees();

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
