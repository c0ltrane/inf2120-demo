package heritage;

/**
 * Created by thomas on 9/11/17.
 */
public class NonTaxable extends Bien {

    public NonTaxable(double prixEtalage) {
        super(prixEtalage);
    }

    @Override
    public double prix(){
        return getPrixEtalage();
    }
}
