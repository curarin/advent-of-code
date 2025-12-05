package org.aoc.y2025.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IngredientReader {
    ArrayList<String> ingredientIdData = new ArrayList<>();
    ArrayList<String> bucketData = new ArrayList<>();

    public void readFile() {
        Path path = Paths.get("src", "main", "java", "org", "aoc", "y2025", "d05", "ingredients.csv");

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains("-")) {
                    bucketData.add(line);
                    System.out.println(line);

                } else if (!line.isEmpty()) {
                    ingredientIdData.add(line);
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Read " + bucketData.size() + " buckets from CSV file");
        System.out.println("Read " + ingredientIdData.size() + " ids from CSV file");
    }

    public ArrayList<IngredientBucket> getAllIngredientBuckets() {
        ArrayList<IngredientBucket> buckets = new ArrayList<>();
        for (String line : this.bucketData) {
            String[] values = line.split("-");
            IngredientBucket currentBucket = new IngredientBucket(Long.parseLong(values[0]), Long.parseLong(values[1]));
            buckets.add(currentBucket);
        }
        return buckets;
    }

    public ArrayList<Ingredient> getAllIngredients() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (String line : this.ingredientIdData) {
            Ingredient currentIngredient = new Ingredient(Long.parseLong(line));
            ingredients.add(currentIngredient);
        }
        return ingredients;
    }
}
