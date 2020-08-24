public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public LinkedList(T obj) {
        Node<T> newNode = new Node<T>(obj);
        first = newNode;
        last = newNode;
        size++;
    }

    public void addFirst(T obj) {
        Node<T> newNode = new Node<T>(obj);
        newNode.setNext(this.first);
        this.first = newNode;
        size++;
    }

    public void add(T obj) {
        Node<T> newNode = new Node<T>(obj);
        this.last.setNext(newNode);
        this.last = newNode;
        size++;
    }

    public void addIn(int position, T obj) {
        validatePosition(position);
        Node<T> before = getBefore(position);
        Node<T> newNode = new Node<T>(obj, before.getNext());
        before.setNext(newNode);
        size++;
    }
    
    public void remove(int position) {
        validatePosition(position);
        Node<T> before = getBefore(position);
        before.setNext(before.getNext().getNext());
        size--;
    }

    public void removeFirst() {
        this.first = this.first.getNext();
        size--;
    }

    public void removeLast() {
        Node<T> before = getBefore(size-1);
        before.setNext(null);
        size--;
    }

    public T get(int position) {
        validatePosition(position);
        return getBefore(position).getNext().getObj();
    }

    private void validatePosition(int position) {
        if (position >= size) throw new IllegalArgumentException("invalid position");
    }

    private Node<T> getBefore(int position) {
        Node<T> before = this.first;
        for (int i = 0; i < position; i++) {
            before = before.getNext();
        }
        return before;
    }

    public int size() {
        return size;
    }
}