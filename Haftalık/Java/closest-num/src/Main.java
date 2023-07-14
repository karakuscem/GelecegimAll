import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] numbers = {15,12,788,1,-1,-778,2,0};
        Scanner input = new Scanner(System.in);
        System.out.println("Enter num");
        int num = input.nextInt();

        Arrays.sort(numbers);

        int closestSmaller = findClosestSmaller(numbers, num);
        int closestGreater = findClosestGreater(numbers, num);

        System.out.println("Girilen sayıdan küçük en yakın sayı: " + closestSmaller);
        System.out.println("Girilen sayıdan büyük en yakın sayı: " + closestGreater);
    }

    private static int findClosestSmaller(int[] numbers, int target) {
        int closest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num < target && num > closest) {
                closest = num;
            }
        }

        return closest;
    }

    private static int findClosestGreater(int[] numbers, int target) {
        int closest = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num > target && num < closest) {
                closest = num;
            }
        }

        return closest;
    }
}