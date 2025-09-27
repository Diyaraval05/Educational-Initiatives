package report;

import rover.Rover;

/** Simple status reporter for console-friendly output. */
public class StatusReport {
    public static String generate(Rover rover) {
        return "Rover is at (" + rover.getX() + "," + rover.getY() + ") facing " + rover.getDirection().getName();
    }
}
