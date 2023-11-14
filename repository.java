import java.util.ArrayList;
import java.lang.Object;

public class repository <T extends entity> {
    private ArrayList<T> list =new ArrayList<T>();
    public repository(){}
    public void add( T elem){
        if(findbyId(elem.getId())) throw new RuntimeException("Duplicate ID");
        list.add(elem);
    }
    public ArrayList<T> getAll(){
        return this.list;
    }
    public boolean delete(T element){
        for(T elem: list){
            if(elem.getId() == element.getId()) {
                list.remove(elem);
                return true;
            }
        }

        return false;
    }

    public boolean update(T elemvechi, T elemnou){
        if(delete(elemvechi)){
            list.add(elemnou);
            return true;
        }
        return false;
    }

    public T getById(int id){
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }

    public boolean findbyId(int id){
        for(T elem: list){
            if(elem.getId() == id)
                return true;
        }

        return false;
    }
}