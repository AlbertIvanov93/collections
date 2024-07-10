import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class MyLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> head;

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = new Node<>(null, e, null);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(current, e, null);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> current = head;
        while (current != null) {
            if (current.item.equals(o)) {
                if (current == head) {
                    current.next.prev = null;
                    head = current.next;
                } else if (current.next == null) {
                    current.prev.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
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
            Node<E> current = head;
            for (int i = 0; i < size - 1 - counter; i++) {
                if (c.compare(current.item, current.next.item) > 0) {
                    E temp = current.item;
                    current.item = current.next.item;
                    current.next.item = temp;
                    isChanged = true;
                }
                current = current.next;
            }
            counter++;

        } while (isChanged);
    }

    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append("[");
            stringBuilder.append(current.item);
            stringBuilder.append("]");
            current = current.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
