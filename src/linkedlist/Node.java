package linkedlist;

public class Node<T> {
    private Node<T> next;
    private T obj;

    public Node(T obj) {
        this.obj = obj;
        this.next = null;
    }
    
    public Node(T obj, Node<T> next) {
        this.obj = obj;
        this.next = next;
	}

	public Node<T> getNext() {
        return next;
    }

    public T getObj() {
        return obj;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}