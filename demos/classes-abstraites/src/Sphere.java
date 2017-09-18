/**
 * Created by thomas on 9/16/17.
 */
public class Sphere extends Forme3D {

    private double rayon;

    public Sphere(double rayon) {
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
    public double volume(){
        return 4/3 * Math.PI * Math.pow(rayon,3);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "rayon=" + rayon +
                '}';
    }
}
