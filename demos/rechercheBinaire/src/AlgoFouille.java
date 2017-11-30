/**
 * Created by thomas on 11/23/17.
 */
public class AlgoFouille {

    public static < E extends Comparable< E > > int FouilleBinaire( E [] tableau, E element) throws ElementNonPresent {
        int debut = 0;
        int fin = tableau.length - 1;
        int indiceElement = -1;

        while( debut <= fin){
            int milieu = debut + (fin - debut) / 2;
            if(tableau[milieu].compareTo(element) == 0){
                indiceElement = milieu;
                break;
            }
            else if( tableau[milieu].compareTo(element) < 0){
                debut = milieu + 1;
            }
            else {
                fin = milieu - 1;
            }
        }
        if(indiceElement == -1){
            throw new ElementNonPresent();
        }
        return indiceElement;
    }
    public static < E extends Comparable< E > > int FouilleBinaireR( E [] tableau, E element, int debut, int fin ) throws ElementNonPresent {
        int resultat = 0;
        if(debut <= fin){
            int milieu = debut + (fin - debut) / 2;

            if(tableau[milieu].compareTo(element) == 0){
               resultat = milieu;
            }
            else if(tableau[milieu].compareTo(element) < 0){
                resultat = FouilleBinaireR(tableau, element, milieu + 1, fin);
            }
            else if(tableau[milieu].compareTo(element) > 0){
                resultat = FouilleBinaireR(tableau, element, debut, milieu - 1);
            }
        }
        else{
            throw new ElementNonPresent();
        }
        return resultat;
    }
}
