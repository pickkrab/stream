import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;

public class Stream<T> {
    private List<T> list;

    public static <T> Stream<T> of(List<? extends T> someCollections) {
        Stream<T> stream = new Stream<T>();
        stream.list = new ArrayList<T>(someCollections);
        return stream;
    }

    public Stream<T> filter(Predicate<? super T> predicate) {
        Iterator<T> iter = list.iterator();
        while (iter.hasNext()) {
            if (!predicate.test(iter.next())) iter.remove();
        }
        return this;
    }

    public Stream<T> transform (Function<? super T, ? extends T> function) {
        for (T t : list) {
            list.set(list.indexOf(t), function.apply(t));
        }
        return this;
    }

    public<K, V> Map<K, V> toMap(Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
        Map<K, V> map = new HashMap<K, V>();
        for (T t : list) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }
}
