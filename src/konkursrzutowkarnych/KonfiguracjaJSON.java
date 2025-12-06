package konkursrzutowkarnych;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KonfiguracjaJSON {
  private String  nazwaPliku;
  public KonfiguracjaJSON(String nazwaPliku) {
    this.nazwaPliku = nazwaPliku;
  }

public List<Druzyna> wczytajDruzyny() {
  List<Druzyna> druzyny = new ArrayList<>();

  try (BufferedReader reader = new BufferedReader(new FileReader(nazwaPliku))) {
    String linia;
    String aktualnaNazwa = null;
    List<String> aktualniZawodnicy = null;

  while ((linia = reader.readLine()) != null) {
    linia = linia.trim();

    if (linia.contains("\"nazwa\"")) {
      String[] parts = linia.split(":");
      if (parts.length >= 2) {
        String nazwa = parts[1].trim();
        nazwa = nazwa.replace("\"", "").replace(",", "");
        aktualnaNazwa = nazwa;
      }
    }

    if (linia.startsWith("\"zawodnicy\"")) {
        int pocz = linia.indexOf('[');
        int kon = linia.indexOf(']');

        if (pocz != -1 && kon != -1 && kon > pocz) {
            String srodek = linia.substring(pocz + 1, kon);
            String[] elem = srodek.split(",");
            List<String> zawodnicy = new ArrayList<>();

            for (String e : elem) {
                String z = e.trim();

                z = z.replace("\"", "");
                if (!z.isEmpty()) {
                    zawodnicy.add(z);
                }
            }

              aktualniZawodnicy = zawodnicy;
        }
    }
    if (aktualnaNazwa != null && aktualniZawodnicy != null) {
      druzyny.add(new Druzyna(aktualnaNazwa, aktualniZawodnicy));
      aktualnaNazwa = null;
      aktualniZawodnicy = null;
    }
  }

  } catch (IOException e) {
    System.out.println("Błąd podczas wczytywania pliku JSON: " + e.getMessage());
  }
  if (druzyny.isEmpty()) {
    System.out.println("Nie udało się wczytać drużyn z JSON, używam domyślnych danych.");
    druzyny.add(new Druzyna("Domyślna Drużyna 1", Arrays.asList("Zawodnik1", "Zawodnik2")));
    druzyny.add(new Druzyna("Domyślna Drużyna 2", Arrays.asList("Zawodnik3", "Zawodnik4")));
  }
  
  return druzyny;
}
}

      
      
