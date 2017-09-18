/**
 * Created by thomas on 9/16/17.
 */
public class Cercle extends Forme2D{

    private double rayon;

    Cercle(double rayon){
        setRayon(rayon);
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        if(rayon > 0)
            this.rayon = rayon;
        else
            this.rayon = 1.0;
    }

    @Override
    public double aire(){
       return Math.PI * rayon * rayon;
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "rayon=" + rayon +
                '}';
    }
}
