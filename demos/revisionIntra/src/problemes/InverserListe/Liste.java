package problemes.InverserListe;

/**
 * Created by thomas on 10/19/17.
 */
public class Liste<T> {
    public Noeud<T> premier;
    public Noeud<T> dernier;

    public Liste() {
        premier = null;
        dernier = null;
    }

    public void ajouter (T val){
        Noeud<T> nouveau = new Noeud<>(val);
        if(premier == null) {
           premier = nouveau;
           dernier = nouveau;
        }
        else{
           dernier.suivant = nouveau;
           dernier = nouveau;
        }
    }

    public void afficher(){
        String liste = "";
        Noeud<T> courant = premier;
        while(courant != null){
           liste += courant.valeur;
           if(courant.suivant != null){
               liste += "->";
           }
           courant = courant.suivant;
        }
        System.out.println(liste);
    }

    public void inverser(){
        Noeud<T> precedent = null;
        Noeud<T> courant = premier;
        while(courant != null){
            Noeud<T> suivant = courant.suivant;
            courant.suivant = precedent;
            precedent = courant;
            courant = suivant;
        }
        dernier = premier;
        premier = precedent;
    }
}
