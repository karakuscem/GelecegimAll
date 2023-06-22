import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int firstNum, secondNum, operation;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number: ");
        firstNum = input.nextInt();
        System.out.println("Enter second number: ");
        secondNum = input.nextInt();
        System.out.println("Select operation:\n1-Add\n2-Subtract\n3-Multiply\n4-Divide\n");
        operation = input.nextInt();

        switch (operation) {
            case 1:
                System.out.println("Result: " + (firstNum + secondNum));
                break;
            case 2:
                System.out.println("Result: " + (firstNum - secondNum));
                break;
            case 3:
                System.out.println("Result: " + (firstNum * secondNum));
                break;
            case 4:
                System.out.println("Result: " + (firstNum / secondNum));
                break;
        }
        input.close();
    }
}
