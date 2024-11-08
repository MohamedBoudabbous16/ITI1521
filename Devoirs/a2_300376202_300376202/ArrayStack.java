public class ArrayStack<E> implements Stack<E> {

    // Instance variables  
    private E[] elems;
    private int top;
    
    // Constructor
    @SuppressWarnings("unchecked")
    public ArrayStack( int capacity ) {
        elems =  (E[]) new Object[capacity];
        top = 0; 
    }

    public boolean isEmpty() {
        return (top ==0);
    }

    public E peek() {
        return elems[top-1];

    }

    public E pop() {
        E resultat = elems [top-1]; 
        elems[top-1] = null; // pour le garbage collector
        top--;
        return resultat;
    }

    @SuppressWarnings("unchecked")
    public void push( E element) {
        E[] newArray;

        if (top == elems.length) {
            Object[] newTableau = new Object[elems.length*4];
            newArray =  (E[]) newTableau;
            for (int i=0; i<top; i++) {
                newArray[i] = elems[i];
            } 
        elems = newArray;
        }
        elems[top++] = element;

    }
    
}
