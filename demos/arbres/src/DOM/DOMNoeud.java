package DOM;

import TDA.ABRNoeud;

/**
 * Created by thomas on 11/30/17.
 */
public class DOMNoeud<E extends Comparable<E> > extends ABRNoeud<E> {

    public DOMNoeud( E noeud) {
        super(noeud);
    }

    public void inserer(E elem, char sens){
       if(sens == 'g') {
          _gauche = new DOMNoeud<E>(elem);
       }
       else if (sens == 'd'){
          _droite = new DOMNoeud<E>(elem);
       }
    }

    public DOMNoeud<E> chercher(E elem){
        return (DOMNoeud<E>) super.chercher(elem);
    }
}
