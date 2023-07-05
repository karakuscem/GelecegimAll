import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int n, k, total = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();
        System.out.print("Enter k: ");
        k = input.nextInt();

        for (int i = 1; i <= k; i++)
            total *= n;
        System.out.println(n + "^" + k + " = " + total);

        input.close();
    }
}
