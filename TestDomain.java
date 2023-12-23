import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestDomain {
    @Test
    public void testentity(){
        entity entity= new entity(1);
        assert(entity.getId() == 1);
        entity.setId(2);
        assert(entity.getId() == 2);
        entity entity1 = new  entity();
        entity1.setId(0);
        assert (entity1.getId() == 0);
    }

    @Test
    public void testtort(){
        tort tort = new tort();
        tort.setId(1);
        tort.setTip("ciocolata");
        assert (tort.getTip() == "ciocolata");
        assert (tort.getId() == 1);
        tort.setTip("vanilie");
        assert(tort.getTip() == "vanilie");

    }

    @Test
    public void testcomanda(){
        ArrayList<tort> t = new ArrayList<>();
        tort tort = new tort(1, "ciocolata");
        t.add(tort);
        LocalDate date = LocalDate.of(2020, 2, 2);
        comanda comanda = new comanda();
        comanda.setId(1);
        comanda.setData(date);
        comanda.setTorturi(t);
        assert (comanda.getTorturi().size() == 1);
        assert (comanda.getData() == date);
        String s = comanda.toString();
        assert (s.contains("ciocolata"));

    }
    @Test
    public void testcomandaconverter(){
        comandaConverter converter = new comandaConverter();
        ArrayList<tort> t = new ArrayList<>();
        tort tort = new tort(1, "ciocolata");
        t.add(tort);
        LocalDate date = LocalDate.of(2020, 2, 2);
        comanda comanda = new comanda();
        comanda.setId(1);
        comanda.setData(date);
        comanda.setTorturi(t);
        assert (converter.toString(comanda).contains("ciocolata"));
    }

}
