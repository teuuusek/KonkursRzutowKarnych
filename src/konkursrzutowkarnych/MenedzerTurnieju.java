package konkursrzutowkarnych;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenedzerTurnieju {

    private Scanner scanner;
    private ZapisWynikow zapisWynikow;
    private List<Druzyna> druzyny;

    public MenedzerTurnieju(Scanner scanner, ZapisWynikow zapisWynikow) {
        this.scanner = scanner;
        this.zapisWynikow = zapisWynikow;
        inicjalizujDruzyny();
    }


    private void inicjalizujDruzyny() {
        KonfiguracjaJSON konfiguracja = new KonfiguracjaJSON("druzyny.json");
        this.druzyny = konfiguracja.wczytajDruzyny();

        if (this.druzyny == null || this.druzyny.isEmpty()) {
            System.out.println("Błąd wczytywania drużyn — tworzenie danych domyślnych.");
            this.druzyny = new ArrayList<>();
            this.druzyny.add(new Druzyna("Domyślna drużyna", List.of("A", "B", "C", "D", "E")));
        }
    }


    private Druzyna wybierzDruzyneGracza() {
        System.out.println("\n=== WYBIERZ DRUŻYNĘ ===");

        for (int i = 0; i < druzyny.size(); i++) {
            System.out.println((i + 1) + " - " + druzyny.get(i).getNazwa());
        }

        while (true) {
            System.out.print("Podaj numer drużyny: ");
            String wpis = scanner.nextLine().trim();
            try {
                int numer = Integer.parseInt(wpis);
                if (numer >= 1 && numer <= druzyny.size()) {
                    return druzyny.get(numer - 1);
                }
            } catch (Exception ignored) {}
            System.out.println("Niepoprawny numer — spróbuj ponownie.");
        }
    }


    private Druzyna losujDruzyneAI(Druzyna druzynaGracza) {
        List<Druzyna> kopia = new ArrayList<>(druzyny);
        kopia.remove(druzynaGracza);

        int indeks = (int)(Math.random() * kopia.size());
        return kopia.get(indeks);
    }


    public void rozegrajPojedynczyMecz() {
        Druzyna gracz = wybierzDruzyneGracza();
        Druzyna ai = losujDruzyneAI(gracz);

        System.out.println("\nWybrana drużyna gracza: " + gracz.getNazwa());
        System.out.println("Wylosowana drużyna AI: " + ai.getNazwa());

        RzutyKarne rzuty = new RzutyKarne(gracz, ai, scanner, zapisWynikow);
        rzuty.graj();
    }
}
