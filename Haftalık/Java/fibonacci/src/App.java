import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int n = 10;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        input.close();
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
