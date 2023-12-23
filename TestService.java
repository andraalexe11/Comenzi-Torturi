import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestService {
    @Test
    public void testAdd() throws RepositoryException {
        MemoryRepository<comanda> memoryRepository = new MemoryRepository<>();
        servicecomanda servicecomanda = new servicecomanda(memoryRepository);
        ArrayList<tort> t = new ArrayList<>();
        tort tort = new tort(1, "ciocolata");
        t.add(tort);
        servicecomanda.add(1, LocalDate.of(2020, 11, 1),t);
        assert (servicecomanda.getAll().size() == 1);
        assert (servicecomanda.getbyId(1).getTorturi() == t);
        MemoryRepository<tort> tortMemoryRepository = new MemoryRepository<>();
        tortMemoryRepository.add(tort);
        assert (tortMemoryRepository.getAll().size() == 1);
    }
  @Test
    public void  testDelete() throws RepositoryException {
        MemoryRepository<comanda> memoryRepository = new MemoryRepository<>();
        servicecomanda servicecomanda = new servicecomanda(memoryRepository);
        ArrayList<tort> t = new ArrayList<>();
        tort tort = new tort(1, "ciocolata");
        t.add(tort);
        servicecomanda.add(1, LocalDate.of(2020, 11, 1),t);
      servicecomanda.add(2, LocalDate.of(2023, 1, 19),t);
      servicecomanda.delete(1);
      assert (servicecomanda.getAll().size() == 1);
      MemoryRepository<tort> tortMemoryRepository = new MemoryRepository<>();
      tort tort1 = new tort(2, "ciocolata");
      tortMemoryRepository.add(tort);
      tortMemoryRepository.add(tort1);
      tortMemoryRepository.remove(1);
      assert (tortMemoryRepository.getAll().size() == 1);
    }

    @Test
    public  void testUpdate() throws RepositoryException, IOException {
        MemoryRepository<comanda> memoryRepository = new MemoryRepository<>();
        servicecomanda servicecomanda = new servicecomanda(memoryRepository);
        ArrayList<tort> t = new ArrayList<>();
        tort tort = new tort(1, "ciocolata");
        t.add(tort);
        t.removeLast();
        servicecomanda.add(1, LocalDate.of(2020, 11, 1),t);
        servicecomanda.update(1, LocalDate.of(2019,9,9), t);
        assert (servicecomanda.getAll().get(0).getTorturi().size() == 0);
    }

    @Test
    public void servicetort() throws RepositoryException {
        MemoryRepository<tort> memoryRepository  = new MemoryRepository<>();
        servicetort servicetort = new servicetort(memoryRepository);
        servicetort.add(1, "vanilie");
        assert (servicetort.getAll().size() == 1);

    }
}
