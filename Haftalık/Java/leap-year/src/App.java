import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int year;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a year: ");
        year = in.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if(year % 400 == 0) {
                    System.out.println(year + " is a leap year.");
                }
                else {
                    System.out.println(year + " is not a leap year.");
                }
            }
            else {
                System.out.println(year + " is a leap year.");
            }
        }
        else {
            System.out.println(year + " is not a leap year.");
        }

        in.close();
    }
}
