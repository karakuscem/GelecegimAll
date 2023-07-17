import java.util.HashSet;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 3, 9, 12, 9, 5, 12, 18, 22, 31, 31, 31};
        HashSet<Integer> duplicated = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    duplicated.add(arr[i]);
            }
        }

        for (int nums : duplicated) {
            System.out.println("Duplicated " + nums);
        }
    }
}