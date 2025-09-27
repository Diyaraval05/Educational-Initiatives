package rover.directions;

import rover.Direction;

/** North direction: dy = +1 */
public class North implements Direction {
    @Override public int dx() { return 0; }
    @Override public int dy() { return 1; }
    @Override public Direction turnLeft() { return new West(); }
    @Override public Direction turnRight() { return new East(); }
    @Override public String getName() { return "North"; }
}
