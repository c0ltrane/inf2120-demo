package pointeurs;

/**
 * Created by thomas on 9/10/17.
 */
public class Main {

    public static void main(String[] args) {
        Couleur c1 = new Couleur(10, 20, 30);
        Couleur c2 = c1;
        Couleur c3 = new Couleur(c1);

        println("c1: " + c1.toString());
        println("c2: " + c2.toString());
        println("c3: " + c3.toString());

        c2.setRouge(100);

        c1.blanchir();

        println();

        println("c1: " + c1.toString());
        println("c2: " + c2.toString());
        println("c3: " + c3.toString());
    }

    private static void println() {
        System.out.println();
    }

    private static void println(String s) {
        System.out.println(s);
    }
}
