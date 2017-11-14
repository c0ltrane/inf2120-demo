package monStream;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by thomas on 11/13/17.
 */
public interface IMonStream<T> {

    void forEach(Function<T,T> f);
    IMonStream<T> map(Function<T,T> f);
    IMonStream<T> filter(Function<T,Boolean> f);
    T reduce(T init, BiFunction<T,T,T> f);
    List<T> toList();
}
