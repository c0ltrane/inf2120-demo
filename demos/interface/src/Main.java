/**
 * Created by thomas on 10/1/17.
 */

import java.util.ArrayList;
import nombre.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<NDouble> nDoubles = new ArrayList<NDouble>(){{
            add(new NDouble(1.0));
            add(new NDouble(2.0));
            add(new NDouble(3.0));
            add(new NDouble(4.0));
            add(new NDouble(5.0));
            add(new NDouble(6.0));
            add(new NDouble(7.0));
            add(new NDouble(8.0));
        }};
        System.out.println("Somme des nDoubles: " + somme(nDoubles));
        System.out.println("Somme avancee des nDoubles: " + sommeAvancee(nDoubles));

        ArrayList<Fraction> fractions = new ArrayList<Fraction>(){{
            add(new Fraction(1, 1));
            add(new Fraction(1,2));
            add(new Fraction(1,4));
            add(new Fraction(1,8));
            add(new Fraction(1,16));
            add(new Fraction(1,32));
            add(new Fraction(1,64));
            add(new Fraction(1,128));
        }};
        System.out.println("Somme des fractions: " + somme(fractions) + " (ou a peu pres 2)");
        System.out.println("Somme avancee des fractions: " + sommeAvancee(fractions) + " (ou a peu pres 2)");

    }

    public static < N extends Nombre<N> > Nombre< N > somme( ArrayList< N > tableau ){
        Nombre<N> resultat = null;
        if (!tableau.isEmpty()) {
            resultat = tableau.get(0).getElementNeutreAddition();
            for(N nombre: tableau){
                resultat = resultat.add(nombre);
            }
        }
        return resultat;
    }

    public static < N extends Nombre< N > > Nombre< N > sommeAvancee( ArrayList< N > tableau ){
        N elementNeutre = tableau.get(0).getElementNeutreAddition();
        return !tableau.isEmpty() ?  tableau.stream().reduce(elementNeutre, (a,b)->a.add(b)) : null;
    }
}
