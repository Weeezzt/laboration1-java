package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static MenuChoice1 menuChoice1 = new MenuChoice1();
    public static void main(String[] args) {
        start();
    }
    public static void start() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        TimeAndPrice[] timeAndPrice = null;
        TimeAndPrice[] sortedArray = null;  // To hold sorted array


        while(running) {

            System.out.println("Elpriser\n========\n1. Inmatning\n2. Min, Max och Medel\n3. Sortera\n4. Bästa laddningstid (4h)\nE. Avsluta");
            System.out.print("Välj ett menyalternativ: ");
            String input = scanner.nextLine();

            // Handle user input
            switch (input) {
                case "1" -> {
                    menuChoice1.execute();
                    timeAndPrice = menuChoice1.getPriceArray();
                    sortedArray = Arrays.copyOf(timeAndPrice, timeAndPrice.length);
                }
                case "2" -> {
                    if (timeAndPrice != null) {
                        new MenuChoice2().execute(timeAndPrice);
                    } else {
                        System.out.println("Ingen data tillgänglig");
                    }
                }
                case "3" -> {
                    if (sortedArray != null) {
                        Arrays.sort(sortedArray);  // Sort the array before passing it
                        new MenuChoice3().execute(sortedArray);
                    } else {
                        System.out.println("Ingen data tillgänglig");
                    }
                }
                case "4" -> bestTimeToCharge(timeAndPrice);
                case "e" -> {
                    System.out.println("Avslutar...");
                    running = false;
                }
                case "E" -> {
                    System.out.println("Avslutar...");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }

        }

    }

    private static void bestTimeToCharge(TimeAndPrice[] timeAndPrice) {
        if (timeAndPrice != null) {
            new MenuChoice4().execute(timeAndPrice);
        } else {
            System.out.println("Ingen data tillgänglig");
        }
    }
}