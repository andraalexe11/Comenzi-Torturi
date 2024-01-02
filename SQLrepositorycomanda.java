import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;

public class SQLrepositorycomanda extends MemoryRepository<comanda>{
    private static final String JDBC_URL = "jdbc:sqlite:Lab4Database.db";

    private Connection conn = null;

    private ArrayList<comanda> data = new ArrayList<>();

    public SQLrepositorycomanda() {
        openConnection();
        createSchema();

    }

    private void openConnection() {
        try {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createSchema() {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS orders( id int, orderdate date, cakes varchar(250));");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    public void add(comanda c) throws SQLException {
        this.data.add(c);

        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO orders VALUES (?, ?, ?)")) {
            statement.setInt(1, c.getId());
            statement.setDate(2, Date.valueOf(c.getData()));
            statement.setString(3, String.valueOf(c.getTorturi()));
            statement.executeUpdate();
        }
    }

    public ArrayList<comanda> getAll() {
        return data;
    }

}