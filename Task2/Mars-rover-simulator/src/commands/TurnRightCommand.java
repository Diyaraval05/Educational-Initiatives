package commands;

import rover.Rover;
import exceptions.InvalidCommandException;

/** Turn the rover right (90 degrees). */
public class TurnRightCommand implements Command {
    @Override
    public void execute(Rover rover) throws InvalidCommandException {
        rover.turnRight();
    }
}
