package snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    Grid g;

    @BeforeEach
    void setUp() {
        g = new Grid(2, 4);
    }

    @Test
    void getGrid() {
        String[][] gE = {{" ", " ", " ", " "},
                         {" ", " ", " ", " "}};
        String[][] actual = g.getGrid();
        for (int i = 0; i < gE.length; i++) {
            for (int j = 0; j < gE[0].length; j++) {
                assertEquals(gE[i][j], actual[i][j]);
            }
        }
    }

    @Test
    void testToString() {
        assertEquals("+ + + + + + \n" +
                "+         + \n" +
                "+         + \n" +
                "+ + + + + + \n", g.toString());
    }

    @Test
    void pointInsideGrid() {
        assertEquals(false, g.pointInsideGrid(-1, 0));
        assertEquals(false, g.pointInsideGrid(0, -1));
        assertEquals(false, g.pointInsideGrid(3, 3));
    }

    @Test
    void placeObject() {
        g.placeObject(0, 0, "/");
        assertEquals("+ + + + + + \n" +
                "+ /       + \n" +
                "+         + \n" +
                "+ + + + + + \n", g.toString());
        g.placeObject(1, 3, "%");
        assertEquals("+ + + + + + \n" +
                "+ /       + \n" +
                "+       % + \n" +
                "+ + + + + + \n", g.toString());
    }

    @Test
    void dropBlock() {
        g.dropBlock(1, 1);
        assertEquals("+ + + + + + \n" +
                "+         + \n" +
                "+   #     + \n" +
                "+ + + + + + \n", g.toString());
    }

    @Test
    void dropFood() {
        g.dropFood(1, 2);
        assertEquals("+ + + + + + \n" +
                "+         + \n" +
                "+     o   + \n" +
                "+ + + + + + \n", g.toString());

    }


    @Test
    void getNRows() {
        assertEquals(2, g.getNRows());
    }

    @Test
    void getNCols() {
        assertEquals(4, g.getNCols());
    }

    @Test
    void getCell() {
        assertEquals(" ", g.getCell(0, 0));
        g.dropFood(1, 1);
        assertEquals("o", g.getCell(1, 1));
    }


}
