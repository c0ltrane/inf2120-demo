package typesgeneriques;

/**
 * Created by thomas on 9/27/17.
 */
public class Principale {
    public static void main(String[] args) {
        String[] langages = {"Python", "Java", "C++", "Haskell", "Elm"};
        String langageConnu = "Haskell";
        PeutEtre<Integer> peutEtre = trouverElement(langages, langageConnu);

        try{
            System.out.println("Le langage recherche " + langageConnu +" a ete trouve! Son indice est: " + peutEtre.qQChose());
        } catch(ARien aRien){
            System.out.println("Le langage recherche " + langageConnu + " n'a pas ete trouve!");
        }

        String langageInconnu = "Go";
        PeutEtre<Integer> peutEtre2 = trouverElement(langages, langageInconnu);

        try{
            System.out.println("Le langage recherche a ete trouve! Son indice est: " + peutEtre2.qQChose());
        } catch(ARien aRien){
            System.out.println("Le langage recherche " + langageInconnu + " n'a pas ete trouve!");
        }
    }
    public static <T> PeutEtre<Integer> trouverElement( T[] tableau, T element ){
        PeutEtre<Integer> peutEtre;
        boolean trouve = false;
        int i = 0;

        while (!trouve && (i < tableau.length)) {
            if (tableau[i].equals(element)) {
                trouve = true;
            } else {
                i++;
            }
        }

        if (trouve) {
            peutEtre = new QQChose<>(i);
        } else {
            peutEtre = new Rien<>();
        }

        return peutEtre;
    }
}
