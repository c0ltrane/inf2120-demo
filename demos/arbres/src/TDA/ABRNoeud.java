package TDA; /**
 * Created by thomas on 11/30/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Chaque TDA.ABRNoeud est a la fois un noeud et un arbre.
 * Ils contiennent un pointeur vers le sous arbre de gauche et un autre
 * vers le sous arbre de droite.
 *
 * @author
 *	//version de Guy Lapalme (GL) de la classe BSTNode de Watt&Browm (Nov 2001)
 *	//version générique en juin 2010 et Novembre 2011
 *	//traduction francais : Bruno Malenfant, Juillet 2016
 *
 * @param < E >
 *   type generique des elements contenus dans l'arbre binaire de recherche.
 *   Ils doivent etre comparable.
 */
public class ABRNoeud< E extends Comparable< E > > {

    // CHAMPS

    /**
     * L'�l�ment contenu dans ce noeud.
     * @invariant
     * element != null
     */
    public E _element;


    /**
     * Le pointeur vers l'arbre de gauche.
     * @invariant
     * $\forall x \in gauche | x < element$
     */
    public ABRNoeud< E > _gauche;


    /**
     * Le pointeur vers l'arbre de droite.
     * @invariant
     * $\forall x \in droite | x > element$
     */
    public ABRNoeud< E > _droite;


    public enum Parcours {
        PREFIXE, INFIXE, SUFFIXE
    }


    // CONSTRUCTEURS

    /**
     * Constructeur vide
     * Aucun arbre vide ne devrait etre constuit, ce constructeur
     * est utilis� pour JUnit.
     */
    public ABRNoeud() {}

    /**
     * Construit un arbre contenant un seul �l�ment � la racine.
     * @param element
     *   L'�l�ment qui sera plac� � la racine.
     */
    public ABRNoeud( E element ) {
        assert element != null;

        this._element = element;
        this._gauche = null;
        this._droite = null;
    }


    // METHODE

    /**
     * Construit une version String de l'arbre pour l'affichage.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append( _element );

        if( _gauche != null || _droite != null ) {
            sb.append( "(" ).append( _gauche == null ? "/" : "" + _gauche ).append( "," ).
                    append( _droite == null ? "/" : "" + _droite ).append( ")" );
        }
        return "" + sb;
    }


    /**
     * Permet d'extraire l'�l�ment noeud courrant.
     * @return
     *   L'�l�ment du noeud.
     */
    public E getElement() {
        return _element;
    }


    /**
     * Calcule le nombre de noeud que contient cet arbre.
     * @return
     *   Le nombre de noeud de l'arbre.
     */
    public int taille() {
        return 1 + ( _gauche == null ? 0 : _gauche.taille() )
                + ( _droite == null ? 0 : _droite.taille() );
    }


    /**
     * Retourne les �l�ments de l'arbre binaire.
     * @param list
     *   Doit �tre appel� avec une liste vide.
     *   list != null
     * @return
     *   Une liste contenant les �l�ments de l'arbre en ordre.
     */
    public List< E > elements( List< E > list, Parcours parcours ) {
        assert list != null;

        if(parcours == Parcours.PREFIXE){

            list.add( _element );
        }

        if( _gauche != null ) {
            _gauche.elements( list, parcours );
        }

        if(parcours == Parcours.INFIXE){

            list.add( _element );
        }

        if( _droite != null ) {
            _droite.elements( list, parcours );
        }

        if(parcours == Parcours.SUFFIXE){

            list.add( _element );
        }
        return list;
    }


    /**
     * Trouve le noeud contenant un �l�ment cible.
     * @param cible
     *   L'�l�ment cible � trouver
     *   cible != null
     * @return
     *   Un pointeur sur l'�l�ment recherch� ou un pointeur null
     *   si l'�l�ment n'est pas pr�sent dans l'arbre.
     */
    public ABRNoeud<E> chercher( E cible ) {
        assert cible != null;

        ABRNoeud< E > resultat = null;
        int direction = cible.compareTo( _element );

        if ( direction == 0 ) {
            resultat = this;
        } else if ( direction < 0 ) {
            resultat = ( _gauche == null ) ? null : _gauche.chercher( cible );
        } else {
            assert direction > 0;

            resultat = ( _droite == null ) ? null : _droite.chercher( cible );
        }

        return resultat;
    }


