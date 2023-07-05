import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int n;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        n = input.nextInt();

        int star = 1;
        int space = n - 1;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < space; j++)
                System.out.print(" ");
            for (int x = 0; x < star; x++)
                System.out.print("*");
            System.out.println("");
            space--;
            star += 2;
        }
        for (int y = 0; y < n; y++)
        {
            for (int u = 0; u < space + 1; u++)
                System.out.print(" ");
            for (int t = 0; t < star - 2; t++)
                System.out.print("*");
            System.out.println("");
            space++;
            star -= 2;
        }

        input.close();
    }
}
