package As1_Crops;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){
        int counter = 0;

        ArrayList<As1_Crop> allFlora = new ArrayList<>();
        allFlora.add(new As1_Crop("Barley",85,"bushels", 4.25 ));
        allFlora.add(new As1_Crop("Squash", 20000,"pounds", 0.5));
        allFlora.add(new As1_Crop("Blueberries", 6000, "pounds", 4.00));
        allFlora.add(new As1_Crop("Coffee", 900, "pounds", 0.5));
        allFlora.add(new As1_Crop("Belladonna/Deadly Nightshade", 6, "tons", 2000));

        for (int i = 0; i < allFlora.size(); i++) {
            System.out.println(allFlora.get(i));
        }

        boolean gus = true;
        while (gus) {
            int num1 = Library.myRandom(11,600);
            int num2 = Library.myRandom(11,600);
            int num3 = Library.myRandom(11,600);
            int num4 = Library.myRandom(11,600);
            int num5 = Library.myRandom(11,600);

            if((num1+num2+num3+num4+num5) == 1000){
                System.out.println("\nAmount of tries: " + counter + " Acres for each crop: " + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + "\n");
                System.out.println(num1 + num2);
                System.out.println(num1 + num2 + num3);
                System.out.println(num1 + num2 + num3 + num4);
                System.out.println(num1 + num2 + num3 + num4 + num5);
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

        for (int i = 0; i < allFlora.size(); i++) {
            System.out.println(allFlora.get(i));
        }


    }
}
