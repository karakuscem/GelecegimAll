import java.util.Scanner;

public class App {

    public static int findDigitNum(int num)
    {
        int digitNum = 0;
        while (num != 0)
        {
            num /= 10;
            digitNum++;
        }
        return digitNum;
    }

    public static int getDigit(int num)
    {
            return num % 10;
    }

    public static int getPow(int num, int pow)
    {
        int temp = num;
        for(int i = 1; i < pow; i++)
            num *= temp;
        return num;
    }
    public static void main(String[] args) throws Exception {
        int digitNumber;
        int inputNumber;
        int individualDigit;
        int tempInput;
        int sum = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        inputNumber = input.nextInt();
        tempInput = inputNumber;

        digitNumber = findDigitNum(inputNumber);
        while (tempInput != 0)
        {
            individualDigit = getDigit(tempInput);
            sum += getPow(individualDigit, digitNumber);
            tempInput /= 10;
        }
        if (sum == inputNumber)
            System.out.println(inputNumber + " is Armstrong number.");
        else
            System.out.println(inputNumber + " is not Armstrong number.");

        input.close();
    }
}
