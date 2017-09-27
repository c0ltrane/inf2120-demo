package typesgeneriques;

/**
 * Created by thomas on 9/27/17.
 */
public class Rien <T> extends PeutEtre<T> {
    public Rien(){}
    public boolean estQQChose(){
        return false;
    }
    public boolean estRien(){
        return true;
    }
    public T qQChose() throws ARien{
        throw new ARien();
    }
}
