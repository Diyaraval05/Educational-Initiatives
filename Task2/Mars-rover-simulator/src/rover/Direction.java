package rover;

/**
 * Direction interface used by Rover.
 * Each concrete direction class returns dx/dy deltas and next directions for turns.
 */
public interface Direction {
    int dx();
    int dy();
    Direction turnLeft();
    Direction turnRight();
    String getName();
}
