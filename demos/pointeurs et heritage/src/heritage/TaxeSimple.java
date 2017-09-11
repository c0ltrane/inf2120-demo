package heritage;

/**
 * Created by thomas on 9/11/17.
 */
public class TaxeSimple extends Bien {
    public TaxeSimple(double prixEtalage) {
        super(prixEtalage);
    }

    public double prix(){
        return getPrixEtalage() * (1 + TAXE1);
    }
}
