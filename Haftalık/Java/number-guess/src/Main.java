import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int num = (int) (Math.random() * 100);
        int right = 5;



        while (right > 0)
        {
            System.out.println("Enter a number ");
            int selected = input.nextInt();
            if (selected < 0 || selected > 99)
            {
                System.out.println("Please enter a number between 0 and 100");
            } else {
                if (selected == num)
                {
                    System.out.println("Congratz you win");
                    break;
                }
                else {
                    System.out.println("Wrong number, try again!");
                    right--;
                }
            }
        }
        System.out.println("You lost number was " + num);
    }
}