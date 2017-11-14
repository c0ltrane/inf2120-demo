package monStream;

import java.util.List;

/**
 * Created by thomas on 11/13/17.
 */
public class Main {
    public static void main(String[] args) {
        MaListe<String> salutations = new MaListe<>();
        salutations.add("Salut");
        salutations.add("Konichiwa");
        salutations.add("Tchau");
        salutations.add("Ola");
        salutations.add("Oi");
        salutations.add("Nihao");

        String resultat = salutations.fstream()
                .filter(s -> s.length() > 3)
                .map(s -> s.toUpperCase())
                .reduce("", ((acc, s) -> (acc + " " + s)));

        System.out.println(resultat);

        List<String> nouvellesSalutations = salutations.fstream()
                                                    .map(s -> s.toUpperCase())
                                                    .toList();
        for(String s : nouvellesSalutations){
            System.out.println(s);
        }
    }
}
