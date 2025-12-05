package org.aoc.y2025.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GridFileReader {
    ArrayList<String> inputData;

    public void readFile() {
        ArrayList<String> list = new ArrayList<>();
        Path path = Paths.get("src", "main", "java", "org", "aoc", "y2025", "d04", "forklift.csv");

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

    public ForkliftGrid getForkliftGrid() {
        ForkliftGrid forkliftGrid = new ForkliftGrid();
        for (String line : this.inputData) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '.') {
                    GridItem gridItem = new GridItem(ItemType.GROUND);
                    forkliftGrid.addGridItem(gridItem);
                } else if (line.charAt(i) == '@') {
                    GridItem gridItem = new GridItem(ItemType.PAPER);
                    forkliftGrid.addGridItem(gridItem);
                }
            }
        }
        return forkliftGrid;
    }
}
