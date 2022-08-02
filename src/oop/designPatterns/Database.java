public class Database {

    private static Database instance;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            System.out.println("Creating Database...");

            try {
                // Simulate some heavy work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            instance = new Database();
        }

        return instance;
    }

    public <T> void create(T object) {
        System.out.println("Saving in database " + object.toString());
    }


}
