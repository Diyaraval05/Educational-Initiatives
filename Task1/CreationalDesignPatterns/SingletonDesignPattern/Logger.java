package SingletonDesignPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static Logger instance;
    private static final String LOG_FILE = "application.log";

    
    private Logger() {}

    
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    
    public void log(String level, String message) {
        String logMessage = "[" + LocalDateTime.now() + "] [" + level + "] " + message;

        
        System.out.println(logMessage);

        
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(logMessage + "\n");
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }
}
