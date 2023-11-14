// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        repository<tort> repotort = new repository<tort>();
        repository<comanda> repocomanda = new repository<comanda>();
        servicetort servicetort = new servicetort(repotort);
        servicecomanda servicecomanda = new servicecomanda(repocomanda);
        ui ui  = new ui(servicetort, servicecomanda);
        ui.menu();

    }
}