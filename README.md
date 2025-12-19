# Konkurs-Rzut-w-Karnych---Projekt-PO
Mateusz Matynia - Programowanie Obiektowe - Projekt

### Opis programu
Program symuluje konkurs rzutów karnych pomiędzy drużyną gracza a drużyną sterowaną przez komputer.
Użytkownik wybiera drużynę, a następnie bierze udział w serii rzutów karnych.

### Przebieg gry
1. Program wyświetla listę dostępnych drużyn. Drużyny wczytywane są z pliku `dryzyny.json`.
2. Użytkownik wybiera drużynę, wpisując odpowiedni numer.
3. Podczas każdego rzutu karnego:
   - użytkownik wybiera kierunek strzału,
   - użytkownik wybiera kierunek obrony bramkarza.
4. Po każdym rzucie karnym wyświetlany jest aktualny wynik.
5. Po zakończeniu konkursu wyświetlany jest wynik końcowy.
6. Po zakończeniu meczu wynik zostaje zapisany do pliku `wyniki.txt`.

### Opis głównych klas

- **Main** – punkt startowy aplikacji, inicjalizuje obiekty i uruchamia grę.
- **MenedzerTurnieju** – zarządza przebiegiem meczu i wyborem drużyn.
- **RzutyKarne** – zawiera logikę konkursu rzutów karnych oraz zliczanie punktów.
- **Druzyna** – reprezentuje drużynę oraz listę zawodników.
- **Strzelec** – odpowiada za wykonywanie strzałów.
- **Bramkarz** – odpowiada za obronę strzałów.
- **GraczBazowy** – klasa abstrakcyjna zawierająca wspólne elementy dla strzelca i bramkarza.
- **KonfiguracjaJSON** – wczytuje dane drużyn z pliku JSON.
- **ZapisWynikow** – zapisuje wynik meczu do pliku tekstowego.
- **ZegarWatek** – prosty wątek odliczający czas przed rozpoczęciem gry.

