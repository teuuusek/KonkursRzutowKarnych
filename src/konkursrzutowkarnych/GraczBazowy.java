package konkursrzutowkarnych;


public abstract class GraczBazowy {

    protected String nazwa;

    public GraczBazowy(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    protected String losujKierunek() {
        String[] kierunki = {"lewo", "środek", "prawo"};
        int index = (int)(Math.random() * kierunki.length);
        return kierunki[index];
    }
}
