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

    public void inserer(String elem){
        racine.inserer(elem);
    }

    public String toHtml(){
       String html = toHtmlRec(racine, "", 0);
       return html;
    }

    private String toHtmlRec(ABRNoeud noeud, String html, int profondeur){
        profondeur++;
        String tabs = String.join("", Collections.nCopies(profondeur, "\t"));

        html += tabs + "<" + noeud._element + ">" + "\n";
        if(noeud._gauche != null){
           html = toHtmlRec(noeud._gauche, html, profondeur);
        }

        if(noeud._droite != null){
            html = toHtmlRec(noeud._droite, html, profondeur);
        }
        html += tabs + "</" + noeud._element + ">" + "\n";
        return html;
    }
}
