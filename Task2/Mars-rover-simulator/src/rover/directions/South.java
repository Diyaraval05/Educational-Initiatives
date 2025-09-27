package rover.directions;

import rover.Direction;

/** South direction: dy = -1 */
public class South implements Direction {
    @Override public int dx() { return 0; }
    @Override public int dy() { return -1; }
    @Override public Direction turnLeft() { return new East(); }
    @Override public Direction turnRight() { return new West(); }
    @Override public String getName() { return "South"; }
}
