import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AbstractRepository <T extends entity> implements Irepository<T> {
    protected ArrayList<T> list = new ArrayList<T>();


    @Override
    public void add(T elem) throws RepositoryException {

    }

    @Override
    public void remove(int id) throws RepositoryException {

    }

    @Override
    public T find(int id) {
        return null;
    }

    @Override
    public ArrayList<T> getAll() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}