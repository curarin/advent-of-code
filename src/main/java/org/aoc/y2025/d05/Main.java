package org.aoc.y2025.d05;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        IngredientReader reader = new IngredientReader();
        reader.readFile();
        ArrayList<IngredientBucket> allIngredientBuckets = reader.getAllIngredientBuckets();
        ArrayList<Ingredient> allIngredients = reader.getAllIngredients();
        int freshnessCounter = 0;
        int spoiledCounter = 0;

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
        // OutOfMemory Exception, rip
        HashSet<Long> allUniqueIds = new HashSet<Long>();
        for (IngredientBucket bucket : allIngredientBuckets) {
            long startId = bucket.getLowerBound();
            long endId = bucket.getUpperBound();
            for (long i = startId; i <= endId; i++) {
                allUniqueIds.add(i);
                System.out.printf(".");
            }
        }

        System.out.println("\n========== SOLUTION PART 1 ==============");
        System.out.println("Freshness-State \tStatus");
        System.out.printf("[ Fresh ] \t\t\t%d\n", freshnessCounter);
        System.out.printf("[ Spoiled ] \t\t%d", spoiledCounter);

        System.out.println("\n========== SOLUTION PART 2 ==============");
        System.out.printf("Unique IDs considered fresh: %d\n", allUniqueIds.size());


    }
}
