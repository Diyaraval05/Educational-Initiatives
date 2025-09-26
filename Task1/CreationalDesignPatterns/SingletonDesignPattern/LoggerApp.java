package SingletonDesignPattern;

public class LoggerApp {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("INFO", "Logger application started.");
        logger.log("DEBUG", "Performing some operations...");
        logger.log("ERROR", "Something went wrong!");
        logger.log("INFO", "Logger application finished.");
    }
}
