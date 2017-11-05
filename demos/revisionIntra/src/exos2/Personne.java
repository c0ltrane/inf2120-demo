package exos2;

/**
 * Created by thomas on 10/23/17.
 */
public class Personne {
    private String nom;
    public Personne ( String nom ) {
        this.nom = nom;
        System.out.println ( "Je suis " + nom + ", " + ident());
    }
    public String ident () {
        return "une personne.";
    }

    public String toString() {
        return "le nom est " + nom;
    }
}
