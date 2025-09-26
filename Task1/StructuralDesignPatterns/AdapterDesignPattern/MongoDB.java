package AdapterDesignPattern;

// Incompatible interface (legacy or third-party library)
public class MongoDB {
    public void openConnection() {
        System.out.println("Connected to MongoDB");
    }

    public void runCommand(String command) {
        System.out.println("Running MongoDB command: " + command);
    }

    public void closeConnection() {
        System.out.println("Disconnected from MongoDB");
    }
}
