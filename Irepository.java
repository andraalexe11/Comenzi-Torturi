import java.util.ArrayList;
import java.util.Collection;
public interface Irepository<T extends entity> extends Iterable<T>{


    public  void add(T elem) throws RepositoryException;

    public void remove(int id) throws RepositoryException;

    public T find(int id);


    // program to an interface, not an implementation
    public ArrayList<T> getAll();
}
