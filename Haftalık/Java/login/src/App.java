import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String userName, password;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username: ");
        userName = input.nextLine();
        System.out.println("Enter your password: ");
        password = input.nextLine();
        if (userName.equals("admin") && password.equals("admin")) {
            System.out.println("Welcome to the system!");
        } else {
            System.out.println("Wrong username or password!");
        }
        input.close();
    }
}
