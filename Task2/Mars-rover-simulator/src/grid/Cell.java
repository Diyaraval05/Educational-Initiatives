package grid;

/** Base component for composite grid cell. */
public abstract class Cell {
    protected final int x;
    protected final int y;

    protected Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract boolean isObstacle();

    public int getX() { return x; }
    public int getY() { return y; }
}
