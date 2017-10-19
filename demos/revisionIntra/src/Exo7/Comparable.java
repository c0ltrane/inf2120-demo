package Exo7;

/**
 * Created by thomas on 10/19/17.
 */
public interface Comparable {
    public enum Ordre { PLUS_PETIT, EGAL, PLUS_GRAND }
    Ordre comparer( Comparable v2 );
}
