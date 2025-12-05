package org.aoc.y2025.d05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        IngredientReader reader = new IngredientReader();
        reader.readFile();
        ArrayList<IngredientBucket> allIngredientBuckets = reader.getAllIngredientBuckets();
        ArrayList<Ingredient> allIngredients = reader.getAllIngredients();
        int freshnessCounter = 0;
        int spoiledCounter = 0;
        long totalUniqueIds = 0;

        for (IngredientBucket bucket : allIngredientBuckets) {
            for (Ingredient ingredient : allIngredients) {
                if (ingredient.getId() >= bucket.getLowerBound() && ingredient.getId() <= bucket.getUpperBound()) {
                    ingredient.setFreshnessState(IngredientState.FRESH);
                }
            }
        }

        for (Ingredient ingredient : allIngredients) {
            if (ingredient.getFreshnessState() == IngredientState.FRESH) {
                freshnessCounter++;
            } else if (ingredient.getFreshnessState() == IngredientState.UNCHECKED) {
                ingredient.setFreshnessState(IngredientState.SPOILED);
                spoiledCounter++;
            }
            System.out.printf("[ID %d] Freshness-State: %s\n", ingredient.getId(), ingredient.getFreshnessState());
        }

        // Part 2 Counter
        Collections.sort(allIngredientBuckets, Comparator.comparingLong(IngredientBucket::getLowerBound));

        ArrayList<IngredientBucket> mergedBuckets = new ArrayList<>();

        ArrayList<Long> lowerBounds = new ArrayList<>();
        ArrayList<Long> upperBounds = new ArrayList<>();

        long prevLowerBound = allIngredientBuckets.getFirst().getLowerBound();
        long prevUpperBound = allIngredientBuckets.getFirst().getUpperBound();

        lowerBounds.add(prevLowerBound);
        upperBounds.add(prevUpperBound);

        for (IngredientBucket bucket : allIngredientBuckets) {
            System.out.printf("Checking lower bound %d / upper bound %d\n", bucket.getLowerBound(), bucket.getUpperBound());
            if (bucket.getLowerBound() < prevUpperBound) {
                lowerBounds.add(bucket.getLowerBound());
                upperBounds.add(bucket.getUpperBound());
                prevUpperBound = bucket.getUpperBound();
                System.out.printf("[Lower Bounds] %s | [Upper Bounds] %s\n", lowerBounds, upperBounds);
            } else if (bucket.getLowerBound() > prevUpperBound) {
                // Hier müsste ich ein neues Objekt erstellen
                IngredientBucket newBucket = new IngredientBucket(Collections.min(lowerBounds), Collections.max(upperBounds));
                System.out.printf("New bucket created with range [ %d - %d ]\n", newBucket.getLowerBound(), newBucket.getUpperBound());
                mergedBuckets.add(newBucket);
                // Jetzt die Temp Arrays clearen und wieder mit befüllen starten.
                lowerBounds.clear();
                upperBounds.clear();
                lowerBounds.add(bucket.getLowerBound());
                upperBounds.add(bucket.getUpperBound());
                System.out.printf("[Lower Bounds] %s | [Upper Bounds] %s\n", lowerBounds, upperBounds);
                prevUpperBound  = bucket.getUpperBound();
            }
        }
        IngredientBucket newBucket = new IngredientBucket(Collections.min(lowerBounds), Collections.max(upperBounds));
        mergedBuckets.add(newBucket);
        System.out.printf("New bucket created with range [ %d - %d ]\n", newBucket.getLowerBound(), newBucket.getUpperBound());

        System.out.println("--------------------------------------------------");
        System.out.printf("Total Buckets before merging: %d | after merging: %d\n", allIngredientBuckets.size(), mergedBuckets.size());
        System.out.println("--------------------------------------------------");

        for (IngredientBucket bucket : mergedBuckets) {
            long result = bucket.getUpperBound() - bucket.getLowerBound() + 1;
            System.out.printf("We calculate %d - %d = %d\n", bucket.getUpperBound(), bucket.getLowerBound(), result);
            totalUniqueIds += result;

        }

        System.out.println("\n========== SOLUTION PART 1 ==============");
        System.out.println("Freshness-State \tStatus");
        System.out.printf("[ Fresh ] \t\t\t%d\n", freshnessCounter);
        System.out.printf("[ Spoiled ] \t\t%d", spoiledCounter);

        System.out.println("\n========== SOLUTION PART 2 ==============");
        System.out.printf("Unique IDs considered fresh: %d\n", totalUniqueIds);
        // Too low: 316839876331379
        // Too high: 344423158480190


    }
}
