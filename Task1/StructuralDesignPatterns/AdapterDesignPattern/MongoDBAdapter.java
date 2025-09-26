package AdapterDesignPattern;

public class MongoDBAdapter implements Database {
    private MongoDB mongoDB;

    public MongoDBAdapter(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public void connect() {
        mongoDB.openConnection();
    }

    @Override
    public void executeQuery(String query) {
        mongoDB.runCommand(query);
    }

    @Override
    public void disconnect() {
        mongoDB.closeConnection();
    }
}
