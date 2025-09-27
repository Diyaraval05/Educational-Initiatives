package grid;

/** Obstacle grid cell. */
public class ObstacleCell extends Cell {
    public ObstacleCell(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
