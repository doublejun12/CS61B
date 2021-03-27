public class LinkedListDeque<genericType> {
    private class IntNode {
        public genericType item;
        public IntNode next;
        public IntNode prev;

        public IntNode(genericType item, IntNode next, IntNode prev) {
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

    public void addFirst(genericType item) {
        size++;
        IntNode newNode = new IntNode(item, sentinel.next, sentinel);
        sentinel.next = newNode;
        newNode.next.prev = newNode;

    }

    public void addLast(genericType item) {
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

    public genericType removeFirst() {
        if(size == 0) {
            return null;
        }

        size--;

        genericType item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;

        return item;
    }

    public genericType removeLast() {
        if(size == 0) {
            return null;
        }

        size--;

        genericType item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        return item;
    }

    public genericType get(int index) {
        IntNode ptr = sentinel;
        int i = 0;
        while(ptr.next != sentinel) {

            ptr = ptr.next;
            if(i == index) {
                return ptr.item;
            }
            i++;
        }

        return null;
    }

    public genericType getRecursive(int index) {
        return null;
    }
}
