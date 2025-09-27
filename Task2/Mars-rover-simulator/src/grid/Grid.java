package grid;

import rover.Rover;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Grid holds cells (Empty / Obstacle) and tracks rover positions.
 * Thread-safe modifications for rovers are provided via synchronized methods.
 */
public class Grid {
    private final int width;
    private final int height;
    private final Map<String, Cell> cells = new HashMap<>();
    private final Map<String, Rover> rovers = new HashMap<>();
    private final Set<String> obstacleKeys = new HashSet<>();

    public Grid(int width, int height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Grid size must be positive.");
        this.width = width;
        this.height = height;

        // initialize empty cells
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells.put(key(x, y), new EmptyCell(x, y));
            }
        }
    }

    public boolean addObstacle(int x, int y) {
        if (!isValid(x, y)) return false;
        String k = key(x, y);
        cells.put(k, new ObstacleCell(x, y));
        obstacleKeys.add(k);
        return true;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean isObstacle(int x, int y) {
        if (!isValid(x, y)) return true; // treat out-of-bounds as obstacle/invalid
        return obstacleKeys.contains(key(x, y));
    }

    /**
     * Place a rover at x,y if target cell is empty and not occupied by another rover.
     * Returns true if placed successfully.
     */
    public synchronized boolean addRover(Rover rover, int x, int y) {
        if (!isValid(x, y)) return false;
        String k = key(x, y);
        if (obstacleKeys.contains(k)) return false;
        if (rovers.containsKey(k)) return false;
        rovers.put(k, rover);
        return true;
    }

    /**
     * Move a rover from its current coordinates to new coordinates if possible.
     * Returns true if move succeeded.
     */
    public synchronized boolean moveRover(Rover rover, int newX, int newY) {
        if (!isValid(newX, newY)) return false;
        String newKey = key(newX, newY);
        if (obstacleKeys.contains(newKey)) return false;
        if (rovers.containsKey(newKey)) return false; // another rover occupies
        String oldKey = key(rover.getX(), rover.getY());
        // remove old mapping (if present) and put new mapping
        rovers.remove(oldKey);
        rovers.put(newKey, rover);
        return true;
    }

    private String key(int x, int y) { return x + "," + y; }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
