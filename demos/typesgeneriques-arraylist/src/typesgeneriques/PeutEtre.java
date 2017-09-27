package typesgeneriques;

/**
 * Created by thomas on 9/27/17.
 */
public abstract class PeutEtre<T> {
    public abstract boolean estQQChose();
    public abstract boolean estRien();
    public abstract T qQChose() throws ARien;
}
