package bibliotheque;

/**
 * Created by thomas on 11/8/17.
 */
public class Livre {
    private String titre;
    private String isbm;
    private double prix;

    public Livre( String titre, String isbm, double prix ) {
        this.titre = titre;
        this.isbm = isbm;
        this.prix = prix;
    }

    @Override
    public boolean equals( Object obj ) {
        boolean resultat = false;

        if( obj instanceof Livre ) {
            Livre temp = (Livre) obj;

            resultat = temp.isbm == isbm;
        }

        return resultat;
    }

    public String getTitre() {
        return titre;
    }

    public String getIsbm() {
        return isbm;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix( double nouveauPrix ) {
        prix = nouveauPrix;
    }
}
