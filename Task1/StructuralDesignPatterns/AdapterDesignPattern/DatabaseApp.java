package AdapterDesignPattern;

public class DatabaseApp {
    public static void main(String[] args) {
        // Using MySQL
        Database mySQL = new MySQLDatabase();
        mySQL.connect();
        mySQL.executeQuery("SELECT * FROM users");
        mySQL.disconnect();

        System.out.println("\nSwitching to MongoDB using Adapter...\n");

        // Using MongoDB via Adapter
        MongoDB mongo = new MongoDB();
        Database mongoAdapter = new MongoDBAdapter(mongo);
        mongoAdapter.connect();
        mongoAdapter.executeQuery("{ find: 'users' }");
        mongoAdapter.disconnect();
    }
}
