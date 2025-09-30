import java.util.Scanner;

public class ZooProsit1 {
    int nbrCages = 20;
    String zooName = "my zoo";

    public static void main(String[] args) {
        ZooProsit1 app = new ZooProsit1();
        System.out.println(app.zooName + " comporte " + app.nbrCages + " cages");

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Entrez le nom du zoo : ");
            app.zooName = sc.nextLine();
        } while (app.zooName.trim().isEmpty());

        do {
            System.out.print("Entrez le nombre de cages (positif) : ");
            while (!sc.hasNextInt()) { sc.next(); }
            app.nbrCages = sc.nextInt();
        } while (app.nbrCages <= 0);

        System.out.println(app.zooName + " comporte " + app.nbrCages + " cages");
        sc.close();
    }
}
