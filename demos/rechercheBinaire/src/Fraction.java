
import java.util.stream.Stream;

public class Fraction implements Comparable< Fraction > {
    private int num = 0;
    private int den = 0;

    public Fraction( int num, int den ) {
        this.num = num;
        this.den = den;

        reduit();
    }

    private static int pgcd( int a, int b ) {
        while( b != 0) {
            int temp = a % b;

            a = b;
            b = temp;
        }
        return a;
    }

    private static int ppcm( int a, int b ) {
        int pg = pgcd( a, b );

        return ( a / pg ) * b;
    }

    private void reduit() {
        int pg = pgcd( num, den );

        num /= pg;
        den /= pg;
    }

    public Fraction add( Fraction f ) {
        return new Fraction( num * f.den + f.num * den, den * f.den );
    }

    public Stream< Fraction > sequence( Fraction increment, int n ) {
        return Stream.iterate( this, ( Fraction f ) -> f.add( increment ) ).limit( n );
    }

    @Override
    public int compareTo( Fraction f ) {
        return ( num * f.den ) - ( f.num * den );
    }

    @Override
    public boolean equals( Object obj ) {
        boolean resultat = false;

        if( obj instanceof Fraction ) {
            Fraction f = (Fraction) obj;
            resultat = compareTo( f ) == 0;
        }

        return resultat;
    }

    @Override
    public String toString() {
        return num + " / " + den;
    }
}
