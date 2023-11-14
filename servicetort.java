import java.util.ArrayList;

public class servicetort {
    public repository<tort> repotort;

    servicetort() {
    }

    servicetort(repository<tort> repot) {
        this.repotort = repot;
    }

    public void add(int id, String tip) {
        tort tort = new tort(id, tip);
        repotort.add(tort);
    }

    public boolean delete(int id, String tip) {
        tort tort = new tort(id, tip);
        return repotort.delete(tort);
    }

    public ArrayList<tort> getAll() {
        return repotort.getAll();
    }

    public boolean update(int idvechi, int idnou, String tipvechi, String tipnou){
        tort tortvechi = new tort(idvechi, tipvechi);
        tort tortnou = new tort(idnou, tipnou);
        return repotort.update(tortvechi, tortnou);

    }
    public tort getbyId(int id){
        return repotort.getById(id);
    }
}