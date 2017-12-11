/**
 * Created by thomas on 12/7/17.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Principal {

    // SELECTION :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri selection.
     * meilleur cas : $\mathcal{O}(n^2)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triSelection( E [] tab ) {
        triSelection( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri selection.
     * meilleur cas : $\mathcal{O}(n^2)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triSelection( E [] tab, int debut, int fin ) {
        for( int i = debut; i < fin; ++ i ) {
            int position = i;
            E minimum = tab[i];

            for( int j = i + 1; j <= fin; ++ j ) {
                if( tab[j].compareTo( minimum ) < 0 ) {
                    position = j;
                    minimum = tab[j];
                }
            }

            tab[position] = tab[i];
            tab[i] = minimum;
        }
    }

    // INSERTION :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri insertion.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triInsertion( E [] tab ) {
        triInsertion( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri insertion.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triInsertion( E [] tab, int debut, int fin ) {
        for( int i = debut + 1; i <= fin; ++ i ) {
            int j = i - 1;
            E temp = tab[i];
            while( j >= debut && tab[j].compareTo(temp) > 0 ) {
                tab[j + 1] = tab[j];
                -- j;
            }
            tab[j + 1] = temp;
        }
    }

    // BULLE :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri bulle.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triBulle( E [] tab ) {
        triBulle( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri bulle.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triBulle( E [] tab, int debut, int fin ) {
        boolean estTrie = false;

        while( ! estTrie ) {
            estTrie = true;
            for( int i = debut; i < fin; ++ i ) {
                if( tab[i].compareTo( tab[i + 1] ) > 0 ) {
                    E temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                    estTrie = false;
                }
            }
            -- fin;
        }
    }

    // RAPIDE :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri rapide.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triRapide( E [] tab ) {
        triRapide( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri rapide.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triRapide( E [] tab, int debut, int fin ) {
        if( debut < fin ) {
            E pivot = tab[ ( debut + fin ) / 2 ];
            int i = debut - 1;
            int j = fin + 1;

            while( i < j ) {
                do -- j; while( tab[j].compareTo( pivot ) > 0 );
                do ++ i; while( tab[i].compareTo( pivot ) < 0 );

                if( i < j ) {
                    E temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
            }

            triRapide( tab, debut, j );
            triRapide( tab, j + 1, fin );
        }
    }



    // PLUS RAPIDE :


    /**
     * Methode statique pour trier un tableau.  Utilise le tri rapide ameliore.
     * Lorsque le tableau devient petit, un tri different est utilise.
     * La taille a laquel un tri different est utilise est indique par la constante
     * BARRIERE.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triPlusRapide( E [] tab, int barriere ) {
        triPlusRapide( tab, 0, tab.length - 1, barriere );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri rapide ameliore.
     * Lorsque le tableau devient petit, un tri different est utilise.
     * La taille a laquel un tri different est utilise est indique par la constante
     * BARRIERE.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triPlusRapide( E [] tab, int debut, int fin, int BARRIERE ) {
        if( debut < fin - BARRIERE ) {
            E pivot = tab[ ( debut + fin ) / 2 ];
            int i = debut - 1;
            int j = fin + 1;

            while( i < j ) {
                do -- j; while( tab[j].compareTo( pivot ) > 0 );
                do ++ i; while( tab[i].compareTo( pivot ) < 0 );

                if( i < j ) {
                    E temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
            }

            triPlusRapide( tab, debut, j, BARRIERE );
            triPlusRapide( tab, j + 1, fin, BARRIERE );
        } else if( debut < fin ) {
            triInsertion( tab, debut, fin );
        }
    }

    // TESTS :

    /**
     * routine effectuant des tests minime sur les algorithmes de trie.
     * Les resultats sont affiches pour une detection manuelle des erreurs.
     */
    public static void miniTest() {
        Integer [] tab1 = { 4, 8, 3, 6, 1, 9, 0, 2, 5, 7 };

        triSelection( tab1 );

        System.out.println( "Selection : " );
        for( Integer x : tab1 ) System.out.print( x + "  " );
        System.out.println( "" );

        Integer [] tab2 = { 4, 8, 3, 6, 1, 9, 0, 2, 5, 7 };

        triInsertion( tab2 );

        System.out.println( "Insertion : " );
        for( Integer x : tab2 ) System.out.print( x + "  " );
        System.out.println( "" );

        Integer [] tab3 = { 4, 8, 3, 6, 1, 9, 0, 2, 5, 7 };

        triBulle( tab3 );

        System.out.println( "Bulle : " );
        for( Integer x : tab3 ) System.out.print( x + "  " );
        System.out.println( "" );

        Integer [] tab4 = { 4, 8, 3, 6, 1, 9, 0, 2, 5, 7 };

        triRapide( tab4 );

        System.out.println( "Rapide : " );
        for( Integer x : tab4 ) System.out.print( x + "  " );
        System.out.println( "" );
    }


    /**
     * Methode de test de charge pour le triPlusRapide.
     * ( test de charge : avec beaucoup d'elements )
     * Cette methode affiche le temps d'execution du tri en nanoseconde.
     * Attention : la precision de cette valeur est garanti jusqu'au milliseconde.
     * La methode va aussi verifier si le tableau resultant est trie.
     * Un message d'erreur est affiche pour chaque case non trie.
     */
    public static void testCharge(int taille) {
        int TAILLE = taille;
        // construire un grand tableau de valeur aleatoire :
        Integer [] tab5 = ( new Random( 0 ).ints( TAILLE ).boxed().toArray( Integer[]::new ) );

        // trier et afficher le temps d'execution.
        Integer[] b = new Integer[] {new Integer(0),new Integer(5),new Integer(10),new Integer(15),new Integer(20),new Integer(25)};
//                                        new Integer(50),new Integer(100),new Integer(200),new Integer(1000),new Integer(10000),new Integer(100000)};
        List<Integer> barrieres = Arrays.asList(b);
        for(Integer barriere : barrieres){
            long tempDebut = System.nanoTime();
            triPlusRapide( tab5, barriere );
            long tempsExecution = System.nanoTime() - tempDebut;
            System.out.println("Pour barriere = " + barriere + " " + ( tempsExecution / 1000000000 ) + " sec " + ( ( tempsExecution / 1000000 ) % 1000 ) + " millis " + ( ( tempsExecution / 1000 ) % 1000 ) + " micros " + ( tempsExecution % 1000 ) + " nanos" );
        }


        // Verifier s'il y a une erreur de trie :
        boolean estTrie = true;
        for( int i = 0; i < tab5.length - 1; ++ i ) {
            if( tab5[i].compareTo( tab5[i + 1] ) > 0 ) {
                estTrie = false;
                System.err.println( "Erreur : valeur a la case " + i + " plus grande que celle a la case " + ( i + 1 ) );
            }
        }
        if( estTrie ) {
            System.out.println( "Le triPlusRapide fonctionne correctement pour ce tableau." );
        }
    }




    // MAIN :

    public static void main(String[] args) {
        miniTest();
        Integer[] t = new Integer[] {new Integer(10000),new Integer(100000),new Integer(1000000),new Integer(10000000)};
//                                        new Integer(1000000),new Integer(10000000)};
        List<Integer> tailles = Arrays.asList(t);
        for(Integer taille : tailles){
            System.out.println("TAILLE: " + taille);
            testCharge(taille);
            System.out.println();
        }
    }
}

