import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int km;
        double total = 10, perKm = 2.20;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter KM\n");
        km = input.nextInt();

        total += (km * perKm);
        total = (total < 20) ? 20 : total;
        System.out.println("Total Price: %.2f\n".formatted(total));
        input.close();
    }
}
