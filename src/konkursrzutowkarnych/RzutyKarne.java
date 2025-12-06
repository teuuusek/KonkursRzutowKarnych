package konkursrzutowkarnych;

import java.util.List;
import java.util.Scanner;


public class RzutyKarne {

    private Druzyna druzynaGracza;
    private Druzyna druzynaAI;
    private Scanner scanner;
    private ZapisWynikow zapisWynikow;

    private int liczbaRund = 5;
    private int goleGracza = 0;
    private int goleAI = 0;

    public RzutyKarne(Druzyna druzynaGracza, Druzyna druzynaAI,
                      Scanner scanner, ZapisWynikow zapisWynikow) {
        this.druzynaGracza = druzynaGracza;
        this.druzynaAI = druzynaAI;
        this.scanner = scanner;
        this.zapisWynikow = zapisWynikow;
    }

    public void graj() {

        List<String> strzelcyGracza = druzynaGracza.getZawodnicy();
        List<String> strzelcyAI = druzynaAI.getZawodnicy();

        Bramkarz bramkarzGracza = new Bramkarz("Bramkarz gracza");
        Bramkarz bramkarzAI = new Bramkarz("Bramkarz AI");

        System.out.println("\nPrzygotuj się! Za chwilę zaczniemy konkurs rzutów karnych.");

        ZegarWatek zegar = new ZegarWatek(3);
        zegar.start();

        try {
            zegar.join();
        } catch (InterruptedException e) {
            System.out.println("Zegar został przerwany.");
        }

        System.out.println("\n=== ROZPOCZYNAMY RZUTY KARNE ===");

        for (int i = 0; i < liczbaRund; i++) {
            System.out.println("\n--- RUNDA " + (i + 1) + " ---");

            String nazwiskoStrzelcaGracza = strzelcyGracza.get(i % strzelcyGracza.size());
            Strzelec strzelecGracza = new Strzelec(nazwiskoStrzelcaGracza);

            System.out.println("\nStrzela GRACZ: " + strzelecGracza.getNazwa());
            String kierunekStrzaluGracza = strzelecGracza.strzelManualnie(scanner);
            String kierunekObronyAI = bramkarzAI.bronAutomatycznie();

            System.out.println("Gracz strzela w: " + kierunekStrzaluGracza);
            System.out.println("Bramkarz AI rzuca się w: " + kierunekObronyAI);

            if (!kierunekStrzaluGracza.equals(kierunekObronyAI)) {
                System.out.println("GOL dla gracza!");
                goleGracza++;
            } else {
                System.out.println("Bramkarz AI obronił.");
            }

            String nazwiskoStrzelcaAI = strzelcyAI.get(i % strzelcyAI.size());
            Strzelec strzelecAI = new Strzelec(nazwiskoStrzelcaAI);

            System.out.println("\nStrzela AI: " + strzelecAI.getNazwa());
            String kierunekStrzaluAI = strzelecAI.strzelAutomatycznie();
            String kierunekObronyGracza = bramkarzGracza.bronManualnie(scanner);

            System.out.println("AI strzela w: " + kierunekStrzaluAI);
            System.out.println("Bramkarz gracza rzuca się w: " + kierunekObronyGracza);

            if (!kierunekStrzaluAI.equals(kierunekObronyGracza)) {
                System.out.println("GOL dla AI!");
                goleAI++;
            } else {
                System.out.println("Obroniłeś strzał AI!");
            }
        }

        System.out.println("\n=== KONIEC KONKURSU ===");
        System.out.println("Wynik końcowy: GRACZ " + goleGracza + " : " + goleAI + " AI");

        String wynik = "Drużyna gracza: " + druzynaGracza.getNazwa()
                + ", drużyna AI: " + druzynaAI.getNazwa()
                + ", wynik: " + goleGracza + ":" + goleAI;

        zapisWynikow.zapiszWynik(wynik);
    }
}
