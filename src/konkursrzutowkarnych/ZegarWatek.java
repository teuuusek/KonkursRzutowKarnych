package konkursrzutowkarnych;


public class ZegarWatek extends Thread {

    private int ileSekund;

    public ZegarWatek(int ileSekund) {
        this.ileSekund = ileSekund;
    }

    @Override
    public void run() {
        try {
            for (int i = ileSekund; i > 0; i--) {
                System.out.println("Start za: " + i + "...");
                Thread.sleep(1000); 
            }
            System.out.println("== ZACZYNAMY RZUTY KARNE! ==");
        } catch (InterruptedException e) {
            System.out.println("Zegar został przerwany: " + e.getMessage());
        }
    }
}
