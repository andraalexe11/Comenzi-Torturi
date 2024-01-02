import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLrepositorytort extends MemoryRepository<tort>{
    private static final String JDBC_URL = "jdbc:sqlite:Lab4Database.db";

    private Connection conn = null;

    private ArrayList<tort> data = new ArrayList<>();

    public SQLrepositorytort() {
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
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS cakes(id int, caketype varchar(20));");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    public void add(tort t) throws SQLException {
        this.data.add(t);

        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO cakes VALUES (?, ?)")) {
            statement.setInt(1, t.getId());
            statement.setString(2, t.getTip());
            statement.executeUpdate();
        }
    }

    public ArrayList<tort> getAll() {
        return data;
    }

}