package commands;

import rover.Rover;
import exceptions.InvalidCommandException;

/** Turn the rover left (90 degrees). */
public class TurnLeftCommand implements Command {
    @Override
    public void execute(Rover rover) throws InvalidCommandException {
        rover.turnLeft();
    }
}
