import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static boolean isPalindromic(String str) {
        StringBuilder newString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            newString.append(str.charAt(i));
        }
        return str.contentEquals(newString);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter word: ");
        String str = input.nextLine();

        if (isPalindromic(str))
            System.out.println("Word is palindromic");
        else
            System.out.println("Word is not palindromic");
    }
}