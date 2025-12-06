package konkursrzutowkarnych;

import java.io.FileWriter;
import java.io.IOException;


public class ZapisWynikow {

    private String nazwaPliku;

    public ZapisWynikow(String nazwaPliku) {
        this.nazwaPliku = nazwaPliku;
    }

    public void zapiszWynik(String tekst) {
        try (FileWriter writer = new FileWriter(nazwaPliku, true)) {
            writer.write(tekst + System.lineSeparator());
            System.out.println("Wynik został zapisany.");
        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }
}
