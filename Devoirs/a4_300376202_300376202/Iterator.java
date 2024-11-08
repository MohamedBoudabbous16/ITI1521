public interface Iterator<E> {
    E next();
    E prev();
    boolean hasNext();
    boolean hasPrev();
}
