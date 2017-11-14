package monStream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by thomas on 11/13/17.
 */

/**
 * Cette classe est une implementation des methodes de Stream de la librairie standard de Java
 *
 */

public class MaListeStream<U> implements IMonStream<U> {


    private List<U> conteneur;

    public MaListeStream(){
        conteneur = new LinkedList<>();
    }

    public MaListeStream(List<U> ancienConteneur){
        conteneur = new LinkedList<>(ancienConteneur);
    }

    public void forEach(Consumer<U> f){
        for (U elem: conteneur) {
           f.accept(elem);
        }
    }

    public IMonStream<U> map (Function<U,U> f){
        MaListeStream<U> nouveauStream = new MaListeStream<>();
        for(U elem : conteneur){
           nouveauStream.getConteneur().add(f.apply(elem));
        }
        return nouveauStream;
    }

    public IMonStream<U> filter (Function<U,Boolean> f){
        MaListeStream<U> nouveauStream = new MaListeStream<>();
        for(U elem : conteneur){
            if(f.apply(elem)){
                nouveauStream.getConteneur().add(elem);
            }
        }
        return nouveauStream;
    }

    public U reduce (U init, BiFunction<U,U,U> f){
        U accumulateur = init;
        for(U elem: conteneur){
            accumulateur = f.apply(accumulateur, elem);
        }
        return accumulateur;
    }

    public List<U> getConteneur() {
        return conteneur;
    }

    public List<U> toList(){
        return getConteneur();
    }


}
