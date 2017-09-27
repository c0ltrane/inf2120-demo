package typesgeneriques;

/**
 * Created by thomas on 9/27/17.
 */
public class QQChose <T> extends PeutEtre<T> {
    private T _valeur;
    public QQChose( T a_valeur ){
        _valeur = a_valeur;
    }
    public boolean estQQChose(){
        return true;
    }
    public boolean estRien(){
        return false;
    }
    public T qQChose() throws ARien{
        return _valeur;
    }
}
