import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    // если не последний елемент тогда смещаем оставшиеся,
                    // в ином случае сразу уменьшаем size и возвращаем true
                    if (i != size - 1) {
                        for (int j = i; j < size - 1; j++) {
                            elementData[j] = elementData[j + 1];
                        }
                    }
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    if (i != size - 1) {
                        for (int j = i; j < size - 1; j++) {
                            elementData[j] = elementData[j + 1];
                        }
                    }
                    elementData[size - 1] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        E element = (E) elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        boolean isChanged;
        int counter = 0;
        do {
            isChanged = false;
            for (int i = 0; i < size - 1 - counter; i++) {
                if (c.compare((E) elementData[i], (E) elementData[i + 1]) > 0) {
                    E temp = (E) elementData[i];
                    elementData[i] = elementData[i + 1];
                    elementData[i + 1] = temp;
                    isChanged = true;
                }
            }
            counter++;

        } while (isChanged);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] objectsToAdd = c.toArray();
        if (objectsToAdd.length == 0) {
            return false;
        }
        while (elementData.length < size + objectsToAdd.length) {
            grow();
        }
        System.arraycopy(objectsToAdd, 0, elementData, size, objectsToAdd.length);
        size += objectsToAdd.length;
        return true;
    }

    private void grow() {
        Object[] newElementData = new Object[elementData.length * 3 / 2 + 1];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("[");
            stringBuilder.append(elementData[i]);
            stringBuilder.append("]");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
