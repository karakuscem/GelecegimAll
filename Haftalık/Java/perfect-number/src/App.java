import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int num;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        num = input.nextInt();
        if (findPerfectNum(num) == 1)
            System.out.println(num + " is a perfect number.");
        else
            System.out.println(num + " is not a perfect number.");

        input.close();
    }

    public static int findPerfectNum(int num)
    {
        int sum = 0;
        for (int i = 1; i < num; i++)
            if (num % i == 0)
                sum += i;
        if (sum == num)
            return 1;
        else
            return 0;
    }
}
