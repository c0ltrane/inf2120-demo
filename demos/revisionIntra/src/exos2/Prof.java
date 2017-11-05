package exos2;

/**
 * Created by thomas on 10/23/17.
 */
public class Prof extends Enseignant {
    private String departement;
    public Prof ( String nom, String mat, String dept ) {
        super ( nom, mat );
        this.departement = dept;
    }
    public String ident () {
        return "un prof.";
    }
}
