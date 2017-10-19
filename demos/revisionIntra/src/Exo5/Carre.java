package Exo5;

/**
 * Created by thomas on 10/19/17.
 */
public class Carre extends Object2D implements Surface {
    private double cote;

    public Carre(double cote) {
        this.cote = cote;
    }

    public double aire(){
       return cote*cote;
    }
}
