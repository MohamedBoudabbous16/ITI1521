import java.io.*;

public class SecretMessage {

    public static void encrypt(String inputFile, String outputFile, int key) throws IOException {
        try (
                InputStreamReader input = new InputStreamReader(new FileInputStream(inputFile));
                OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(outputFile))
        ) {
            int c;
            while ((c = input.read()) != -1) {
                out.write(c + key);
            }
        }
    }

    public static void decrypt(String inputFile, String outputFile, int key) throws IOException {
        try (
                InputStreamReader input = new InputStreamReader(new FileInputStream(inputFile));
                OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(outputFile))
        ) {
            int c;
            while ((c = input.read()) != -1) {
                out.write(c - key);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile outputFile key");
            System.exit(0);
        }

        try {
            if (args[0].equals("encrypt")) {
                encrypt(args[1], args[2], Integer.parseInt(args[3]));
            } else if (args[0].equals("decrypt")) {
                decrypt(args[1], args[2], Integer.parseInt(args[3]));
            } else {
                System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile outputFile key");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Cannot read/write file: " + e.getMessage());
        }
    }
}

