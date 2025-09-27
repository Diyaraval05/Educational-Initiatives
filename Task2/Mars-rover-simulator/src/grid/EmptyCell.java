package grid;

/** Empty grid cell (no obstacle). */
public class EmptyCell extends Cell {
    public EmptyCell(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isObstacle() {
        return false;
    }
}
