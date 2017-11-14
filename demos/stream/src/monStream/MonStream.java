package monStream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by thomas on 11/13/17.
 */

/**
 * Cette classe est une implementation des methodes de Stream de la librairie standard de Java
 *
 */

public class MonStream<U> implements IMonStream<U> {


    private List<U> conteneur;

    public MonStream(){
        conteneur = new LinkedList<>();
    }

    public MonStream(List<U> ancienConteneur){
        conteneur = new LinkedList<>(ancienConteneur);
    }

    public void forEach(Function<U,U> f){
        for (U elem: conteneur) {
           f.apply(elem);
        }
    }

    public IMonStream<U> map (Function<U,U> f){
        MonStream<U> nouveauStream = new MonStream<>();
        for(U elem : conteneur){
           nouveauStream.getConteneur().add(f.apply(elem));
        }
        return nouveauStream;
    }

    public IMonStream<U> filter (Function<U,Boolean> f){
        MonStream<U> nouveauStream = new MonStream<>();
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
