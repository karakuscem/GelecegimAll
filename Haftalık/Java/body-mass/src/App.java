import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        double res, height, weight;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your height (in meter).\n");
        height = input.nextDouble();
        System.out.println("Enter your weight.\n");
        weight = input.nextDouble();
        res = weight / (height * height);
        System.out.println(res);
        input.close();
    }
}
