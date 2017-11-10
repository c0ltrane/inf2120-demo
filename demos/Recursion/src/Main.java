/**
 * Created by thomas on 11/2/17.
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(additionner2(-3,-2));
//        System.out.println(additionner2(10,3));
        System.out.println(additionnerIter(3,2));

        System.out.println(additionnerIter(3,-2));
        System.out.println(additionnerIter(-3,-2));
//        System.out.println(pgcdRec1(9,3));
//        System.out.println(pgcdRec2(9,3));
//        System.out.println(pgcdIter(9,3));
//        System.out.println(dec2bin(4));
//        System.out.println(dec2binIter(1024));
    }

    public static int additionner2 ( int a, int b ) {
        int resultat;
        if ( a == 0 ) {

        } else if ( b == 0 ) {
            resultat = a;
        } else if ( a < b ) {
            resultat = additionner2 ( b, a );
        }
        else if(b < 0){
            resultat = -1 + additionner2 (a, b + 1);
        }
        else { // a >= b
            resultat = 1 + additionner2 ( a, b - 1 );
        }
        return resultat;
    }

    public static int additionner1( int n, int m  ) {
        int resultat = n;

        if( 0 != m ){
            resultat = additionner1( n + 1, m - 1 );
        }
        return resultat;
    }

    public static int additionnerIter( int n, int m  ) {
        if(m <0){
            int temp = n;
            n = m;
            m = temp;
        }
        while( 0 != m ) {
            ++ n;
            -- m;
        }
        return n;
    }

    public static int pgcdRec1 ( int a, int b ) {
        int resultat;
        if ( a == b ) {
            resultat = a;
        } else if ( a < b ) {
            resultat = pgcdRec1 ( b - a, a );
        } else {
            resultat = pgcdRec1 ( a - b, b );
        }
        return resultat;
    }

    public static int pgcdRec2( int n, int m ) {
        int resultat = n;

        if( 0 != m ) {
            resultat = pgcdRec2( m, n % m );
        }
        return resultat;
    }

    public static int pgcdIter( int n, int m ) {
        while( 0 != m ) {
            int temp = n;
            n = m;
            m = temp % m;
        }
        return n;
    }

    public static String dec2bin( int n ) {
        return 0 == n ? "0" : dec2bin_rec( n );
    }

    public static String dec2bin_rec( int n ) {
        String resultat = "";

        if( 0 != n ) {
            resultat = dec2bin_rec( n / 2 ) + ( n % 2 );
        }
        return resultat;
    }

    public static String dec2binItr( int n ) {
        String resultat = 0 == n ? "0" : "";

        while( 0 != n ) {
            resultat = ( n % 2 ) + resultat;
            n = n / 2;
        }
        return resultat;
    }

}
