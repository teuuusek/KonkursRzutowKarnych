package konkursrzutowkarnych;

import java.util.List;

public class Druzyna {

    private String nazwa;
    private List<String> zawodnicy;

    public Druzyna(String nazwa, List<String> zawodnicy) {
        this.nazwa = nazwa;
        this.zawodnicy = zawodnicy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<String> getZawodnicy() {
        return zawodnicy;
    }
}
