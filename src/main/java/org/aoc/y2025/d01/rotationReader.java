package org.aoc.y2025.d01;

import org.aoc.y2025.d02.numberBucket;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class rotationReader {
    ArrayList<String> inputData;

    public void readFile() {
        ArrayList<String> list = new ArrayList<>();
        Path path = Paths.get("src", "main", "java", "org", "aoc", "y2025", "d01", "rotations.csv");

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

    public ArrayList<Integer> getRotationNumbers() {
        ArrayList<Integer> rotations = new ArrayList<>();

        for (String line : this.inputData) {
            if (line.startsWith("L")) {
                String parsedStrong = line.replace("L", "-");
                int num = Integer.parseInt(parsedStrong);
                rotations.add(num);
            } else if (line.startsWith("R")) {
                String parsedStrong = line.replace("R", "");
                int num = Integer.parseInt(parsedStrong);
                rotations.add(num);
            }
        }
        return rotations;
    }
}
