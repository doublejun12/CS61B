import java.util.Objects;

public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        first = 3;
        last = 4;
    }

    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, 0, a, 0, items.length);
        items = a;
    }

    public void addFirst(T item) {
        size = size + 1;

        if (first == last) {
            resize(items.length * 2);
        }

        items[first] = item;
        if (first == 0) {
            first = items.length - 1;
        } else {
            first = first - 1;
        }
    }

    public void addLast(T item) {
        size = size + 1;

        if (first == last) {
            resize(items.length * 2);
        }

        items[last] = item;
        if (last == items.length - 1) {
            last = 0;
        } else {
            last = last + 1;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = (first + 1) % items.length;
        while (i != last) {
            System.out.print(items[i] + " ");
            i = (i + 1) % items.length;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        first = (first + 1) % items.length;
        T itemFirst = items[first];
        size--;

        return itemFirst;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if(last == 0) {
            last = items.length - 1;
        } else {
            last--;
        }
        T itemLast = items[last];
        size--;

        return itemLast;
    }

    public T get(int index) {
        if (size == 0 || index > size - 1) {
            return null;
        }

        return items[(first + index + 1) % items.length];
    }

    /**public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(100);
        A.addLast(30);
        System.out.print(A.removeFirst());
    }*/
}
