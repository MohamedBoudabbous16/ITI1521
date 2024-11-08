public class SinglyLinkedList<E> implements List<E> {

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public void add(E elem, int index) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            head = new Node<E>(elem, head);
        } else {
            Node<E> p = head;
            for (int i=0; i<(index-1); i++) {
                p = p.next;
            }
            p.next = new Node<E>(elem, p.next);
        }
        size++;
    }

    public void remove(int pos) {
      ;  // inutilise donc pas besoin d etre implementé
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> p = head;
        for (int i=0; i<index; i++) {
            p = p.next;
        }
        return p.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //TODO
    //completer le code manquant necessaire pour la méthode 'recurisve' allTrue
    public boolean allTrue(){
        if (head == null){
            throw new IllegalArgumentException();
        }
        return allTrueRecursive(head.next);
    }

    public boolean allTrueRecursive(Node<E> node){
        if (node == null){
            return true;
        }
        if (!Boolean.TRUE.equals(node.value)){
            return false;
        }
        return allTrueRecursive(node.next);
    }


    @Override
    public String toString() {
        String str = "[";
        Node<E> p = head;
        while (p!=null) {
            if (p != head) {
                str += ", ";
            }
            str += p.value;
            p = p.next;
        }
        str += "]";
        return str;
    }
}
