package DOM;

import TDA.ABRNoeud;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 11/30/17.
 */
public class DOMNoeud<E extends Comparable<E> >{
    protected E _tag;
    protected List<DOMNoeud> _enfants;

    public DOMNoeud( E elem) {
        _tag = elem;
        _enfants = new ArrayList<DOMNoeud>();
    }

    public void inserer(E elem){
        DOMNoeud<E> nouvelEnfant = new DOMNoeud(elem);
        _enfants.add(nouvelEnfant);
    }

    public DOMNoeud<E> chercher(E elem){

        DOMNoeud resultat = null;
        for( DOMNoeud enfant : _enfants){
            if(enfant._tag.equals(elem)){
               resultat = enfant;
               break;
            }
        }
        return resultat;
    }
}
