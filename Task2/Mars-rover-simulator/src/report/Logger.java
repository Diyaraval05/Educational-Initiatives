package report;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

/**
 * Small centralized logger wrapper.
 * Use report.Logger.getLogger() to obtain a configured java.util.logging.Logger instance.
 */
public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("MarsRover");

    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.INFO); // change to FINE for more verbose logs
    }

    public static java.util.logging.Logger getLogger() {
        return logger;
    }
}
