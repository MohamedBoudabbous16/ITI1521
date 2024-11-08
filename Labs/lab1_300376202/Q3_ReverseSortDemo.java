public class Q3_ReverseSortDemo {
    public static void main(String[] args) {
        char[] unorderedLetters;
        unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
        reverseSort(unorderedLetters);
        for (int i = 0; i < unorderedLetters.length; i++) {
            System.out.print(unorderedLetters[i]);
        }
    }

        //method that sorts a char array into its reverse alphabetical order
        public static void reverseSort(char[] values) {
            for (int i = 0; i < values.length - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < values.length; j++) {
                    if (values[j] > values[maxIndex]) {
                        maxIndex = j;
                    }
                }
                // Swap the elements at i and maxIndex
                char temp = values[maxIndex];
                values[maxIndex] = values[i];
                values[i] = temp;
            }
        }
    }
