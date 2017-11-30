/**
 * Created by thomas on 11/30/17.
 */

import java.util.ArrayList;


public class Principal {
    public static void main( String [] argv ) {
        ABRNoeud< Integer > a = new ABRNoeud<>( 16 );

        int [] t = {8, 24, 4, 12, 20, 28, 2, 6, 10, 14, 18, 22, 26, 30, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31 };

        for( Integer x : t ) {
            a.inserer( x );
        }

        // afficher l'arbre de cote :
        StringBuilder sb = new StringBuilder();
        System.out.println( a.pprint( sb, 2 ) );

        // parcours
        ArrayList< Integer > r_prefixe = new ArrayList<>();
        System.out.println( "prefixe : " + a.elements( r_prefixe, ABRNoeud.Parcours.PREFIXE ) );

        ArrayList< Integer > r_infixe = new ArrayList<>();
        System.out.println( "infixe : " + a.elements( r_infixe, ABRNoeud.Parcours.INFIXE ) );

        ArrayList< Integer > r_suffixe = new ArrayList<>();
        System.out.println( "suffixe : " + a.elements( r_suffixe, ABRNoeud.Parcours.SUFFIXE ) );

        // map : f(x) = 2x + 1
        ABRNoeud< Integer > a2 = a.map2( (x) -> 2 * x + 1 );
        StringBuilder sb2 = new StringBuilder();
        System.out.println( a2.pprint( sb2, 4 ) );
    }
}
