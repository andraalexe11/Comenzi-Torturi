import java.util.Objects;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws RepositoryException {
        Irepository<tort> repotort = null;
        Irepository<comanda> repocomanda = null;
        tortConverter tortConverter = new tortConverter();
        comandaConverter comandaConverter = new comandaConverter();
        Settings settings = Settings.getInstance();

        if (Objects.equals(settings.getRepoType(), "memory")){
            repotort = new MemoryRepository<tort>();
            repocomanda = new MemoryRepository<comanda>();
        }

        if(Objects.equals(settings.getRepoType(),"text")){
            /*
            repotype: text
            repo_file1: C:\Users\Alexe Andra\Documents\Java\a2-andraalexe11\torturi.txt
            repo_file2: C:\Users\Alexe Andra\Documents\Java\a2-andraalexe11\comenzi.txt
             */
            repotort = new TextFileRepository<tort>(settings.getRepoFile1(), tortConverter);
            repocomanda = new TextFileRepository<comanda>(settings.getRepoFile2(), comandaConverter);

        }

        if(Objects.equals(settings.getRepoType(), "bin")){
            /*repo_type: bin
            repo_file1: C:\\Users\\Alexe Andra\\Documents\\Java\\a2-andraalexe11\\torturi.bin
            repo_file2: C:\\Users\\Alexe Andra\\Documents\\Java\\a2-andraalexe11\\comanda.bin
             */
            repotort = new BinaryFileRepository<tort>(settings.getRepoFile1());
            repocomanda = new BinaryFileRepository<comanda>(settings.getRepoFile2());
        }
        if (Objects.equals(settings.getRepoType(), "db")) {
            repotort = new SQLrepositorytort();
            repocomanda = new SQLrepositorycomanda();

        }


        servicetort servicetort = new servicetort(repotort);
        servicecomanda servicecomanda = new servicecomanda(repocomanda);
        ui ui = new ui(servicetort, servicecomanda);
        ui.menu();


    }
}