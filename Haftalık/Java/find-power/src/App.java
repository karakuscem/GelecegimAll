import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int num;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = input.nextInt();

        for (int i = 1; i <= num; i *= 4) {
            System.out.println("4 " + i);
        }

        for (int i = 1; i <= num; i *= 5) {
            System.out.println("5 " + i);
        }

        input.close();
    }
}
