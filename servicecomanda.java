import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class servicecomanda {
    public  MemoryRepository<comanda> repocomanda;
    public servicecomanda(){}
    public servicecomanda(MemoryRepository<comanda> repocomanda){
        this.repocomanda = repocomanda;
    }
    public void add(int id, LocalDate data, ArrayList<tort>  torturi) throws RepositoryException {
        comanda comanda = new comanda(id, data, torturi);
        repocomanda.add(comanda);
    }
    public ArrayList<comanda> getAll()throws RepositoryException{
        return repocomanda.getAll();
    }

    public void delete(int id) throws RepositoryException {
         repocomanda.remove(id);
    }

    public void update(int idvechi, LocalDate datanoua, ArrayList<tort> torturinoi) throws RepositoryException{
        comanda comandanoua  =  new comanda(idvechi, datanoua, torturinoi);
        repocomanda.update(idvechi, comandanoua);
    }
    public comanda getbyId(int id){
        return repocomanda.find(id);
    }
}
