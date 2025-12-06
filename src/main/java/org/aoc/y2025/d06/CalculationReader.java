package org.aoc.y2025.d06;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class CalculationReader {
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> mathOperations = new ArrayList<>();
    int columnCount = 0;

    public CalculationReader() {
        readFile();
    }

    public void readFile() {
        Path path = Paths.get("src", "main", "java", "org", "aoc", "y2025", "d06", "operations.csv");
        ArrayList<Integer> columnCountValues =  new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim().replaceAll(" +", ";");
                String[] values = line.split(";");
                columnCountValues.add(values.length);

                if (line.matches(".*[0-9].*")) {
                    numbers.addAll(Arrays.asList(values));
                    System.out.println("Added to numbers: " + line);

                } else if (line.matches(".*[*+].*")) {
                    mathOperations.addAll(Arrays.asList(values));
                    System.out.println("Added to math operations: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Read " + numbers.size() + " numbers from CSV file");
        System.out.println("Read " + mathOperations.size() + " operation symbols from CSV file");
        this.columnCount = columnCountValues.getFirst();
    }

    public ArrayList<Calculation> getCalculations() {
        ArrayList<Calculation> calculations = new ArrayList<>();

        for (int i = 0; i < this.columnCount; i++) {
            Calculation currentCalculation = new Calculation();
            String currentOperationSymbol = mathOperations.get(i);
            switch (currentOperationSymbol) {
                case "+" -> currentCalculation.setMathOperation(MathOperation.ADDITION);
                case "*" -> currentCalculation.setMathOperation(MathOperation.MULTIPLICATION);
            }
            calculations.add(currentCalculation);
        }

        for (int i = 0; i < numbers.size(); i++) {
            int relevantIndex = i % this.columnCount;
            Calculation relevantCalculation = calculations.get(relevantIndex);
            String currentNumber = numbers.get(i);
            System.out.printf("Current number is: %s\n", currentNumber);
            relevantCalculation.addNumber(new BigInteger(currentNumber));
        }

        int blubb = 0;
        for (Calculation calculation : calculations) {
            System.out.printf("Calculation [%s] -> %s | %s\n", blubb, calculation.currentNumbers, calculation.currentOperation);
            blubb++;
        }

        return calculations;

    }
}
