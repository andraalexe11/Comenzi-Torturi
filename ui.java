import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ui {
    private servicecomanda servicecomanda = new servicecomanda();
    private servicetort servicetort = new servicetort();

    Scanner choise = new Scanner(System.in);
    DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    ui() {
    }

    ui(servicetort servicetort, servicecomanda servicecomanda) {
        this.servicetort = servicetort;
        this.servicecomanda = servicecomanda;
    }

    void addtort() throws RepositoryException {
        System.out.print("Enter cake id: ");
        String token = choise.next();
        int id = Integer.parseInt(token);
        System.out.print("Enter cake type: ");
        String tip = choise.next();
        servicetort.add(id, tip);
    }

    void deletetort() throws RepositoryException {
        System.out.print("Enter cake id: ");
        String token = choise.next();
        int id = Integer.parseInt(token);
        servicetort.delete(id);
    }

    void updatetort() throws RepositoryException {
        System.out.print("Enter cake's id: ");
        String token = choise.next();
        int idvechi = Integer.parseInt(token);
        System.out.print("Enter new cake type: ");
        String tipnou = choise.next();
        servicetort.update(idvechi, tipnou);

    }

    void getAlltorturi() throws RepositoryException {
        for(int i = 0; i<servicetort.getAll().size(); i++){
            System.out.print("Cake:  " + servicetort.getAll().get(i));
        }
    }
    void addcomanda() throws RepositoryException {
        System.out.println("Enter id: ");
        String token = choise.next();
        int id = Integer.parseInt(token);
        System.out.println("Enter date (dd/mm/yyyy): ");
        LocalDate date= LocalDate.parse(choise.next(), form);
        System.out.println("Enter the number of cakes: ");
        int n = Integer.parseInt(choise.next());
        ArrayList<tort> torturi = new ArrayList<>();
        for(int i = 0; i< n; i++){
            System.out.println("Cake id: ");
            int idc = Integer.parseInt(choise.next());
            torturi.add(servicetort.getbyId(idc));
        }
        servicecomanda.add(id, date, torturi);
    }
    void updatecomanda() throws RepositoryException {
        System.out.println("Enter cake's id: ");
        String token = choise.next();
        int id = Integer.parseInt(token);
        System.out.println("Enter cake's new date (dd/mm/yyyy): ");
        LocalDate date= LocalDate.parse(choise.next(), form);
        System.out.println("Enter the number of cakes: ");
        int n = Integer.parseInt(choise.next());
        ArrayList<tort> torturi = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            System.out.println("Cake id: ");
            int idc = Integer.parseInt(choise.next());
            torturi.add(servicetort.getbyId(idc));
        }
        servicecomanda.update(id, date, torturi);
    }
    void deletecomanda() throws RepositoryException {
        System.out.println("Enter id: ");
        String token = choise.next();
        int id = Integer.parseInt(token);
        servicecomanda.delete(id);
    }
    void getAllcomenzi() throws RepositoryException {
        for(int i = 0; i<servicecomanda.getAll().size(); i++){
            System.out.print("Order: " + servicecomanda.getAll().get(i));
        }
    }

    void options(){
        System.out.println();
        System.out.println("Options: ");
        System.out.println("1. Add cake");
        System.out.println("2. Get All Cakes");
        System.out.println("3. Update cake");
        System.out.println("4. Delete cake");
        System.out.println("5. Add order");
        System.out.println("6. Get All Orders");
        System.out.println("7. Update Order");
        System.out.println("8. Delete Order");
        System.out.println("0. Exit");
    }
    void menu(){
        Scanner choise = new Scanner(System.in);
        String option = "1";
        while(!option.equals("0")){
            try {
                this.options();
                option = choise.next();
                System.out.println(option);
                switch (option){
                    case "1":
                        this.addtort();
                        break;
                    case "2":
                        this.getAlltorturi();
                        break;
                    case "3":
                        this.updatetort();
                        break;
                    case "4":
                        this.deletetort();
                        break;
                    case "5":
                        this.addcomanda();
                        break;
                    case "6":
                        this.getAllcomenzi();
                        break;
                    case "7":
                        this.updatecomanda();
                        break;
                    case "8":
                        this.deletecomanda();
                        break;
                    case "0":
                        break;
                }
            }catch (RuntimeException | RepositoryException n) {
                System.out.println(n.toString());
            }

        }
    }
}