    /**
     * Ajouter un element dans l'arbre.
     * Aucun noeud n'est ajout� si l'�l�ment �tait d�j� pr�sent.
     * @param element
     *   l'�l�ment � ajouter
     *   element != null
     * @return
     *   Cette m�thode retourne un pointeur sur l'arbre r�sultant.
     */
    public ABRNoeud< E > inserer( E element ) {
        assert element != null;

        int direction = element.compareTo( _element );

        if ( direction < 0 ) {
            _gauche = ( _gauche == null ) ? new ABRNoeud< E >( element ) : _gauche.inserer( element );
        } else if ( direction > 0 ) {
            _droite = ( _droite == null ) ? new ABRNoeud< E >( element ) : _droite.inserer( element );
        }

        return this;
    }


    /**
     * Supprimer un element de l'arbre
     * @param element
     *   L'�l�ment � supprimer
     *   element != null
     * @return
     *   La racine de l'arbre duquel l'�l�ment � �t� supprim�.
     */
    public ABRNoeud<E> supprimer( E element ) {
        assert element != null;

        ABRNoeud<E> resultat = this;

        int direction = element.compareTo( _element );

        if( direction < 0 ) {
            if( _gauche != null ) {
                _gauche = _gauche.supprimer( element );
            }
        } else if( direction > 0 ) {
            if( _droite != null ) {
                _droite = _droite.supprimer( element );
            }
        } else {
            assert direction == 0;

            if( _gauche == null ) {
                resultat = _droite;
            } else if( _droite == null ) {
                resultat = _gauche;
            } else {
                assert _gauche != null && _droite != null;

                // Aller chercher l'element suivant et le supprimer.
                _element = _droite.elementPlusAGauche();
                _droite = _droite.supprimer( _element );
            }
        }

        return resultat;
    }

    public <R extends Comparable< R > > ABRNoeud< R > map( Function< ? super E,? extends R > f){
        ABRNoeud<R> nouvelArbre = new ABRNoeud<>(f.apply(_element));

        if(_gauche != null){
            nouvelArbre._gauche = _gauche.map(f);
        }
        if(_droite != null){
            nouvelArbre._droite = _droite.map(f);
        }
        return nouvelArbre;
    }

    public <R extends Comparable< R > > ABRNoeud< R > map2( Function< ? super E,? extends R > f){
        ArrayList<R> temp = elements(new ArrayList<E>(), Parcours.PREFIXE).stream()
                .map(e -> f.apply(e))
                .collect(Collectors.toCollection(ArrayList::new));

        R elemRacine = temp.remove(0);
        ABRNoeud<R> resultat = new ABRNoeud<>(elemRacine);

        temp.forEach(e-> resultat.inserer(e));

        return resultat;
    }

    // METHODES AUXILIAIRES


    /**
     * Ajoute n espace dans un StringBuilder.
     * Utilis� par le PrettyPrinter "pprint".
     * @param sb
     *   Le StringBuilder.
     *   sb != null
     * @param n
     *   Le nombre d'espace a ajouter.
     *   n >= 0
     */
    private void blanc( StringBuilder sb, int n ) {
        assert sb != null;
        assert n >= 0;

        int i;

        for( i = 0; i < n; ++ i ) {
            sb.append( ' ' );
        }
    }


    /**
     * Construit une version affichable de l'arbre, plus jolie que le toString.
     * @param sb
     *   Le StringBuilder ou la version affichable sera construite.
     *   sb != null
     * @param indent
     *   L'indentation de l'arbre.
     *   indent >= 0
     * @return
     *   Le StringBuilder contenant la version affichable de l'arbre.
     */
    public StringBuilder pprint( StringBuilder sb, int indent ) {
        assert sb != null;
        assert indent >= 0;

        int newIndent = indent + 2;

        if( _droite != null ) {
            _droite.pprint( sb, newIndent );
        }

        blanc( sb, indent );
        sb.append( _element + " " ).append( '\n' );

        if( _gauche != null ) {
            _gauche.pprint( sb, newIndent );
        }

        return sb;
    }


    /**
     * Retrouve l'element le plus a gauche de ce noeud
     * @return
     *   L'element le plus a gauche, ou l'element lui meme s'il n'y a rien a gauche.
     */
    protected E elementPlusAGauche() {
        return ( _gauche == null ) ? _element : _gauche.elementPlusAGauche();
    }
}

