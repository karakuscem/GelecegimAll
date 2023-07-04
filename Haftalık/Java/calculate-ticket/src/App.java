import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int distance, age, travelType;
        double pricePerKm = 0.10, totalPrice;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance: ");
        distance = input.nextInt();
        if (distance < 0) {
            input.close();
            throw new Exception("Distance must be positive");
            
        }

        System.out.print("Enter age: ");
        age = input.nextInt();
        if (age < 0) {
            input.close();
            throw new Exception("Age must be positive");
        }

        System.out.print("Enter travel type (1: One way, 2: Round trip): ");
        travelType = input.nextInt();
        if (travelType != 1 || travelType != 2) {
            input.close();
            throw new Exception("Travel type must be 1 or 2");
        }


        totalPrice = distance * pricePerKm;
        if (age < 12) {
            totalPrice *= 0.5;
        } else if (age > 60) {
            totalPrice *= 0.7;
        } else if (age > 12 && age < 24) {
            totalPrice *= 0.9;
        } else if (travelType == 2) {
            totalPrice *= 0.8;
        } else {
            totalPrice *= 1;
        }

        System.out.println("Total price: " + totalPrice);

        input.close();
    }
}
