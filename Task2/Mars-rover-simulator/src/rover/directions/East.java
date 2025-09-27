package rover.directions;

import rover.Direction;

/** East direction: dx = +1 */
public class East implements Direction {
    @Override public int dx() { return 1; }
    @Override public int dy() { return 0; }
    @Override public Direction turnLeft() { return new North(); }
    @Override public Direction turnRight() { return new South(); }
    @Override public String getName() { return "East"; }
}
