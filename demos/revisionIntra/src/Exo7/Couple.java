package Exo7;

/**
 * Created by thomas on 10/19/17.
 */
public class Couple < T extends Comparable >{
    private T a1;
    private T a2;
    public Couple( T v1, T v2 ) {
        a1 = v1;
        a2 = v2;
    }
    public Comparable.Ordre comparer(Couple< T > v2){
        Comparable.Ordre r = this.a1.comparer( v2.a1 );
        if( r == Comparable.Ordre.EGAL ) r = this.a2.comparer( v2.a2 );
        return r;
    }
}
