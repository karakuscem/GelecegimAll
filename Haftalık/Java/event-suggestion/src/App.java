import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int heat;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the heat: ");
        heat = input.nextInt();

        if (heat < 5)
            System.out.println("You should do skiing");
        else if (heat >= 5 && heat < 15)
            System.out.println("You should do cinema");
        else if (heat >= 15 && heat < 25)
            System.out.println("You should do picnic");
        else if (heat >= 25 && heat < 35)
            System.out.println("You should do swimming");
        else
            System.out.println("You should do sleeping");
        input.close();
    }
}
