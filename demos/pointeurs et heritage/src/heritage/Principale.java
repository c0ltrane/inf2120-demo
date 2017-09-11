package heritage;


/**
 * Created by thomas on 9/11/17.
 */
public class Principale {
    public static void main(String[] args) {

        Bien[] biens = new Bien[3];

        Legume carotte = new Legume(0.5);
        Meuble chaise = new Meuble(5.99);
        Livre javaPourLesNuls = new Livre(15.89);

        biens[0] = carotte;
        biens[1] = chaise;
        biens[2] = javaPourLesNuls;

        System.out.println("Facture =  " + calculerFacture(biens));

    }

    private static double calculerFacture(Bien[] biens){
        double totalFacture = 0.0;

        for(Bien bien : biens){
            totalFacture += bien.prix();
        }

        return totalFacture;
    }
}
