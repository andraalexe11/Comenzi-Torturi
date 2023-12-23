import java.io.IOException;
import java.util.ArrayList;

public class servicetort {
    public Irepository<tort> repotort;

    servicetort() {
    }

    servicetort(Irepository<tort> repot) {
        this.repotort = repot;
    }

    public void add(int id, String tip) throws RepositoryException {
        tort tort = new tort(id, tip);
        repotort.add(tort);
    }

    public void delete(int id) throws RepositoryException {
        repotort.remove(id);
    }

    public ArrayList<tort> getAll()throws RepositoryException {
        return repotort.getAll();
    }

    public void update(int idvechi, String tipnou) throws RepositoryException, IOException {
        tort tortnou = new tort(idvechi, tipnou);
        repotort.update(idvechi, tortnou);

    }
    public tort getbyId(int id){
        return repotort.find(id);
    }
}