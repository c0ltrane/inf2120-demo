package heritage;

/**
 * Created by thomas on 9/10/17.
 */
public class Bien {

    public static final double TAXE1 = 0.05;
    public static final double TAXE2 = 0.09975;

    private double prixEtalage;

    public Bien(double prixEtalage) {
        setPrixEtalage(prixEtalage);
    }

    public double getPrixEtalage() {
        return prixEtalage;
    }

    public void setPrixEtalage(double prixEtalage) {
        if(prixEtalage >= 0){
            this.prixEtalage = prixEtalage;
        }
    }

    public double prix(){
        return 0.0;
    }

}
