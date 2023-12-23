import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractRepository <T extends entity> implements Irepository<T> {
    protected ArrayList<T> list1 = new ArrayList<T>();


    @Override
    public Iterator<T> iterator() {
        return new ArrayList<T>(list1).iterator();
    }
}