package AdapterDesignPattern;

// Target interface expected by the application
public interface Database {
    void connect();
    void executeQuery(String query);
    void disconnect();
}
