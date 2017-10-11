/**
 * Created by thomas on 10/11/17.
 */
public interface IFile<T> {
    int taille();

    boolean estVide();

    T tete() throws FileVide;

    void enfiler (T element);

    void defiler() throws FileVide;
}
