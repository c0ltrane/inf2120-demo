/**
 * Created by thomas on 9/16/17.
 */
public class CylindreDroit extends Forme3D {

    private Forme2D base;
    private double hauteur;

    CylindreDroit(Forme2D base, double hauteur){
        setBase(base);
        setHauteur(hauteur);
    }

    public Forme2D getBase() {
        return base;
    }

    public void setBase(Forme2D base) {
        if(base != null)
            this.base = base;
        else
            this.base = new Cercle(1.0);
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        if(hauteur > 0)
            this.hauteur = hauteur;
        else
            this.hauteur = 1.0;
    }

    @Override
    public double volume(){
        return base.aire() * hauteur;
    }

    @Override
    public String toString() {
        return "CylindreDroit{" +
                "base=" + base +
                ", hauteur=" + hauteur +
                '}';
    }
}
