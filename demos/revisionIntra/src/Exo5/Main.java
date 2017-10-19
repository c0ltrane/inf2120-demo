package Exo5;

/**
 * Created by thomas on 10/19/17.
 */
public class Main {
    public static void main(String[] args) {
        Carre carre = new Carre(5.0);
        Sphere sphere = new Sphere(30.0);
        FormeImpossible formeImpossible = new FormeImpossible();

        double aireCarre = Calcule.aire(carre);
        double aireSphere = Calcule.aire(sphere);

        // la ligne suivante ne compile pas !
        // formeImpossible nest pas de type Surface et ne peut pas etre envoyer en parametre a la methode aire de Calcule

        //double aireFormeImpossible = Calcule.aire(formeImpossible);
    }
}
