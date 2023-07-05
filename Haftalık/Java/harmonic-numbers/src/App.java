import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int num;
        double res = 0.0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = input.nextInt();

        for (double i = 1; i <= num; i++)
            res += (1/i);

        System.out.println(res);

        input.close();
    }
}
