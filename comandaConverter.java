import java.time.LocalDate;
import java.util.ArrayList;

public class comandaConverter implements EntityConverter<comanda> {
    @Override
    public String toString(comanda object) {
        return object.getId() + "," + object.getData() + "," + object.getTorturi();
    }

    @Override
    public comanda fromString(String line) {
        String[] tokens = line.split(",");
        ArrayList<tort> torturi = new ArrayList<>();
        for(int i = 2; i<tokens.length-1; i++){
            tort t = new tort(Integer.parseInt(tokens[i]), tokens[i+1]);
            torturi.add(t);
        }
        return new comanda(Integer.parseInt(tokens[0]), LocalDate.parse(tokens[1]), torturi);
    }
}
