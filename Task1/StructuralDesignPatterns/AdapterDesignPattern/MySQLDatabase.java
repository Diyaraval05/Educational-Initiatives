package AdapterDesignPattern;

public class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL Database");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL Query: " + query);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from MySQL Database");
    }
}
