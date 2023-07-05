import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Girilen sayının 4 ve 5'in kuvvetini bulan program
        int num, i = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = input.nextInt();

        while(i <= num)
        {
            if (i % 4 == 0)
                System.out.println(i + " is a power of 4.");
            else if (i % 5 == 0)
                System.out.println(i + " is a power of 5.");
            i++;
        }

        input.close();
    }
}
