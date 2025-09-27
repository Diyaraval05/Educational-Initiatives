package commands;

import rover.Rover;
import exceptions.ObstacleDetectedException;
import exceptions.InvalidCommandException;

/** Move one step forward in the rover's current facing direction. */
public class MoveCommand implements Command {
    @Override
    public void execute(Rover rover) throws ObstacleDetectedException, InvalidCommandException {
        rover.moveForward();
    }
}
