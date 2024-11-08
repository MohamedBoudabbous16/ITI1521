import java.util.*;

public class Dictionary implements Map<String, Integer> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int INCREMENT = 5;
    private int count;
    private Pair[] elems;

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key is null or value is null");
        }


        if (count >= elems.length) {
            increaseCapacity();
        }

        elems[count++] = new Pair(key, value);
    }

    private void increaseCapacity() {
        int newSize = elems.length + INCREMENT;
        Pair[] newElems = new Pair[newSize];

        for (int i = 0; i < count; i++) {
            newElems[i] = elems[i];
        }

        elems = newElems;
    }


    @Override
    public Integer get(String key) throws NoSuchElementException {
        if (key == null) {
            throw new NullPointerException("key is null");
        }

        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return elems[i].getValue();
            }
        }

        throw new NoSuchElementException("key not found: " + key);
    }

    @Override
        public Integer remove(Object key) throws NoSuchElementException{
            if (key == null) {
                throw new NullPointerException("key is null");
            }

            int pos = count - 1;
            while (pos >= 0) {
                if (elems[pos].getKey().equals(key)) {
                    Integer value = elems[pos].getValue();
                    System.arraycopy(elems, pos + 1, elems, pos, count - pos - 1);
                    elems[--count] = null;
                    return value;
                }
                pos--;
            }

            throw new NoSuchElementException("key not found: " + key);
        }


        public void replace(String key, Integer value) throws NoSuchElementException {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }

        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                elems[i].setValue(value);
                return;
            }
        }

        throw new NoSuchElementException("key not found: " + key);
    }





    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }

        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Dictionary: {elems = [");
        for (int i = count - 1; i >= 0; i--) {
            res.append(elems[i]);
            if (i > 0) {
                res.append(", ");
            }
        }
        res.append("]}");
        return res.toString();
    }


}
