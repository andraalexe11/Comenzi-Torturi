import org.junit.Test;

public class TestException {
    @Test
    public void duplicate(){
        DuplicateObjectException duplicateObjectException = new DuplicateObjectException("The Object already exists!");
        assert(duplicateObjectException.getMessage() == "The Object already exists!");
    }
}
