import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double price, kdv = 0.18, originalPrice, kdvPrice;
        System.out.println("Enter original price");
        originalPrice = input.nextDouble();
        kdvPrice = originalPrice * kdv;
        price = originalPrice + kdvPrice;
        System.out.println("Without KDV : %.2f\nKDV Ratio : %.2f\nKDV Price : %.2f\nWith KDV : %.2f\n".formatted(originalPrice, kdv, kdvPrice, price));
        input.close();
    }
}
