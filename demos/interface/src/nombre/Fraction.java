package nombre;

/**
 * Created by thomas on 10/1/17.
 */
public class Fraction implements Nombre<Fraction> {

    private int _numerateur;
    private int _denominateur;

    public Fraction(int _numerateur, int _denomianateur) {
        set_denominateur(_denomianateur);
        set_numerateur(_numerateur);
    }

    public Fraction getElementNeutre(){
        return new Fraction(0,1);
    }

    public Fraction add(Fraction x){
        return new Fraction(_numerateur*x.get_denominateur() + x.get_numerateur()*_denominateur, _denominateur*x.get_denominateur());
    }

    public Fraction sub(Fraction x){
        return new Fraction(_numerateur*x.get_denominateur() - x.get_numerateur()*_denominateur, _denominateur*x.get_denominateur());
    }

    public Fraction mul(Fraction x){
        return new Fraction(_numerateur*x.get_numerateur(), _denominateur*x.get_denominateur());
    }

    public Fraction div(Fraction x){
        return new Fraction(_numerateur*x.get_denominateur(), _denominateur*x.get_numerateur());
    }

    public int get_numerateur() {
        return _numerateur;
    }

    public void set_numerateur(int _numerateur) {
        this._numerateur = _numerateur;
    }

    public int get_denominateur() {
        return _denominateur;
    }

    public void set_denominateur(int _denominateur) {
        if(_denominateur != 0)
            this._denominateur = _denominateur;
        else
            this._denominateur = 1;
    }

    @Override
    public String toString() {
        return String.valueOf(_numerateur) + "/" + String.valueOf(_denominateur);
    }
}
