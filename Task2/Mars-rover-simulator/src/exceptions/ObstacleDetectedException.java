package exceptions;

/** Thrown when a move would collide with an obstacle, another rover, or be out-of-bounds. */
public class ObstacleDetectedException extends Exception {
    public ObstacleDetectedException(String message) {
        super(message);
    }
}
