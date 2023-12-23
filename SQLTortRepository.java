
import java.sql.Connection;

public class SQLTortRepository extends MemoryRepository<tort> {
    private final String dbLocation;

    private Connection conn = null;

    public SQLTortRepository(String dbLocation) throws RepositoryException {
        this.dbLocation = "jdbc:sql" + dbLocation;

    }
}


