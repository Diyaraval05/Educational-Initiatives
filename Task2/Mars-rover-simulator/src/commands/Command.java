package commands;

import rover.Rover;
import exceptions.InvalidCommandException;
import exceptions.ObstacleDetectedException;

/**
 * Command interface for the Command Pattern.
 * Each concrete command (Move, TurnLeft, TurnRight) implements this.
 */
public interface Command {
    void execute(Rover rover) throws InvalidCommandException, ObstacleDetectedException;
}
