import java.util.Scanner;

public class App {
    public static long findFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * (long) i;
        }
        return fact;
    }

    public static long findCombination(int n, int r) {
        long factN = findFactorial(n);
        long factR = findFactorial(r);
        long factNR = findFactorial(n - r);
        long nCr = factN / (factR * factNR);
        return nCr;
    }
    public static void main(String[] args) throws Exception {
        int n, r;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = input.nextInt();
        if (n < 0) {
            input.close();
            System.out.println("n must be a positive integer");
            System.exit(0);
        }
        System.out.println("Enter the value of r: ");
        r = input.nextInt();
        if (r < 0) {
            input.close();
            System.out.println("r must be a positive integer");
            System.exit(0);
        }
        long nCr = findCombination(n, r);
        System.out.println("The value of " + n + "C" + r + " is " + nCr);
    }
}
