import java.util.EmptyStackException;
public class ArrayStack<E> implements Stack<E> {


    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private int capacity;    // Designates the capacity of the Array

    @SuppressWarnings( "unchecked" )
    public ArrayStack( int capacity ) {
        elems = (E[]) new Object[this.capacity];
        top = 0;
        this.capacity = capacity;
    }

    // Returns true if this ArrayStack is empty

    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it

    public E peek() {

        if (isEmpty()){
            throw new EmptyStackException();
        }

        return elems[ top-1 ];
    }

    // Removes and returns the top element of this stack

    public E pop() {

        if (isEmpty()){
            throw new EmptyStackException();
        }
        E saved = elems[ --top ];
        elems[ top ] = null;
        return saved;
    }

    // Puts the element onto the top of this stack.

    public void push( E element ) {

       if(top >=capacity) {
           throw new FullStackException("Stack is full");
       }
       elems[top++] = element;
    }


    // Gets current capacity of the array (for testing purpose)
    public int getCapacity() {
        return elems.length;
    }



    @SuppressWarnings( "unchecked" )
    public void clear() {
        elems = Arrays.copyOf(new Object[capacity], capacity, E[].class);
        top = 0;
    }
}



