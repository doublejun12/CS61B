public class LinkedListDeque<T> {
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        public IntNode(T item, IntNode next, IntNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private final IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        size++;
        IntNode newNode = new IntNode(item, sentinel.next, sentinel);
        sentinel.next = newNode;
        newNode.next.prev = newNode;

    }

    public void addLast(T item) {
        size++;
        IntNode newNode = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev = newNode;
        newNode.prev.next = newNode;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode ptr = sentinel;
        while (ptr.next != sentinel) {
            ptr = ptr.next;
            System.out.print(ptr.item + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        size--;

        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;

        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        size--;

        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        return item;
    }

    public T get(int index) {
        IntNode ptr = sentinel;
        int i = 0;
        while (ptr.next != sentinel) {

            ptr = ptr.next;
            if (i == index) {
                return ptr.item;
            }
            i++;
        }

        return null;
    }

    public T getRecursive(int index) {
        return null;
    }
}
