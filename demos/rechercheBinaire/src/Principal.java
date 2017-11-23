import java.util.Iterator;

/**
 * Created by thomas on 11/23/17.
 */
public class Principal {
    public static void main(String[] args) {
        final int TAILLE = 64;
        Fraction [] tab = new Fraction[ TAILLE ];

        Iterator< Fraction > it =
                new Fraction( 1, 2 ).sequence(
                        new Fraction( 1, 16 ), TAILLE ).iterator();


        int i = 0;
        while( it.hasNext() ) {
            tab[ i ] = it.next();
            ++ i;
        }

        for( int j = 0; j < TAILLE; j++){
           System.out.println(tab[j]);
        }

        try {
            int indice =
                    AlgoFouille.FouilleBinaire( tab,
                            new Fraction( 21, 16 ) );
            System.out.println(
                    "La position de l'element est : " + indice );
        } catch( ElementNonPresent e ) {
            System.out.println(
                    "L'element n'a pas ete trouve." );
        }
        try {
            int indice =
                    AlgoFouille.FouilleBinaireR( tab,
                            new Fraction( 21, 17 ), 0, TAILLE-1 );
            System.out.println(
                    "La position de l'element est : " + indice );
        } catch( ElementNonPresent e ) {
            System.out.println(
                    "L'element n'a pas ete trouve." );
        }
    }
}
