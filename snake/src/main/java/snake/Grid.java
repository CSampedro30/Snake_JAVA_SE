package snake;

import java.util.Arrays;

public class Grid {
    private String[][] grid;
    private int nRows;
    private int nCols;

    public Grid(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.grid = new String[nRows][nCols];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                grid[r][c] = " ";
            }
        }
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


}
