package arraylist;

import java.util.ArrayList;

/**
 * Created by thomas on 9/25/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Double> liste = tweens(1.0,3.0,4);
        liste.forEach(elem -> System.out.println(elem));

        System.out.println();

        ArrayList<Double> liste2 = tweens(2,4,8);
        liste2.forEach(elem -> System.out.println(elem));
    }

    public static ArrayList<Double> tweens( double depart, double fin, int nbrInterval ){

        int taille = nbrInterval + 1;
        ArrayList<Double> liste = new ArrayList<>(taille);
        double delta = (fin - depart) / nbrInterval;

        for(double i = depart; i <= fin; i+= delta){
           liste.add(i);
        }
        return liste;
    }

}
