package Examples;

import java.util.ArrayList;
public class Ex3_LawnMain {

    public static void run(){

        ArrayList <Ex3_Client> allClients = new ArrayList<>();

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



    }

}
