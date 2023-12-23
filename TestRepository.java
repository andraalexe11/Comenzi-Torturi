import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TestRepository{
    @Test
    public void testAdd() throws RepositoryException {
        tort tort = new tort(1, "ciocolata");
        MemoryRepository<tort> memoryRepository = new MemoryRepository<>();
        memoryRepository.add(tort);
        assert (memoryRepository.getAll().size() == 1);
    }

    @Test
    public void testDelete() throws RepositoryException {
        tort tort = new tort(1, "ciocolata");
        tort tort1 = new tort(2, "vanilie");
        MemoryRepository<tort> memoryRepository = new MemoryRepository<>();
        memoryRepository.add(tort);
        memoryRepository.add(tort1);
        memoryRepository.remove(1);
        assert (memoryRepository.getAll().size() == 1);
    }

    @Test
    public void testUpdate() throws RepositoryException, IOException {
        tort tort = new tort(1, "ciocolata");
        MemoryRepository<tort> memoryRepository = new MemoryRepository<>();
        memoryRepository.add(tort);
        memoryRepository.update(1, new tort(1, "vanilie"));
        assert (memoryRepository.getAll().get(0).getTip() == "vanilie");

    }

}
