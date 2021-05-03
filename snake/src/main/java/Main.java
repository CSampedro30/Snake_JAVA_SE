import org.json.simple.JSONObject;
import snake.Grid;
import snake.Snake;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] pos = {0, 0};
        int[] speed = {0, 1};
        Grid g = new Grid(10, 20);
        Snake s = new Snake(pos, speed, "red");
        g.dropBlock(8, 8);
        g.dropFood(5, 4);
        g.dropFood(6, 4);
        g.dropFood(7, 4);
        g.dropFood(8, 4);
        g.dropFood(8, 5);
        g.dropFood(8, 6);
        g.dropFood(8, 7);
        int counter = 0;
        while (s.isAlive()) {
            if (counter == 3 || counter == 20 || counter == 22 || counter == 24 || counter == 26) {
                s.turnRight();
            } else if (counter == 11 || counter == 14 || counter == 16 || counter == 18 || counter == 28) {
                s.turnLeft();
            }
            s.moveOn(g);
            g.updateGrids(s);
            Thread.sleep(500);
            System.out.println(g);
            if (!s.isAlive()) {
                System.out.println("--------------------------------You died--------------------------------");
            }
            counter++;
        }
        System.out.println(s.getSize());


        JSONObject obj = new JSONObject();
        obj.put("name", "Bobby");
        obj.put("size", s.getSize());
        obj.put("Nb of turns", counter);

        try (FileWriter file = new FileWriter("snake.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
    }
}

