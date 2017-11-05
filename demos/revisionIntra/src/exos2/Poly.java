package exos2;

/**
 * Created by thomas on 10/23/17.
 */
public class Poly {
    public static void main(String[] args) {
        Personne toto = new Personne ( "x" );
        Personne totoEt = new Etudiant ( "y", "ZZ" );
        Enseignant totoEns = new Enseignant ( "z", "A" );
        Personne totoP = new Prof ( "w", "AA", "mth" );
        // Partie (b)
        Personne machin = new Prof ( "m", "X13", "math" );
//        System.out.println ( machin.getMatricule() );
        Personne tintin = new Etudiant ( "tintin", "R24" );
        System.out.println ( ((Enseignant)tintin).getMatricule() );
        Prof tournesol = new Prof ( "tryphon", "H2O", "?" );
        System.out.println ( tournesol.getMatricule() + tournesol );
    }
}
