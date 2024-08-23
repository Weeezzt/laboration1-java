package org.example;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MenuChoice1 {
    TimeAndPrice[] timePriceArray = new TimeAndPrice[24];
    String file = "src/elpriser.csv";
    Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("Du valde menyval nummer ett");
        System.out.println();
        System.out.println("Vill du lägga in priserna manuellt eller att det ska ske genom filläsning?");
        System.out.print("Svar med 'F' för genom filläsning och med 'M' för manuellt: ");
        String answer = scanner.nextLine();
        if (answer.equals("f") || answer.equals("F")) {
            assignPricesViaFile();
        } else if (answer.equals("m") || answer.equals("M")) {
            assignPricesManually();
        } else {
            System.out.print("Otillåtet val.. Svara med 'M' eller 'F'! ");
        }


    }
    private void assignPricesViaFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            int index = 0;
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length != 2){
                    System.out.println("Felaktig textrad");
                    continue;
                }
                System.out.println(line); // För att se så det kommer nåt.
                String time = data[0];  // Tid från CSV
                String price = data[1]; // pris från CSV

                try{
                    double priceDouble = Double.parseDouble(price);
                    int priceTimesHundred = (int) (priceDouble * 100);
                    String priceString = String.format("%d", priceTimesHundred);
                    timePriceArray[index] = new TimeAndPrice(time, priceString);
                    index++;
                }catch(NumberFormatException e){
                    System.out.println("Felaktigt prisformat på rad: " + line);
                }
            }
            System.out.println("Priserna har laddats från filen.");
        } catch(IOException e){
            System.out.println("Ett fel inträffade vid läsning av CSV-filen." + e.getMessage());
        }
    }

    private void assignPricesManually() {
        int i = 1;
        while(i < 25) {
            String time = String.format("%02d:00", i);
            System.out.print("Pris mellan " + time + ": ");
            String input = scanner.nextLine();
            if(input.equals("e") || input.equals("E")) {
                System.out.println("Avbryter inmatning och återgår till huvudmenyn.");
                break;
            }
            if (input.trim().isEmpty()) {
                System.out.println("Inget värde angivet. Försök igen.");
                continue;
            }
            try {
                timePriceArray[i - 1] = new TimeAndPrice(time, input);

                // Assign price to the correct index
            } catch (NumberFormatException e) {
                System.out.println("Otillåtet värde, svara med ett nummer");
                continue; // Prompt the user again

            }
            i++;
        }
    }
    public TimeAndPrice[] getPriceArray() {
        return timePriceArray;
    }
}
