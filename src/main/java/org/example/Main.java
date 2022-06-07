package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yourScore = 0;
        int cpuScore = 0;
        int exitGame;                   //zmienna do sprawdzenia czy gracz chce grać dalej

        do {                                                            //odtwarzaj grę w pętli do while
            System.out.println("Gra w papier, kamień, nożyce");
            System.out.println("1. Papier");
            System.out.println("2. Kamień");
            System.out.println("3. Nożyce");
            System.out.println("Wybierz: ");

            int playerFigure;                                       //numer figury gracza
            String playerFigureName = null;                         //nazwa figury gracza

            do {                                                    //do while który odtworzy się ponownie jeśli gracz wybierze nieprawidłową figurę
                playerFigure = scanner.nextInt();                   //gracz wybiera figurę

                if (!(playerFigure == 1 || playerFigure == 2 || playerFigure == 3)) {       //jeśli gracz wybierze nieprawidłową wartość, wyświetl odpowiedni komunikat
                    System.out.println("Wybierz poprawną wartość (1/2/3): ");
                }
            } while (!(playerFigure == 1 || playerFigure == 2 || playerFigure == 3));

            switch (playerFigure) {                             //przypisz nazwę do wybranej przez gracza figury
                case 1:
                    playerFigureName = "Papier";
                    break;
                case 2:
                    playerFigureName = "Kamień";
                    break;
                case 3:
                    playerFigureName = "Nożyce";
                    break;
            }
            System.out.println();
            System.out.println("Wybrałeś " + playerFigureName);             //zakomunikuj graczowi jaką figurę wybrał

            double cpuFigureRandom = random();                              //wylosuj wartość od 0 do 1

            int cpuFigure;                          //figura komputera
            String cpuFigureName = null;

            if (cpuFigureRandom < 0.33333333333333333333333333) {               //Przypisz wylowowanej wartości liczbę 1, 2 lub 3
                cpuFigure = 1;
            } else if (cpuFigureRandom < 0.6666666666666666666666666) {
                cpuFigure = 2;
            } else {
                cpuFigure = 3;
            }

            switch (cpuFigure) {                    //przypisz nazwę figurze wylosowanej przez komputer
                case 1:
                    cpuFigureName = "Papier";
                    break;
                case 2:
                    cpuFigureName = "Kamień";
                    break;
                case 3:
                    cpuFigureName = "Nożyce";
                    break;
            }

            System.out.println("Komputer wybrał " + cpuFigureName);         //zakomunikuj jaką figurę wybrał komputer

            if (cpuFigure == playerFigure) {                                //Sprawdź kto wygrał, wyświetl stosowny komunikat i dodaj zwycięzcy jeden punkt do wyniku
                System.out.println("Remis");
            } else if ((playerFigure == 1 && cpuFigure == 2) || (playerFigure == 2 && cpuFigure == 3) || (playerFigure == 3 && cpuFigure == 1)) {
                System.out.println("Wygrałeś");
                yourScore++;
            } else {
                System.out.println("Przegrałeś");
                cpuScore++;
            }
            System.out.println();
            System.out.println("Wynik");                                    //Wyświetl zsumowany wynik wszystkich rozgrywek
            System.out.println("Ty: " + yourScore);
            System.out.println("Komputer " + cpuScore);

            if(yourScore>cpuScore){                                         //Wyświetl komunikat kto prowadzi łącznym wynikiem
                System.out.println("Prowadzisz");
            } else if (yourScore<cpuScore) {
                System.out.println("Komputer prowadzi");
            } else{
                System.out.println("Remis");
            }

            System.out.println();
            System.out.println("Czy chcesz zakończyć grę? ( 0-TAK; 1-NIE )");

            do {                                                //pętla do while upewniająca się że gracz wybrał 1 lub 0
                exitGame = scanner.nextInt();                   //gracz decyduje czy chce grać dalej
                if (!(exitGame==1 || exitGame==0)){             //jeśli gracz wybierze liczbę inną niż 1 lub 0, wystosuj odpowiedni komunikat
                    System.out.println("Wybierz 1 jeśli chcesz kontynuować. Aby zakończyć grę, wybierz 0");
                }
            } while(!(exitGame==1 || exitGame==0));

            System.out.println();
        } while (exitGame == 1);                    //jeśli wybierze 1 to gra dalej, jeśli 0 to gra kończy się
    }
}