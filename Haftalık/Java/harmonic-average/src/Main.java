import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Array length");
        int num = input.nextInt();

        double[] arr = new double[num];
        System.out.println("Array elements: ");
        for (int i = 0; i < num; i++){
            arr[i] = input.nextDouble();
        }

        double res = 0.0;
        for (int i = 0; i < num; i++)
        {
            res += 1.0 / arr[i];
        }

        double average = num / res;
        System.out.println("Harmonic average " + average);
    }
}