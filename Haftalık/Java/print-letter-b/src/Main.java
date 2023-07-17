import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int height = input.nextInt();
        int wid = input.nextInt();
        String[][] letter = new String[height][wid];

        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                if (i == 0 || i == Math.round((float) (letter[i].length) / 2) || i == letter[i].length - 1)
                    letter[i][j] = "*";
                else if (j == 0 || j == letter[i].length - 1)
                    letter[i][j] = "*";
                else
                    letter[i][j] = " ";
            }
        }

        for (String[] row : letter){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
}