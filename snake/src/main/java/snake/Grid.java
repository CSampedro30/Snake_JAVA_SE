package snake;

import java.util.Arrays;

public class Grid {
    private String[][] grid;
    private int nRows;
    private int nCols;
    int[][] intGrid;

    public Grid(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.grid = new String[nRows][nCols];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                grid[r][c] = " ";
            }
        }
        this.intGrid = genIntGrid();
    }

    @Override
    public String toString() {
        String out = "";
        out += "+ ".repeat(nCols + 2) + "\n";
        for (int r = 0; r < nRows; r++) {
            out += "+ ";
            for (int c = 0; c < nCols; c++) {
                out += grid[r][c] + " ";
            }
            out += "+ \n";
        }
        out += "+ ".repeat(nCols + 2) + "\n";
        return out;
    }

    public boolean pointInsideGrid(int y, int x) {
        return y >= 0 && y < nRows && x >= 0 && x < nCols;
    }

    public void placeObject(int y, int x, String o) {
        if (pointInsideGrid(y, x)) {
            grid[y][x] = o;
        } else {
            System.out.println("Object is out of bounds");
        }
    }

    public void dropBlock(int y, int x) {
        placeObject(y, x, "#");
    }

    public void dropFood(int y, int x) {
        placeObject(y, x, "o");
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getNRows() {
        return nRows;
    }

    public int getNCols() {
        return nCols;
    }

    public String getCell(int y, int x) {
        return grid[y][x];
    }

    public void updateGrid(Snake snake) {
        int y = snake.getPos()[0];
        int x = snake.getPos()[1];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (getCell(i, j).equals("*")) {
                    grid[i][j] = " ";
                }
            }
        }
        if (snake.isAlive()) {
            grid[y][x] = "*";
        }
    }

    public int[][] genIntGrid() {
        int[][] genGrid = new int[nRows][nCols];
        return genGrid;
    }

    public void decrIntGrid() {
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                if (intGrid[r][c] > 0) {
                    intGrid[r][c] -= 1;
                }
            }
        }
    }

    public void updateGrids(Snake snake) {
        int y = snake.getPos()[0];
        int x = snake.getPos()[1];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (getCell(i, j).equals("*")) {
                    grid[i][j] = " ";
                }
            }
        }
        if (snake.isAlive()) {
            intGrid[y][x] = snake.getSize();
        }
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                if (intGrid[r][c] > 0) {
                    grid[y][x] = "*";
                }
            }
        }
        decrIntGrid();
    }
}
