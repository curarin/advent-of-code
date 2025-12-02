package org.aoc.y2025.d02;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> allInvalidIds =  new ArrayList<>();
        ArrayList<numberBucket> allNumberBuckets;
        long finalResult = 0;
        numberReader reader = new numberReader();
        reader.readFile();
        allNumberBuckets = reader.getBuckets();

        for (numberBucket bucket : allNumberBuckets) {
            long currentLowerBound = bucket.getLowerBound();
            long currentUpperBound = bucket.getUpperBound();
            for (long i = currentLowerBound; i >= currentLowerBound && i <= currentUpperBound; i++ ) {
                String toBeChecked = Long.toString(i);

                // Only check even numbers
                if (toBeChecked.length() % 2 == 0) {
                    // Split by half
                    int splitIndexNumber = toBeChecked.length() / 2;

                    // Save each half
                    String firstHalf = toBeChecked.substring(0, splitIndexNumber);
                    String secondHalf = toBeChecked.substring(splitIndexNumber);

                    // Check if both halfs are the same
                    if (firstHalf.equals(secondHalf)) {
                        String invalidId = firstHalf + secondHalf;
                        allInvalidIds.add(invalidId);
                        //System.out.println("New invalid id: " + invalidId);
                    }
                }
            };
        }
        System.out.println("=====================");
        System.out.printf("We current have %d invalid ids.\n",  allInvalidIds.size());

        for (String id : allInvalidIds) {
            finalResult += Long.parseLong(id);
        }
        System.out.printf("Final result: %d\n", finalResult);
    }
}
