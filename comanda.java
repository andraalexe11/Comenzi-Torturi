import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
public class comanda extends entity implements Serializable {
    private LocalDate data;
    private ArrayList<tort> torturi;

    comanda() {
    }

    comanda(int id, LocalDate data, ArrayList<tort> torturi) {
        setId(id);
        this.data = data;
        this.torturi = torturi;
    }

    public LocalDate getData() {
        return this.data;
    }

    public ArrayList<tort>  getTorturi() {
        return torturi;
    }



    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setTorturi(ArrayList<tort>  torturi) {
        this.torturi = torturi;
    }

    @Override
    public String toString() {
        return "comanda{" +
                "data=" + data +
                ", torturi=" + torturi +
                '}';
    }
}
