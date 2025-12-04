package konkursrzutowkarnych;

import java.util.Scanner;

public class Strzelec extends GraczBazowy {

    public Strzelec(String nazwa) {
        super(nazwa);
    }

    public String strzelManualnie(Scanner scanner) {
        System.out.println("\n" + nazwa + " - wybierz gdzie strzelasz:");
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

    public String strzelAutomatycznie() {
        return losujKierunek();
    }
}
