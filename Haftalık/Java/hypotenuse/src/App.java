import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int a, b;
        double c;
        System.out.println("Enter A value.\n");
        a = input.nextInt();
        System.out.println("Enter B value.\n");
        b = input.nextInt();

        c = Math.sqrt((a * a) + (b * b));
        System.out.println("C = %.2f".formatted(c));
        input.close();
    }
}
