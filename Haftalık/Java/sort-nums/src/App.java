import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int num1, num2, num3;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        num1 = input.nextInt();
        System.out.println("Enter the second number: ");
        num2 = input.nextInt();
        System.out.println("Enter the third number: ");
        num3 = input.nextInt();
        if (num1 > num2 && num1 > num3)
        {
            if (num2 > num3)
                System.out.println("The numbers in ascending order are: " + num3 + " " + num2 + " " + num1);
            else
                System.out.println("The numbers in ascending order are: " + num2 + " " + num3 + " " + num1);
        }
        else if (num2 > num1 && num2 > num3)
        {
            if (num1 > num3)
                System.out.println("The numbers in ascending order are: " + num3 + " " + num1 + " " + num2);
            else
                System.out.println("The numbers in ascending order are: " + num1 + " " + num3 + " " + num2);
        }
        else if (num3 > num1 && num3 > num2)
        {
            if (num1 > num2)
                System.out.println("The numbers in ascending order are: " + num2 + " " + num1 + " " + num3);
            else
                System.out.println("The numbers in ascending order are: " + num1 + " " + num2 + " " + num3);
        }
        else
            System.out.println("The numbers are equal.");
        input.close();
    }
}
