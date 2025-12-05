package org.aoc.y2025.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BatteryFileReader {
    ArrayList<String> inputData;

    public void readFile() {
        ArrayList<String> list = new ArrayList<>();
        Path path = Paths.get("src", "main", "java", "org", "aoc", "y2025", "d03", "voltages.csv");

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

    public ArrayList<BatteryBank> getBatteryBanks() {
        ArrayList<BatteryBank> allBatteryBanks = new ArrayList<>();
        for (String line : this.inputData) {
            BatteryBank currentBatteryBank = new BatteryBank();
            currentBatteryBank.setLastIndex(line.length() -1 );
            for (int i = 0; i < line.length(); i++) {
                Battery currentBattery = new Battery();
                currentBattery.setVoltage(Integer.parseInt(line.substring(i, i + 1)));
                currentBattery.setIndex(i);
                currentBatteryBank.addBattery(currentBattery);
            }
            allBatteryBanks.add(currentBatteryBank);
        }
        return allBatteryBanks;
    }
}
