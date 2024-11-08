import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E value) {
        if (value == null) {
            throw new NullPointerException();
        }

        top = new Elem<E>(value, top);
    }

    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public E pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        E saved = top.value;
        top = top.next;
        return saved;
    }

    @Override
    public String toString() {
        String str = "(top) -> [";
        Elem<E> p = top;

        while (p != null) {
            if (p != top) {
                str += ", ";
            }
            str += p.value;
            p = p.next;
        }
        str += "] <- (bottom)";
        return str;
    }

}
