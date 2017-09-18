/**
 * Created by thomas on 9/16/17.
 */
public class Rectangle extends Forme2D {

    private double hauteur;
    private double largeur;

    public Rectangle(double hauteur, double largeur){
        setHauteur(hauteur);
        setLargeur(largeur);
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

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        if(largeur > 0)
            this.largeur = largeur;
        else
            this.largeur = 1.0;
    }

    @Override
    public double aire(){
        return this.hauteur * this.largeur;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "hauteur=" + hauteur +
                ", largeur=" + largeur +
                '}';
    }
}
