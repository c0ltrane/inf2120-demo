package DOM;

import TDA.ABRNoeud;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 11/30/17.
 */
public class DOMNoeud<E extends Comparable< E > >{
    protected E _tag;
    protected E _valeur;
    protected ArrayList<DOMNoeud> _enfants;

    public DOMNoeud(E elem){
        _tag = elem;
        _enfants = new ArrayList<DOMNoeud>();
    }

    public DOMNoeud( E elem, E valeur) {
        this(elem);
        _valeur = valeur;
    }

    public void inserer(E elem){
        DOMNoeud<E> nouvelEnfant = new DOMNoeud(elem);
        _enfants.add(nouvelEnfant);
    }

    public void inserer(E elem, E valeur){
        DOMNoeud<E> nouvelEnfant = new DOMNoeud(elem, valeur);
        _enfants.add(nouvelEnfant);
    }

    public DOMNoeud<E> chercher(E elem){

        DOMNoeud resultat = null;
        if(_tag.compareTo(elem) == 0){
            resultat = this;
        }
        else {
            for( DOMNoeud enfant : _enfants){
                resultat = enfant.chercher(elem);
                if(resultat != null){
                    break;
                }
            }
        }

        return resultat;
    }
}
