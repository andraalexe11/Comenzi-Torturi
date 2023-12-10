import java.util.ArrayList;
import java.util.Collection;

public class MemoryRepository <T extends entity> extends AbstractRepository<T> {
    @Override
    public void add(T elem) throws RepositoryException {
        if (elem == null) {
            throw new IllegalArgumentException();
        }
        if(this.find(elem.getId()) != null){
            throw new DuplicateObjectException("Cannot duplicate repository objects!");
        }
        this.list.add(elem);
    }

    @Override
    public T find(int id) {
        for(T elem : list ){
            if(elem.getId() == id) return elem;
        }
        return null;
    }

    @Override
    public void remove(int id) throws RepositoryException {
        if(this.find(id) == null){
            throw new RuntimeException("Element does not exist!");
        }
        this.list.remove(id);
    }

    @Override
    public ArrayList<T> getAll() {
        if(this.list.isEmpty()){
            throw new RuntimeException("The list is empty!");
        }
        return this.list;
    }

    public void update(int id, T newelem){
        if(find(id) == null){
            throw new RuntimeException("Element does not exist!");
        }
        this.list.remove(id);
        this.list.add(newelem);
    }
}

