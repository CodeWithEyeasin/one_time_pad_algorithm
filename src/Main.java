import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select One Option:\n1.Message Encryption\n2.Message Decryption");
        boolean isTrue = false;
        while (!isTrue){
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    encryption();
                    isTrue = true;
                }
                case 2 -> {
                    decryption();
                    isTrue = true;
                }
                default -> System.out.println("Please Enter The Right Option");
            }
        }
    }

    private static void encryption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to encrypt: ");
        String message = scanner.nextLine();

        System.out.print("Enter the key value for the message: ");
        String key = scanner.nextLine();

        // Ensure key length matches the message length
        if (key.length() < message.length()) {
            key = repeatKeyToMatchLength(key, message.length());
        } else if (key.length() > message.length()) {
            key = key.substring(0, message.length());
        }

        message = message.toLowerCase();
        key = key.toLowerCase();

        int cipher[] = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            cipher[i] = message.charAt(i) - 'a' + key.charAt(i) - 'a';

            if (cipher[i] > 25) {
                cipher[i] = cipher[i] - 26;
            }
            int x = cipher[i] + 'a';
            String ciphertext = String.valueOf((char) x);
            System.out.print(ciphertext);
        }
    }

    private static void decryption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to decrypt: ");
        String message = scanner.nextLine();

        System.out.print("Enter the key value for the message: ");
        String key = scanner.nextLine();

        // Ensure key length matches the message length
        if (key.length() < message.length()) {
            key = repeatKeyToMatchLength(key, message.length());
        } else if (key.length() > message.length()) {
            key = key.substring(0, message.length());
        }

        message = message.toLowerCase();
        key = key.toLowerCase();

        int plain[] = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            plain[i] = message.charAt(i) - 'a' - (key.charAt(i) - 'a');
            if (plain[i] < 0) {
                plain[i] = plain[i] + 26;
            }
            int x = plain[i] + 'a';
            System.out.print((char) x);
        }
    }

    private static String repeatKeyToMatchLength(String key, int length) {
        int repetitions = (length + key.length() - 1) / key.length();
        String repeatedKey = key.repeat(repetitions);
        return repeatedKey.substring(0, length);
    }


}
