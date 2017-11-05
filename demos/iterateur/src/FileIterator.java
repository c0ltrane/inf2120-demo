/**
 * Created by af491150 on 2017-10-26.
 */
import java.util.Iterator;

public class FileIterator<E> implements Iterator<E> {

    Noeud<E> courant;

    FileIterator(File <E> file){
        courant = file.debut;
    }

    @Override
    public boolean hasNext(){
        return courant != null;
    }

    @Override
    public E next(){
        E temp = courant.element;
        courant = courant.suivant;
        return temp;
    }
}
