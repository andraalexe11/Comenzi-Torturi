import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;



public class JDBC {

    private static final String JDBC_URL =
            "jdbc:sqlite:src/test.db";

    private Connection conn = null;

    /**
     * Gets a connection to the database.
     * If the underlying connection is closed, it creates a new connection. Otherwise, the current instance is returned.
     */
    private void openConnection() {
        try {
            // with DriverManager
//            if (conn == null || conn.isClosed())
//                conn = DriverManager.getConnection(JDBC_URL);

            // with DataSource
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the underlying connection to the in-memory SQLite instance.
     */
    private void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the sample schema for the database.
     */
    void createSchema() {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS cakes(id int, typecake varchar(50));");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS orders(id int, dateorder date, cakes varchar(250));");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    /**
     * Adds some entries in the table books;
     */
    void initTables() {
        final String[] cakes = new String[]{
                "1|Ciocolata",
                "2|Vanilie",
                "3|Fructe"
        };

        try {
            try (PreparedStatement statement = conn.prepareStatement("INSERT INTO cakes VALUES (?, ?, ?)")) {
                for (String s : cakes) {
                    String[] tokens = s.split("[|]");
                    statement.setInt(1, Integer.parseInt(tokens[0]));
                    statement.setString(2, tokens[1]);
                    statement.executeUpdate();
                }
            }

            try (PreparedStatement statement = conn.prepareStatement("INSERT INTO orders VALUES (?, ?, ?)")) {
                statement.setInt(1, 1);
                statement.setDate(2, Date.valueOf("22/09/2022"));
                statement.setString(3, "Ciocolata, Vanilie");
                statement.executeUpdate();
            }//see these if errors
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add the given book to the database.
     */
    void addCake(tort b) {
        try {
            try (PreparedStatement statement = conn.prepareStatement("INSERT INTO cakes VALUES (?, ?, ?)")) {
                statement.setInt(1, b.getId());
                statement.setString(2, b.getTip());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove the book with the given title from table books.
     *
     * @param id
     */
    void removeCakeById(int id) {
        try {
            try (PreparedStatement statement = conn.prepareStatement("DELETE FROM cakes WHERE id=?")) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all book from table books in the database.
     *
     * @return: an ArrayList with Book objects.
     */
    ArrayList<tort> getAll() {
        ArrayList<tort> cakes = new ArrayList<>();

        try {
            try (PreparedStatement statement = conn.prepareStatement("SELECT * from cakes"); ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    tort b = new tort(rs.getInt("id"), rs.getString("typecake"));
                    cakes.add(b);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cakes;
    }

    void updateOrder() {
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement updateorders = conn.prepareStatement("UPDATE orders SET cakes = ? WHERE dateorder = ?;");
            ) {
                updateorders.setString(1, "Ciocolata, Vanilie");
                updateorders.setDate(2, Date.valueOf("22/09/2018"));
                updateorders.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBC db_example = new JDBC();
        db_example.openConnection();
        db_example.createSchema();
        db_example.initTables();

        tort b = new tort(10, "Frisca");
        db_example.addCake(b);

        db_example.removeCakeById(10);

        db_example.updateOrder();

        ArrayList<tort> cakesList = db_example.getAll();
        for (tort tort : cakesList)
            System.out.println(tort);

        db_example.closeConnection();
    }
}
