package org.aoc.y2025.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class numberReader {
    ArrayList<String> inputData;

    public void readFile() {
        ArrayList<String> list = new ArrayList<>();
        Path path = Paths.get("src", "main", "java", "org", "aoc", "y2025", "d02", "numbers.csv");

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
                System.out.println(line);
            }
            System.out.println("Read " + list.size() + " numbers from CSV file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.inputData =  list;
    }

    public ArrayList<numberBucket> getBuckets() {
        ArrayList<numberBucket> buckets = new ArrayList<>();

        for (String line : this.inputData) {
            String[] values = line.split("-");
            numberBucket currentBucket = new numberBucket(Long.parseLong(values[0]), Long.parseLong(values[1]));
            buckets.add(currentBucket);
        }
        return buckets;
    }
}
