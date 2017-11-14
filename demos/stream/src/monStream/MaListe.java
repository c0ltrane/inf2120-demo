package monStream;

import java.util.LinkedList;

/**
 * Created by thomas on 11/13/17.
 *
 * MaListe permet d'utiliser les objets MonStream
 */
public class MaListe<U> extends LinkedList<U> implements IStreamable<U>{

    public IMonStream<U> fstream() {
        return new MonStream<>(this);
    }
}
