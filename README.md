# Konkurs-Rzut-w-Karnych---Projekt-PO
Mateusz Matynia - Programowanie Obiektowe - Projekt

### Opis programu
Program symuluje konkurs rzutów karnych pomiędzy drużyną gracza a drużyną sterowaną przez komputer.
Użytkownik wybiera drużynę, a następnie bierze udział w serii rzutów karnych.

### Przebieg gry
1. Program wyświetla listę dostępnych drużyn. Drużyny wczytywane są z pliku `druzyny.json`.
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

## Jak przeprowadzić testy funkcjonalne

Poniżej przedstawiono przykładowe testy funkcjonalne sprawdzające poprawność działania aplikacji
z punktu widzenia użytkownika końcowego.

### Test 1 – Uruchomienie programu
**Cel:** Sprawdzenie, czy program uruchamia się poprawnie.  
**Kroki:**
1. Uruchomić program w środowisku NetBeans.
2. Program wyświetla nagłówek oraz komunikat powitalny.

**Oczekiwany rezultat:**  
Program uruchamia się bez błędów i wyświetla menu wyboru drużyny.

---

### Test 2 – Wybór drużyny przez gracza
**Cel:** Sprawdzenie możliwości wyboru drużyny.  
**Kroki:**
1. Po uruchomieniu programu wpisać numer odpowiadający wybranej drużynie.
2. Program potwierdza wybór drużyny gracza.

**Oczekiwany rezultat:**  
Wybrana drużyna zostaje przypisana graczowi.

---

### Test 3 – Wykonanie rzutu karnego przez gracza
**Cel:** Sprawdzenie poprawności wykonywania rzutu karnego.  
**Kroki:**
1. Program prosi gracza o wybór kierunku strzału.
2. Gracz podaje kierunek strzału.
3. Program porównuje kierunek strzału z obroną bramkarza AI.

**Oczekiwany rezultat:**  
Program poprawnie rozstrzyga, czy padł gol lub obrona.

---

### Test 4 – Aktualizacja wyniku po rzucie karnym
**Cel:** Sprawdzenie aktualizacji i wyświetlania wyniku.  
**Kroki:**
1. Wykonać rzut karny.
2. Sprawdzić wyświetlany wynik po strzale.

**Oczekiwany rezultat:**  
Po każdym rzucie karnym wyświetlany jest aktualny wynik meczu.

---

### Test 5 – Zakończenie konkursu rzutów karnych
**Cel:** Sprawdzenie zakończenia gry.  
**Kroki:**
1. Rozegrać wszystkie rundy rzutów karnych.
2. Program wyświetla wynik końcowy.

**Oczekiwany rezultat:**  
Wyświetlany jest poprawny wynik końcowy meczu.

---

### Test 6 – Zapis wyniku do pliku
**Cel:** Sprawdzenie zapisu wyniku meczu.  
**Kroki:**
1. Zakończyć konkurs rzutów karnych.
2. Sprawdzić plik `wyniki.txt`.

**Oczekiwany rezultat:**  
Wynik meczu zostaje zapisany do pliku tekstowego.


