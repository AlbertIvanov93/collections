import java.util.Collection;
import java.util.Comparator;

public interface MyList<E> {

    boolean add(E e);

    boolean remove(Object o);

    E get(int index);

    boolean addAll(Collection<? extends E> c);

    int size();

    void sort(Comparator<? super E> c);
}
