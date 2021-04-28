import snake.Grid;

public class Main {
    public static void main(String[] args) {
        Grid g1 = new Grid(10, 10);
        g1.dropBlock(5, 5);
        g1.dropFood(1, 3);
        System.out.println(g1);
    }
}
