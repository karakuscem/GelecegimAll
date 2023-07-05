import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int number, i = 0, sum = 0, average = 0, count = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        number = input.nextInt();

        while(i <= number)
        {
            if (i % 3 == 0 && i % 4 == 0)
            {
                sum += i;
                count++;
            }
            i++;
        }

        average = sum / count;
        System.out.println("The average is: " + average);

        input.close();
    }
}
