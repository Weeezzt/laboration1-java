package org.example;

public class MenuChoice4 {
    public void execute(TimeAndPrice[] array) {
        System.out.println("Du valde menyval nummer fyra");
        if (array == null || array.length < 4) {
            System.out.println("Inte tillräckligt med data");
            return;
        }
        // Initialize variables
        int windowSize = 4;
        int minSum = Integer.MAX_VALUE;
        int minStartIndex = 0;

        // Compute the sum for the first window
        int currentSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currentSum += Integer.parseInt(array[i].price);
        }

        minSum = currentSum;

        for (int i = windowSize; i < array.length; i++) {
            currentSum = currentSum - Integer.parseInt(array[i - windowSize].price) + Integer.parseInt(array[i].price);

            if (currentSum < minSum) {
                minSum = currentSum;
                minStartIndex = i - windowSize + 1;
            }
        }

        int tot = 0;

        // Print the result
        System.out.println("Om du vill ladda din bil i fyra timmar för så lite pengar som möjligt är dessa de billigaste fyra timmarna i streck:");
        for (int i = minStartIndex; i < minStartIndex + windowSize; i++) {
            System.out.println(array[i].time + ": " + array[i].price + " öre");
            tot += Integer.parseInt(array[i].price);

        }
        System.out.println("Totalt pris: " + minSum + " öre");
        System.out.println("Genomsnittspriset: " + (tot / 4) + " öre/h");

    }
}
