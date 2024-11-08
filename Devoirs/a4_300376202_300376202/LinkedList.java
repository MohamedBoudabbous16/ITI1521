public class LinkedList<E> implements List<E> {

    private static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = new Node<E>(null, null, null);
        head.prev = head;
        head.next = head;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int pos) {

        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Node<E> p;
        p = head.next;

        while (pos > 0) {
            p = p.next;
            pos--;
        }

        return p.value;
    }

    public void add(E element, int pos) {

        if (element == null) {
            throw new NullPointerException();
        }

        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Node<E> before, after;
        before = head;

        while (pos > 0) {
            before = before.next;
            pos--;
        }

        after = before.next;

        before.next = new Node<E>(element, before, after);
        after.prev = before.next;

        size++;
    }

    public void remove(int pos) {

        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Node<E> before, after;
        before = head;

        while (pos > 0) {
            before = before.next;
            pos--;
        }

        after = before.next.next;

        before.next = after;
        after.prev = before;

        size--;
    }


    public void merge(LinkedList<E> other) {
        //TODO: Ajouter votre code ici.
        // Cas de base
        Node<E> last = head.prev;

        Node<E> otherLast = other.head.prev;

        int otherSize = other.size;

        while (last.next != head) {
            last = last.next;
        }

        while (otherLast != other.head) {

            Node<E> newNode = new Node<E>(otherLast.value, last, head);

            last.next = newNode;

            newNode.prev = last;

            otherLast = otherLast.prev;

            size++;

            otherSize--;

        }

        other.size = otherSize;
        other.head.next = other.head;
        other.head.prev = other.head;

    }

    private class ListIterator<E> implements Iterator<E>{

        private LinkedList<E> List;
        private Node<E> now;
        private ListIterator(LinkedList<E> List) {
            this.List = List;
            now = List.head;
        }


        public E next(){
            if (now.next.value==null){
                now=now.next;
            }

            now = now.next;
            return now.value;

        }
        public E prev(){
            if (now.prev.value==null) {
                now=now.prev;
            }

            now = now.prev;

            return now.value;


        }
        public boolean hasNext(){
            if (now.next.value!=null){
                return true;
            }
            else {
                return false;
            }


        }
        public boolean hasPrev(){
            if (now.prev.value!=null){
                return true;
            }
            else {
                return false;

            }
        }
    }

    public Iterator<E> iterator() {
        return new ListIterator<E>(this);
    }

    // Méthode helper pour retirer le premier élément
    private void removeFirst() {
        // Si liste vide ne rien faire
        if(head.next == head) return;

        // Retirer le premier élément
        head.next = head.next.next;
        head.next.prev = head;
        size--;
    }


    public String toString() {

      StringBuffer b;
      b = new StringBuffer("LinkedList [");
      
      Node<E> p;
      p = head.next;
      
      while (p != head) {
        b.append(p.value);
        if (p.next != head) {
          b.append(",");
        }
        p = p.next;
      }
      
      b.append("]");
      
      return b.toString();
    }
    
    
}
