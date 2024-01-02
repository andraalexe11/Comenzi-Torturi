import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Irepository<T extends entity> extends Iterable<T>{


    public  void add(T elem) throws RepositoryException, SQLException;

    public void remove(int id) throws RepositoryException;

    public T find(int id);


    // program to an interface, not an implementation
    public ArrayList<T> getAll();

    void update(int idvechi, T comandanoua) throws IOException;
}
