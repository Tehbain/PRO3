package KrydsOgSisyphos;

public class KrydsOgSisyphos {
    public static void main(String[] args) {
        Board board = new Board();
        board.printGridState();
    }
}

class Board {
    public Board() {
        initGrid();
    }

    private String[][] grid = new String[5][5];

    private void initGrid() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = "+";
            }
        }

        grid[0][0] = "+";
        grid[0][1] = "-";
        grid[0][2] = "-";
        grid[0][3] = "-";
        grid[0][4] = "+";
    }

    void printGridState() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}