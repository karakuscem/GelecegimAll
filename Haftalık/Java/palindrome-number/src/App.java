import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        number = input.nextInt();

        if (isPalindrome(number)) {
            System.out.println(number + " palindromiktir.");
        } else {
            System.out.println(number + " palindromik değildir.");
        }
        input.close();
    }
    public static boolean isPalindrome(int number) {
        int reversedNumber = 0;
        int originalNumber = number;
        while (number != 0) {
            int remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;
        }
        return originalNumber == reversedNumber;
    }
}
