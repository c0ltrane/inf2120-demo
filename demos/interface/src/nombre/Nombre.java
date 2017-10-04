package nombre;

/**
 * Created by thomas on 10/1/17.
 */
public interface Nombre <N> {
    N add (N x);
    N sub (N x);
    N mul (N x);
    N div (N x);
    N getElementNeutreAddition();
    N getElementNeutreMult();
}
