package model;

public abstract class BattleLocation extends Location{
    private Obstacle obstacle;
    private boolean isCompleted;
    private int obNum;

    public BattleLocation(Player player, Obstacle obstacle, String name, int obNum) {
        super(player, name);
        this.obstacle = obstacle;
        this.isCompleted = false;
        this.obNum = obNum;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getObNum() {
        return obNum;
    }

    public void setObNum(int obNum) {
        this.obNum = obNum;
    }

}
