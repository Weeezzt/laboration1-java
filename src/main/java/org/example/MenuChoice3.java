package org.example;

public class MenuChoice3 {
    public void execute(TimeAndPrice[] array) {
        System.out.println("Du valde menyval nummer tre");
        System.out.println();
        System.out.println("Här är en lista med de billigaste till dyraste timmarna!");
        System.out.println();

        for (TimeAndPrice timeAndPrice : array) {
            System.out.println(timeAndPrice.time + ": " + timeAndPrice.price + " öre");
        }

    }
}
