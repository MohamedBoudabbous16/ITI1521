import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

  

    public OrderedList() {

       head = new Node(null,null,null);
       head.next = head;
       head.previous = head;
    }



    public int size() {

        int count = 0;
        Node current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }


    public Object get( int pos ) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Position cannot be negative");
        }

        int index = 0;
        Node current = head.next;
        while (current != head && index < pos) {
            current = current.next;
            index++;
        }

        if (current == head || index != pos) {
            throw new IndexOutOfBoundsException("Position exceeds list size");
        }

        return current.value;
    }



    public boolean add( Comparable o ) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot add null");
        }

        Node current = head.next;
        while (current != head && current.value.compareTo(o) < 0) {
            current = current.next;
        }

        Node newNode = new Node(o, current.previous, current);
        current.previous.next = newNode;
        current.previous = newNode;

        return true;
    }
    public void remove(int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Position cannot be negative");
        }

        int index = 0;
        Node current = head.next;
        while (current != head && index < pos) {
            current = current.next;
            index++;
        }

        if (current == head || index != pos) {
            throw new IndexOutOfBoundsException("Position exceeds list size");
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    public void merge(OrderedList other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot merge with null list");
        }

        Node currentThis = head.next;
        Node currentOther = other.head.next;

        while (currentOther != other.head) {
            while (currentThis != head && currentThis.value.compareTo(currentOther.value) < 0) {
                currentThis = currentThis.next;
            }
            Node nextOther = currentOther.next;

            currentOther.next = currentThis;
            currentOther.previous = currentThis.previous;
            currentThis.previous.next = currentOther;
            currentThis.previous = currentOther;

            currentOther = nextOther;
        }
    }
}



