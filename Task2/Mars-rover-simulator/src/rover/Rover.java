package rover;

import grid.Grid;
import exceptions.ObstacleDetectedException;

import java.util.logging.Level;

/**
 * Rover holds position + facing Direction and interacts with Grid.
 * All move operations validate via Grid before committing position updates.
 */
public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private final Grid grid;

    private final java.util.logging.Logger logger = report.Logger.getLogger();

    public Rover(int x, int y, Direction direction, Grid grid) throws ObstacleDetectedException {
        this.grid = grid;
        // try place on grid (ensures position is free and not an obstacle)
        if (!grid.addRover(this, x, y)) {
            throw new ObstacleDetectedException("Cannot place rover at (" + x + "," + y + "). Position blocked or occupied.");
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
        logger.log(Level.INFO, "Rover placed at (" + x + "," + y + ") facing " + direction.getName());
    }

    /**
     * Move forward one cell after validation.
     */
    public synchronized void moveForward() throws ObstacleDetectedException {
        int nextX = this.x + direction.dx();
        int nextY = this.y + direction.dy();

        if (!grid.isValid(nextX, nextY)) {
            throw new ObstacleDetectedException("Out of bounds move attempted to (" + nextX + "," + nextY + ").");
        }
        if (grid.isObstacle(nextX, nextY)) {
            throw new ObstacleDetectedException("Obstacle detected at (" + nextX + "," + nextY + "). Move aborted.");
        }

        // attempt to move in grid (also checks other rovers)
        boolean moved = grid.moveRover(this, nextX, nextY);
        if (!moved) {
            throw new ObstacleDetectedException("Target cell (" + nextX + "," + nextY + ") occupied by another rover.");
        }
        // update local coordinates only after grid.moveRover success
        this.x = nextX;
        this.y = nextY;

        logger.info("Rover moved to (" + x + "," + y + ")");
    }

    public synchronized void turnLeft() {
        this.direction = direction.turnLeft();
        logger.info("Turned left. Now facing " + direction.getName());
    }

    public synchronized void turnRight() {
        this.direction = direction.turnRight();
        logger.info("Turned right. Now facing " + direction.getName());
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Direction getDirection() { return direction; }

    // setters used by Grid only if necessary (not exposing publicly to avoid misuse)
    void setPositionInternal(int x, int y) { this.x = x; this.y = y; }
}
