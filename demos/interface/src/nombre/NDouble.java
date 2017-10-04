package nombre;

/**
 * Created by thomas on 10/1/17.
 */
public class NDouble implements Nombre<NDouble> {

    private double _valeur;
    public NDouble(double _valeur) {
        this._valeur = _valeur;
    }

    public NDouble getElementNeutreAddition(){
        return new NDouble(0);
    }

    public NDouble getElementNeutreMult(){
        return new NDouble(1);
    }

    public double get_valeur() {
        return _valeur;
    }

    public void set_valeur(double _valeur) {
        this._valeur = _valeur;
    }

    public NDouble add(NDouble x){
        return new NDouble(_valeur + x.get_valeur());
    }
    public NDouble sub(NDouble x){
        return new NDouble(_valeur - x.get_valeur());
    }
    public NDouble mul(NDouble x){
        return new NDouble(_valeur * x.get_valeur());
    }
    public NDouble div(NDouble x){
        NDouble resultat = null;
        if(x.get_valeur() != 0)
            resultat = new NDouble(_valeur / x.get_valeur());
        return resultat;
    }

    @Override
    public String toString() {
        return String.valueOf(_valeur);
    }
}
