import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int num = 0, sum = 0;

        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Enter a number: ");
            num = input.nextInt();
            if (num % 2 == 0 && num % 4 == 0)
                sum += num;
        } while (num % 2 == 0);

        System.out.println("Sum = " + sum);
        input.close();
    }
}
