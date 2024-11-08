public class Q3_SquareArray {
    public static int[] createArray(int size) {
        int [] xs;
        xs = new int [size];
        int i;
        for (i = 0; i < size; i++) {
            xs[i] = i * i;
        }
        return xs;
    }
    public static void main(String[] args){
        int [] L;
        L = createArray(13);
        for (int i = 0; i < L.length; i++) {
            System.out.println("The square of "+i+" is: "+L[i]);
        }

    }
}

