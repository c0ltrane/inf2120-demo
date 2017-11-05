/**
 * Created by af491150 on 2017-10-26.
 */

import java.util.Iterator;

/**
 * Created by thomas on 10/11/17.
 */
public class File<T> implements Iterable<T> {

    public Noeud<T> debut;
    private Noeud<T> fin;
    private int nbElement;

    @Override
    public Iterator<T> iterator(){
        return new FileIterator(this);
    }

    public File(){
        debut = null;
        fin = null;
        nbElement = 0;
    }

    public int taille(){
        return nbElement;
    }

    public boolean estVide(){
        return nbElement == 0;
    }

    public T tete() throws FileVide{
        if(estVide()){
            throw new FileVide();
        }
        return debut.element;
    }

    public void enfiler (T element){
        Noeud<T> nouveauNoeud = new Noeud<>(element);

        if(fin != null){
            fin.suivant = nouveauNoeud;
        }

        fin = nouveauNoeud;

        if(estVide()){
            debut = nouveauNoeud;
        }

        nbElement++;
    }

    public void defiler() throws FileVide{
        if(estVide()){
            throw new FileVide();
        }

        if(nbElement == 1){
            fin = null;
        }

        debut = debut.suivant;
        nbElement--;
    }
}
