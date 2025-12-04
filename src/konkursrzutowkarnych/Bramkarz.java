package konkursrzutowkarnych;

import java.util.Scanner;


public class Bramkarz extends GraczBazowy {

    public Bramkarz(String nazwa) {
        super(nazwa);
    }

    public String bronManualnie(Scanner scanner) {
        System.out.println("\n" + nazwa + " - wybierz gdzie się rzucasz:");
        System.out.println("1 - lewo");
        System.out.println("2 - środek");
        System.out.println("3 - prawo");

        while (true) {
            String wybor = scanner.nextLine().trim();
            if (wybor.equals("1")) return "lewo";
            if (wybor.equals("2")) return "środek";
            if (wybor.equals("3")) return "prawo";

            System.out.println("Niepoprawny wybór, spróbuj jeszcze raz.");
        }
    }

    public String bronAutomatycznie() {
        return losujKierunek();
    }
}
