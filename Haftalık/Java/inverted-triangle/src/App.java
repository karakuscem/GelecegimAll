import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int height;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        height = input.nextInt();

        for(int line = height; line >= 1; line--)
        {
            for(int space = 0; space < height - line; space++)
                System.out.print(" ");
            for(int star = 0; star < (2 * line) - 1; star++)
                System.out.print("*");
            System.out.println();
        }
        input.close();
    }
}
