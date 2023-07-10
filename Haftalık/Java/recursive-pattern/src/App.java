import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int temp = n;
        recursiveMethod(n, temp, true);
        input.close();
    }

    public static void recursiveMethod(int num, int temp, boolean flag) {
        System.out.print(num + " ");
        if (num <= 0 || flag == false){
            flag = false;
            if (num != temp){
                recursiveMethod(num + 5, temp, flag);
            } else {
                return ;
            }
        } else
            recursiveMethod(num - 5, temp, flag);
    }
}
