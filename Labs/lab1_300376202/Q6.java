import java.util.Scanner;
import java.util.Arrays; // Importation nécessaire pour utiliser Arrays.sort

class Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez les 10 notes espacées par des espaces : ");
        String inputLine = scanner.nextLine();
        String[] noteStrings = inputLine.split(" ");
        double[] notes = new double[10];

        for (int i = 0; i < notes.length; i++) {
            notes[i] = Double.parseDouble(noteStrings[i]);
        }

        System.out.println("Moyenne des notes: " + calculateAverage(notes));
        System.out.println("Médiane des notes: " + calculateMedian(notes));
        System.out.println("Nombre d'échecs: " + calculateNumberFailed(notes));
        System.out.println("Nombre de réussites: " + calculateNumberPassed(notes));
    }

    public static double calculateAverage(double[] notes) {
        double totalScore = 0;
        int numberOfNotes = notes.length;

        for (int i = 0; i < numberOfNotes; i++) {
            totalScore += notes[i];
        }

        return totalScore / numberOfNotes;
    }

    public static double calculateMedian(double[] notes) {
        Arrays.sort(notes);
        int numberOfNotes = notes.length;
        int middleIndex = numberOfNotes / 2;

        if (numberOfNotes % 2 == 1) {
            return notes[middleIndex];
        } else {
            return (notes[middleIndex - 1] + notes[middleIndex]) / 2.0;
        }
    }

    public static int calculateNumberFailed(double[] notes) {
        int failedCount = 0;
        for (double note : notes) {
            if (note < 50) {
                failedCount++;
            }
        }
        return failedCount;
    }

    public static int calculateNumberPassed(double[] notes) {
        int passedCount = 0;
        for (double note : notes) {
            if (note >= 50) {
                passedCount++;
            }
        }
        return passedCount;
    }
}
