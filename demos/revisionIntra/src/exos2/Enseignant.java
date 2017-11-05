package exos2;

/**
 * Created by thomas on 10/23/17.
 */
public class Enseignant extends Personne{
    private String matricule;
    public Enseignant ( String nom, String matricule ) {
        super ( nom );
        this.matricule = matricule;
    }
    public String ident () {
        return "un enseignant";
    }

    public String getMatricule () {
        return matricule;
    }
}
