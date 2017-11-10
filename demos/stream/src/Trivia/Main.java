package Trivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by thomas on 11/8/17.
 */
public class Main {

    private static int compteur = 0;

    private static void incrementerCompteur(){
        compteur++;
    }

    public static void main(String[] args) {

        // Ici on utilise stream pour approximer la valeur de PI (avec la formule de Leibniz)
        // et on compare les performances de stream et parallelstream

        Timer timer = new Timer();
        double monPI = approximerPI();
        double tempsEcoule = timer.getElapsedTime();
        System.out.println("valeur de PI calculee: " + monPI + " en " + tempsEcoule * 10E9 + " sec");

        timer.restart();
        double monPIparallele = approximerPIparallele();
        tempsEcoule = timer.getElapsedTime();
        System.out.println("valeur de PI calculee: " + monPIparallele + " en " + tempsEcoule * 10E9 + " sec");

        double tauxErreur = Math.abs(Math.PI - monPI) / Math.PI;
        System.out.println("Le taux d'erreur est de: " + tauxErreur);


        // Ici on etudie le concept d'evaluation paresseuse avec les streams

        List<String> liste = Arrays.asList("abc1", "abc2", "abc3");

        evaluationParesseuse1(liste);
        System.out.println(compteur);

        evaluationParesseuse2(liste);
        System.out.println(compteur);


        // Ici on voit comment on peut composer des fonctions avec reduce

        Function<Integer, Integer> doubler = x -> x + x;
        Function<Integer, Integer> carre = x -> x * x;
        Function<Integer, Integer> plus3 = x -> x + 3;

        List<Function> operations = new ArrayList<Function>() {{
            add(doubler);
            add(carre);
            add(plus3);
        }};

        Function<Integer, Integer> fctComposee = operations.stream().reduce((x->x),Function::compose);
        System.out.println(fctComposee.apply(2));
    }

    public static double approximerPI(){
        return LongStream.range(0L, 1_000_000_000L)
                .map(i -> ((i % 2) == 0 ? 1 : -1) * (2 * i + 1))
                .mapToDouble(i -> 4.0 / i)
                .sum();
    }

    public static double approximerPIparallele(){
        return LongStream.range(0L, 1_000_000_000L).parallel()
                .map(i -> ((i % 2) == 0 ? 1 : -1) * (2 * i + 1))
                .mapToDouble(i -> 4.0 / i)
                .sum();
    }

    public static void evaluationParesseuse1(List<String> liste){
        Stream<String> stream = liste.stream().filter(element -> {
            incrementerCompteur();
            return element.contains("2");
        });
    }

    public static void evaluationParesseuse2(List<String> liste){
        liste.stream().filter(element -> {
            System.out.println("appel de filter()");
            incrementerCompteur();
            return element.contains("2");
        }).map(element -> {
            System.out.println("appel de map()");
            incrementerCompteur();
            return element.toUpperCase();
        }).findFirst();
    }

}
