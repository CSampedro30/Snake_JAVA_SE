package snake;

public class Snake {
    int[] pos;
    int[] speed;
    String color;
    int size;
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

        int[] nextPos = new int[2];
        nextPos[0] = this.pos[0] + this.speed[0];
        nextPos[1] = this.pos[1] + this.speed[1];
        return nextPos;
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
        if(getNextPosition()[0] == grid.getNRows()) {

        };
    }
}
