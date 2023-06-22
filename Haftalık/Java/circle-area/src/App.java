import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double yariCap;
        double pi = 3.14;
        System.out.print("Yarıçapı giriniz: ");
        yariCap = input.nextDouble();
        System.out.println("Çevre: " + (2 * pi * yariCap));
        System.out.println("Alan: " + (pi * yariCap * yariCap));
        input.close();
    }
}
