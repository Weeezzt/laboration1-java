package org.example;

public class MenuChoice2 {
    public void execute(TimeAndPrice[] array) {
        System.out.println("Du valde menyval nummer två");
        if (array == null || array.length == 0) {
            System.out.println("Ingen data tillgänglig.");
            return;
        }
        int total = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (TimeAndPrice timeAndPrice : array) {
            try {
                // Convert the price from String to int
                int price = Integer.parseInt(timeAndPrice.price);
                total += price;

                if (price > maxValue) {
                    maxValue = price;
                }
                if (price < minValue) {
                    minValue = price;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format: " + timeAndPrice.price);
            }
        }
        int average = total / array.length;
        System.out.println("The average cost is " + average + " öre");
        System.out.println("The most expensive is " + maxValue + " öre");
        System.out.println("The least expensive is " + minValue + " öre");
    }

}
