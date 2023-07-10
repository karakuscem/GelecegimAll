import java.math.BigDecimal;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", new BigDecimal(2000), 45, 1985);
        Employee employee2 = new Employee("Kemal XYZ", new BigDecimal(1000), 35, 2002);
        System.out.println(employee);
        System.out.println("**********************");
        System.out.println(employee2);
    }
}