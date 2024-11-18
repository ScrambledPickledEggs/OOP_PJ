package Examples;

import java.util.ArrayList;

public class EX1_ArrayLists {

    public static void run(){

        ArrayList <String> allNames = new ArrayList();
        //ArrayList <String> allNames = new Arraylist <String> ();
        //List <String> allNames = new ArrayList();
        ArrayList <Double> allDollars = new ArrayList();
        ArrayList <Integer> allFilms = new ArrayList();
        ArrayList <Boolean> allOscars = new ArrayList();

        allNames.add("Samuel L. Jackson"); allDollars.add(14623.8); allOscars.add(false); allFilms.add(66);
        allNames.add("Robert Downey Jr."); allDollars.add(14327.8); allOscars.add(true); allFilms.add(65);
        allNames.add("Zoe Saldana"); allDollars.add(1427.8); allOscars.add(false); allFilms.add(31);


        allNames.add(1, "Scarlett Johansson"); allDollars.add(1, 14527.7); allOscars.add(1, false); allFilms.add(1, 52);

        allNames.set(1,"ScarJo");
        allDollars.set(0,allDollars.get(0) + 65461.2);

        allNames.remove(3);
        allDollars.remove(3);
        allOscars.remove(3);
        allFilms.remove(3);

        for (int i = 0; i < allNames.size(); i++) {
            System.out.println(allNames.get(i) + " " + allDollars.get(i) + " " + allFilms.get(i) + " " + allOscars.get(i));
        }
    }

}
