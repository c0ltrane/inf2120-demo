/**
 * Created by af491150 on 2017-10-26.
 */
public class Noeud<U> {
        public U element;
        public Noeud<U> suivant;

        public Noeud( U element ){
            this.element = element;
            this.suivant = null;
        }
}
