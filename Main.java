// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MemoryRepository<tort> repotort = new MemoryRepository<>();
        MemoryRepository<comanda> repocomanda = new MemoryRepository<>();
        servicetort servicetort = new servicetort(repotort);
        servicecomanda servicecomanda = new servicecomanda(repocomanda);
        ui ui  = new ui(servicetort, servicecomanda);
        ui.menu();

    }
}