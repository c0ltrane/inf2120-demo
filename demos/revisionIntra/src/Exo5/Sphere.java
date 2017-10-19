package Exo5;

/**
 * Created by thomas on 10/19/17.
 */
public class Sphere extends Object3D implements Surface{
    private double rayon;

    public Sphere(double rayon) {
        this.rayon = rayon;
    }

    public double aire(){
        return 4 * Math.PI *rayon;
    }

}
