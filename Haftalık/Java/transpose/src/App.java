public class App {
    public static void main(String[] args) throws Exception {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] transpose = new int[3][2];

        System.out.println("Matrix before transpose");
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
                transpose[j][i] = arr[i][j];
            }
            System.out.println();
        }

        System.out.println("Matrix after transpose");
        for(int i = 0; i < transpose.length; i++){
            for (int j = 0; j < transpose[i].length; j++)
            {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

    }
}
