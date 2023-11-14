import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class servicecomanda {
    public  repository<comanda> repocomanda;
    public servicecomanda(){}
    public servicecomanda(repository<comanda> repocomanda){
        this.repocomanda = repocomanda;
    }
    public void add(int id, LocalDate data, ArrayList<tort>  torturi){
        comanda comanda = new comanda(id, data, torturi);
        repocomanda.add(comanda);
    }
    public ArrayList<comanda> getAll(){
        return repocomanda.getAll();
    }

    public boolean delete(int id, LocalDate data, ArrayList<tort>  torturi){
        comanda comanda =  new comanda(id, data, torturi);
        return repocomanda.delete(comanda);
    }

    public boolean update(int idvechi, LocalDate dataveche, ArrayList<tort> torturivechi, int idnou, LocalDate datanoua, ArrayList<tort> torturinoi){
        comanda comandaveche = new comanda(idvechi, dataveche, torturivechi);
        comanda comandanoua  =  new comanda(idnou, datanoua, torturinoi);
        return  repocomanda.update(comandaveche, comandanoua);
    }
    public comanda getbyId(int id){
        return repocomanda.getById(id);
    }
}
