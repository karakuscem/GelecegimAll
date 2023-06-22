import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double res = 0.0;
        String[] vegs = {"Pear", "Apple", "Tomato", "Banana", "Eggplant"};
        double[] prices = {2.14, 3.67, 1.11, 0.95, 5.00};
        int i = 0;
        while (i < vegs.length)
        {
            System.out.println("%s how many KG\n".formatted(vegs[i]));
            res += input.nextInt() * prices[i];
            i++;
        }
        System.out.println("%.2f TL".formatted(res));
        input.close();
    }
}
