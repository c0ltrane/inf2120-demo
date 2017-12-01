package DOM;

import TDA.ABRNoeud;

import java.util.Collections;

/**
 * Created by thomas on 11/30/17.
 */
public class DOM {

    private DOMNoeud<String> racine;

    public DOM(){
        racine = new DOMNoeud<String>("html");
    }

    public DOMNoeud<String> chercher(String elem){
        return racine.chercher(elem);
    }

    public String toHtml(){
        String html = "<!doctype html>\n";
        html += toHtmlRec(racine, "", -1);
        return html;
    }

    private String toHtmlRec(DOMNoeud<String> noeud, String html, int profondeur){
        profondeur++;
        String tabs = String.join("", Collections.nCopies(profondeur, "\t"));

        html += tabs + "<" + noeud._tag + ">" + "\n";
        if(noeud._valeur != null){
            html += tabs + "\t" + noeud._valeur + "\n";
        }
        for (DOMNoeud<String> enfant : noeud._enfants){
            html = toHtmlRec(enfant, html, profondeur);
        }
        html += tabs + "</" + noeud._tag + ">" + "\n";
        return html;
    }
}
