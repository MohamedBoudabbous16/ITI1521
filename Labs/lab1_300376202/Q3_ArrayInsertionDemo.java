public class Q3_ArrayInsertionDemo {
    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert) {
        int i = beforeArray.length;
        int[] L = new int[i+1];
        int j;
        for (j = 0; j < indexToInsert; j++) {
            L[j] = beforeArray[j];
        }
        L[indexToInsert] = valueToInsert;
        int m;
        for (m = indexToInsert ; m < i; m++) {
            L[m+1] = beforeArray[m];
        }
        return L;
    }

    public static void main(String[] args) {
        int[] beforeArray = new int[]{1, 5, 4, 7, 9, 6};
        int[] ints = insertIntoArray(beforeArray, 3, 15);
        System.out.println("Array avant l'insertion");
        int j;
        for (j = 0; j < beforeArray.length; j++) {
            System.out.println(beforeArray[j]);
        }
        int m;
        System.out.println("Array aprés l'insertion de 15 à position 3: ");
        for (m = 0; m < ints.length; m++) {
            System.out.println(ints[m]);

        }
    }
}
