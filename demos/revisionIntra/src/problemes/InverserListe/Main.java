package problemes.InverserListe;

/**
 * Created by thomas on 10/19/17.
 */
public class Main {
    public static void main(String[] args) {
        Liste<Integer> uneListe = new Liste<>();
        for (int i = 0; i < 10; i++){
            uneListe.ajouter(i);
        }
        uneListe.afficher();
        uneListe.inverser();
        uneListe.afficher();
    }
}
