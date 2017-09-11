package pointeurs;

/**
 * Created by thomas on 9/10/17.
 */
public class Main {
    public static void main(String[] args) {
        Couleur c1 = new Couleur(1, 4, 6);
        Couleur c2 = c1;

        println("c1: " + c1.toString());
        println("c2: " + c2.toString());

        c2.setRouge(100);

        c1.blanchir();

        println("c1: " + c1.toString());
        println("c2: " + c2.toString());
    }

    private static void println(String s) {
        System.out.println(s);
    }
}
