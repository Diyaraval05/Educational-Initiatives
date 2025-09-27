import commands.*;
import grid.Grid;
import exceptions.InvalidCommandException;
import exceptions.ObstacleDetectedException;
import report.StatusReport;
import rover.Rover;
import rover.directions.North;

import java.util.Arrays;
import java.util.List;

/**
 * Simple runner. Replace with custom CLI as desired.
 */
public class Main {
    public static void main(String[] args) {
        // create grid, add obstacles
        Grid grid = new Grid(10, 10);
        grid.addObstacle(2, 2);
        grid.addObstacle(3, 5);

        Rover rover = null;
        try {
            rover = new Rover(0, 0, new North(), grid);
        } catch (ObstacleDetectedException e) {
            System.err.println("❌ Cannot place rover: " + e.getMessage());
            return; // exit early
        }

        // commands sequence: M, M, R, M, L, M
        List<Command> commands = Arrays.asList(
                new MoveCommand(),
                new MoveCommand(),
                new TurnRightCommand(),
                new MoveCommand(),
                new TurnLeftCommand(),
                new MoveCommand()
        );

        for (Command cmd : commands) {
            try {
                cmd.execute(rover);
            } catch (InvalidCommandException ice) {
                System.out.println("⚠️ Invalid command: " + ice.getMessage());
            } catch (ObstacleDetectedException ode) {
                System.out.println("⚠️ Obstacle detected: " + ode.getMessage());
            }
        }

        // print final status
        System.out.println(StatusReport.generate(rover));
    }
}
