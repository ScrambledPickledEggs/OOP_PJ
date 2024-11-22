package As1_Crops;

import Examples.Ex3_Client;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){
        int counter = 0;

        ArrayList <As1_Crop> allFlora = new ArrayList<>();
        allFlora.add(new As1_Crop("Barley",85,"bushels", 4.25 ));
        allFlora.add(new As1_Crop("Squash", 20000,"pounds", 0.5));
        allFlora.add(new As1_Crop("Blueberries", 6000, "pounds", 4.00));
        allFlora.add(new As1_Crop("Coffee", 900, "pounds", 0.5));
        allFlora.add(new As1_Crop("Belladonna/Deadly Nightshade", 6, "tons", 2000));

        for (int i = 0; i < allFlora.size(); i++) {
//            System.out.println(allFlora.get(i));
        }

        boolean gus = true;
        while (gus) {
            int num1 = Library.myRandom(11,600);
            int num2 = Library.myRandom(11,600);
            int num3 = Library.myRandom(11,600);
            int num4 = Library.myRandom(11,600);
            int num5 = Library.myRandom(11,600);

            if((num1+num2+num3+num4+num5) == 1000){
//                System.out.println("\nAmount of tries: " + counter + " Acres for each crop: " + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + "\n");
                gus = false;
                allFlora.get(0).setAcres(num1);
                allFlora.get(1).setAcres(num2);
                allFlora.get(2).setAcres(num3);
                allFlora.get(3).setAcres(num4);
                allFlora.get(4).setAcres(num5);
            } else {
                counter += 1;
            }
        }//while loop

        System.out.println("Welcome to Hazardous Harvesting");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print farm summary");
            System.out.println("2.  Search and harvest a crop");
            System.out.println("3.  Get total revenue");
            System.out.println("4.  Plant a crop");
            System.out.println("5.  Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {

                for (int i = 0; i < allFlora.size(); i++) {
                    allFlora.get(i).printMe();

                }

            } else if (choice == 2) {
                System.out.println("Whatya looking fer?");
                String answer = Library.input.nextLine();

                int foundIndex = searchByName(allFlora, answer);
                allFlora.get(foundIndex).printMe();
//                for (int i = 0; i < allFlora.size(); i++) {
//                    allFlora.get(i).mowLawn();
//
//                }
            } else if (choice == 3) {
//                System.out.println("Who is paying?");
//                String name = Library.input.nextLine();
//                System.out.println("How much?");
//                double amount = Library.input.nextDouble();
//                Library.input.nextLine();
//
//                int foundClient = searchByName(allFlora, name);
//                allFlora.get(foundClient).processPayment(amount);


            } else if (choice == 4) {

            } else if (choice == 5) {
                break;
            } else {

                System.out.println("Obligatory error message");
            }
        } // while



    }

    public static int searchByName( ArrayList <As1_Crop> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }
}
