import java.util.Random;
import java.util.Scanner;

public class SecurePasswordGenerator {

    // Characters to be used in the password
    private static final String CHARACTERS = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "0123456789" +
            "!@#$%^&*()-_=+[]{}|;:',.<>?/`~";

    // Method to generate a single password
    public static String generatePassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    // Method to generate multiple passwords
    public static String[] generateMultiplePasswords(int numberOfPasswords, int length) {
        String[] passwords = new String[numberOfPasswords];
        for (int i = 0; i < numberOfPasswords; i++) {
            passwords[i] = generatePassword(length);
        }
        return passwords;
    }

    // Method to print generated passwords
    public static void printGeneratedPasswords(String[] passwords) {
        System.out.println("\nGenerated Passwords:");
        for (int i = 0; i < passwords.length; i++) {
            System.out.println("Password " + (i + 1) + ": " + passwords[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Secure Password Generator!");

        int length;
        while (true) {
            System.out.print("Enter the desired password length (at least 12 characters recommended): ");
            length = scanner.nextInt();
            if (length >= 12) {
                break;
            } else {
                System.out.println("Password length should be 12 or greater. Please try again!!");
            }
        }

        System.out.print("Enter the number of passwords to generate: ");
        int numberOfPasswords = scanner.nextInt();

        String[] passwords = generateMultiplePasswords(numberOfPasswords, length);
        printGeneratedPasswords(passwords);

        scanner.close();
    }
}
