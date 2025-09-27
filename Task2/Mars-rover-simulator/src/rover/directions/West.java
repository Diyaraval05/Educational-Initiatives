package rover.directions;

import rover.Direction;

/** West direction: dx = -1 */
public class West implements Direction {
    @Override public int dx() { return -1; }
    @Override public int dy() { return 0; }
    @Override public Direction turnLeft() { return new South(); }
    @Override public Direction turnRight() { return new North(); }
    @Override public String getName() { return "West"; }
}
