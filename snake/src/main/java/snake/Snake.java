package snake;

public class Snake {
    private int[] pos;
    int[] speed;
    String color;
    private int size;
    boolean alive;

    Snake(int[] pos, int[] speed, String color) {
        this.pos = pos;
        this.speed = speed;
        this.color = color;
        this.alive = true;
        this.size = 1;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void killSnake() {
        this.alive = false;
    }

    public int[] getNextPosition() {

        int[] nextPosition = new int[2];
        nextPosition[0] = this.pos[0] + this.speed[0];
        nextPosition[1] = this.pos[1] + this.speed[1];
        return nextPosition;
    }

    public void turnRight() {
        if (this.speed[0] == 0 && this.speed[1] == 1) {
            this.speed[0] = 1;
            this.speed[1] = 0;
        } else if (this.speed[0] == 1 && this.speed[1] == 0) {
            this.speed[0] = 0;
            this.speed[1] = -1;
        } else if (this.speed[0] == 0 && this.speed[1] == -1) {
            this.speed[0] = -1;
            this.speed[1] = 0;
        } else {
            this.speed[0] = 0;
            this.speed[1] = 1;
        }
    }

    public void turnLeft() {
        if (this.speed[0] == 0 && this.speed[1] == 1) {
            this.speed[0] = -1;
            this.speed[1] = 0;
        } else if (this.speed[0] == -1 && this.speed[1] == 0) {
            this.speed[0] = 0;
            this.speed[1] = -1;
        } else if (this.speed[0] == 0 && this.speed[1] == -1) {
            this.speed[0] = 1;
            this.speed[1] = 0;
        } else {
            this.speed[0] = 0;
            this.speed[1] = 1;
        }
    }

    public int[] getPos() {
        return this.pos;
    }

    public int getSize() {
        return this.size;
    }

    public void moveOn(Grid grid) {

        if (getNextPosition()[0] == grid.getNRows()) {
            this.pos[0] = 0;
        } else if (getNextPosition()[0] < 0) {
            this.pos[0] = grid.getNRows() - 1;
        } else if (getNextPosition()[1] == grid.getNCols()) {
            this.pos[1] = 0;
        } else if (getNextPosition()[1] < 0) {
            this.pos[1] = grid.getNCols() - 1;
        } else {
            this.pos[0] = getNextPosition()[0];
            this.pos[1] = getNextPosition()[1];
        }

        if (grid.getCell(pos[0], pos[1]).equals("#") || grid.getCell(pos[0], pos[1]).equals("*")) {
            killSnake();
        } else if (grid.getCell(pos[0], pos[1]).equals("o")) {
            size++;
        }
    }
}
