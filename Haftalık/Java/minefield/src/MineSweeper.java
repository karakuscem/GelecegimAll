import java.util.Objects;
import java.util.Scanner;

public class MineSweeper {

    int rowNum;

    int colNum;

    int mineNum;

    boolean isWin = false;

    public MineSweeper(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.mineNum = (rowNum * colNum) / 4;
    }

    public String[][] createMap(int rowNum, int colNum) {
        String[][] map = new String[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                map[i][j] = "-";
            }
        }
        return map;
    }

    public String[][] createMines(String[][] map, int mineNum) {
        while (mineNum != 0) {
            int randomRow = (int) (Math.random() * map.length);
            int randomCol = (int) (Math.random() * map[0].length);
            map[randomRow][randomCol] = "*";
            mineNum--;
        }
        return map;
    }

    public void printMap(String[][] map) {
        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public void printEndGameMap(String[][] map, String[][] mapWithMines) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!Objects.equals(mapWithMines[i][j], "*"))
                    System.out.print(map[i][j]);
                else
                    System.out.print(mapWithMines[i][j]);
            }
            System.out.println();
        }
    }

    public int checkMines(String[][] mapWithMines, int playerX, int playerY) {
        int totalMines = 0;
        int rows = mapWithMines.length;
        int columns = mapWithMines[0].length;

        if (isValidIndex(playerX - 1, playerY, rows, columns) && Objects.equals(mapWithMines[playerX - 1][playerY], "*"))
            totalMines++;
        if (isValidIndex(playerX + 1, playerY, rows, columns) && Objects.equals(mapWithMines[playerX + 1][playerY], "*"))
            totalMines++;
        if (isValidIndex(playerX, playerY - 1, rows, columns) && Objects.equals(mapWithMines[playerX][playerY - 1], "*"))
            totalMines++;
        if (isValidIndex(playerX, playerY + 1, rows, columns) && Objects.equals(mapWithMines[playerX][playerY + 1], "*"))
            totalMines++;
        if (isValidIndex(playerX + 1, playerY + 1, rows, columns) && Objects.equals(mapWithMines[playerX + 1][playerY + 1], "*"))
            totalMines++;
        if (isValidIndex(playerX - 1, playerY - 1, rows, columns) && Objects.equals(mapWithMines[playerX - 1][playerY - 1], "*"))
            totalMines++;
        if (isValidIndex(playerX + 1, playerY - 1, rows, columns) && Objects.equals(mapWithMines[playerX + 1][playerY - 1], "*"))
            totalMines++;
        if (isValidIndex(playerX - 1, playerY + 1, rows, columns) && Objects.equals(mapWithMines[playerX - 1][playerY + 1], "*"))
            totalMines++;
        return totalMines;
    }

    private boolean isValidIndex(int x, int y, int rows, int columns) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }


    public boolean checkWin(String[][] map) {
        int totalSpaces = (rowNum * colNum) - mineNum;
        int playerMoves = 0;

        for (String[] strings : map) {
            for (String string : strings)
                if (!Objects.equals(string, "*") && !Objects.equals(string, "-"))
                    playerMoves++;
        }
        System.out.println(playerMoves);
        System.out.println(totalSpaces);
        return playerMoves == totalSpaces;
    }

    public void run() {
        String[][] originalMap = createMap(rowNum, colNum);
        String[][] mapWithMines = createMines(createMap(rowNum, colNum), mineNum);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the game");
        System.out.println("You should enter x and y coordinates");
        while (!isWin) {

            int playerX;
            int playerY;

            while (true) {
                System.out.print("Enter X: ");
                playerX = input.nextInt() - 1;
                System.out.print("Enter Y: ");
                playerY = input.nextInt() - 1;
                if (playerX > rowNum || playerX < 0) {
                    System.out.println("You should enter valid X num.");
                } else if (playerY > colNum || playerY < 0) {
                    System.out.println("You should enter valid Y num");
                } else
                    break;
            }

            if (Objects.equals(mapWithMines[playerX][playerY], "*")) {
                System.out.println("Game Over!");
                printEndGameMap(originalMap, mapWithMines);
                isWin = true;
            } else {
                originalMap[playerX][playerY] = String.valueOf(checkMines(mapWithMines, playerX, playerY));
                printMap(originalMap);
                if (checkWin(originalMap))
                {
                    System.out.println("You win!");
                    printEndGameMap(originalMap, mapWithMines);
                    isWin = true;
                }
            }

        }
    }
}
