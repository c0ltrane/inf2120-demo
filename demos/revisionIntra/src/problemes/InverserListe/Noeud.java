package problemes.InverserListe;

/**
 * Created by thomas on 10/19/17.
 */
public class Noeud<T> {
    public T valeur;
    public Noeud<T> suivant;

    public Noeud(T valeur) {
        this.valeur = valeur;
        suivant = null;
    }
}
