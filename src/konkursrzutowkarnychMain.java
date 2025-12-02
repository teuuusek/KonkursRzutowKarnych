package konkursrzutowkarnych;

import java.until.Scanner;

public class Main {

  public static void wypiszNaglowek() {
    System.out.println("================================");
    System.out.println("     KONKURS RZUTÓW KARNYCH     ");
    System.out.println("================================");
  public static void main(String[] args) {
    wypiszNaglowek();
    Scanner scanner = new Scanner(System.in);
    ZapisWynikow zapisWynikow = new ZapisyWynikow("wyniki.txt);
    MenedzerTurnieju menedzer = new MenedzerTurnieju(scanner, zapisWynikow);
    menedzer.rozegrajPojedynczyMecz();
    scanner.close();
  }
}
