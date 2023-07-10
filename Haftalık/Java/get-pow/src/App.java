import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int number, power;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = input.nextInt();
        System.out.print("Enter a power: ");
        power = input.nextInt();

        System.out.println(number + " ^ " + power + " = " + power(number, power));

        input.close();
    }

    public static int power(int number, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }
}
