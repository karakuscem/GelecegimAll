import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        double Math, Physics, Turkish, Chemistry, Music, Average;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter your Math grade: ");
        Math = inputScanner.nextDouble();
        if (Math < 0 || Math > 100)
            Math = 0;

        System.out.println("Enter your Physics grade: ");
        Physics = inputScanner.nextDouble();
        if (Physics < 0 || Physics > 100)
            Physics = 0;

        System.out.println("Enter your Turkish grade: ");
        Turkish = inputScanner.nextDouble();
        if (Turkish < 0 || Turkish > 100)
            Turkish = 0;

        System.out.println("Enter your Chemistry grade: ");
        Chemistry = inputScanner.nextDouble();
        if (Chemistry < 0 || Chemistry > 100)
            Chemistry = 0;

        System.out.println("Enter your Music grade: ");
        Music = inputScanner.nextDouble();
        if (Music < 0 || Music > 100)
            Music = 0;

        Average = (Math + Physics + Turkish + Chemistry + Music) / 5;
        System.out.println("Your average is: " + Average);
        if (Average < 55)
            System.out.println("You failed!");
        else
            System.out.println("You passed!");
        inputScanner.close();
    }
}
