package model;

public class Snake extends Obstacle{
    public Snake() {
        super("Snake", (int) (Math.random() * 3) == 3 ? 6 : 3, 10, 0);
    }
}
