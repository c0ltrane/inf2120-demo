package heritage;

/**
 * Created by thomas on 9/11/17.
 */
public class TaxeDouble extends Bien {

    public TaxeDouble(double prixEtalage) {
        super(prixEtalage);
    }

    @Override
    public double prix(){
        return getPrixEtalage() * (1 + TAXE1) * (1 + TAXE2);
    }
}
