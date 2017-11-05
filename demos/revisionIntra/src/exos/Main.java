package exos;

/**
 * Created by thomas on 10/23/17.
 */
public class Main {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        Quadrilatere q = new Rectangle();
        ElementGraphique e = new Quadrilatere();
        Rectangle r = new Rectangle();

        t.afficher();
        q.afficher();
        e.afficher();
        t.uneMethode(q);
        q.uneMethode(t);
        r.uneMethode(q);
    }
}
