public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public void enqueue(E value) {

        if (value == null) {
            throw new NullPointerException();
        }

        Elem<E> newElem;
        newElem = new Elem<E>(value, null );

        if (rear == null) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }

    public E dequeue(){

        if (front == null) {
            throw new EmptyQueueException();
        }

        E result = front.value;

        if (front.next == null) {
            front = rear = null;
        } else {
            front = front.next;
        }

        return result;
    }

    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public String toString() {
        String str = "(front) -> [";
        Elem<E> p = front;

        while (p != null) {
            if (p != front) {
                str += ", ";
            }
            str += p.value;
            p = p.next;
        }
        str += "] <- (rear)";
        return str;
    }

}
