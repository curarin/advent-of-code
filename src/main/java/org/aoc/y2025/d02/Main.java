package org.aoc.y2025.d02;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> allInvalidIdsPartOne =  new ArrayList<>();
        ArrayList<String> allInvalidIdsPartTwo =  new ArrayList<>();
        ArrayList<NumberBucket> allNumberBuckets;
        long finalResultPartOne = 0;
        long finalResultPartTwo = 0;
        NumberReader reader = new NumberReader();
        reader.readFile();
        allNumberBuckets = reader.getBuckets();

        for (NumberBucket bucket : allNumberBuckets) {
            long currentLowerBound = bucket.getLowerBound();
            long currentUpperBound = bucket.getUpperBound();
            for (long i = currentLowerBound; i >= currentLowerBound && i <= currentUpperBound; i++ ) {
                String toBeChecked = Long.toString(i);
                if (checkPartOne(toBeChecked)) {
                    allInvalidIdsPartOne.add(toBeChecked);
                }
                if (checkPartTwo(toBeChecked)) {
                    allInvalidIdsPartTwo.add(toBeChecked);
                }
            };
        }
        System.out.println("===================== Part 1 =====================");
        System.out.printf("We current have %d invalid ids.\n",  allInvalidIdsPartOne.size());

        for (String id : allInvalidIdsPartOne) {
            finalResultPartOne += Long.parseLong(id);
        }
        System.out.printf("Final result: %d\n", finalResultPartOne);

        System.out.println("===================== Part 2 =====================");
        System.out.printf("We current have %d invalid ids.\n",  allInvalidIdsPartTwo.size());
        for (String id : allInvalidIdsPartTwo) {
            finalResultPartTwo += Long.parseLong(id);
        }
        System.out.printf("Final result: %d\n", finalResultPartTwo);
    }

    private static boolean checkPartTwo(String toBeChecked) {
        int repeatCounter = 0;

        for (int i = 1; i <= toBeChecked.length() / 2; i++) {
            String prefix = toBeChecked.substring(0, i);

            if (toBeChecked.length() % prefix.length() == 0) {
                int repeatCount = toBeChecked.length() / prefix.length();
                String forecastedString = prefix.repeat(repeatCount);

                if (forecastedString.equals(toBeChecked)) {
                    //System.out.printf("%s | contains invalid id - with prefix %s (repeated %d times)\n", toBeChecked, prefix, repeatCount);
                    if (repeatCount >= 2) {
                        repeatCounter++;
                    }
                }
            }
        }
        return repeatCounter >= 1;
    }

    private static boolean checkPartOne(String toBeChecked) {
        if (toBeChecked.length() % 2 == 0) {
            int splitIndexNumber = toBeChecked.length() / 2;
            String firstHalf = toBeChecked.substring(0, splitIndexNumber);
            String secondHalf = toBeChecked.substring(splitIndexNumber);
            return firstHalf.equals(secondHalf);
        }
        return false;
    }
}
