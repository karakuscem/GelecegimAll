import java.util.Scanner;

public class App {

    public static int getDigit(int num)
    {
        return num % 10;
    }

    public static void main(String[] args) throws Exception {
        int num;
        int sum = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = input.nextInt();

        while(num != 0)
        {
            sum += getDigit(num);
            num /= 10;
        }

        System.out.println("Sum is: " + sum);

        input.close();
    }
}
