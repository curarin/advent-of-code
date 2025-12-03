package org.aoc.y2025.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<BatteryBank> allBatteryBanks = new ArrayList<>();
        BatteryFileReader sourceFile = new BatteryFileReader();
        sourceFile.readFile();
        allBatteryBanks = sourceFile.getBatteryBanks();
        int totalOutputVoltage = 0;

        for (BatteryBank batteryBank : allBatteryBanks) {
            System.out.println("============ NEW BATTERY BANK ============");
            int firstNum = 0;
            int firstNumIndex = 0;
            int secondNum = 0;
            int secondNumIndex = 0;

            // Get first integer
            for (Battery battery : batteryBank.getBatteries()) {
                if ((battery.getVoltage() > firstNum) && (battery.getIndex() != batteryBank.getLastIndex())) {
                    firstNum = battery.getVoltage();
                    firstNumIndex = battery.getIndex();
                    System.out.printf("[First Num] Index %d | Voltage %d | New highest set.\n", firstNumIndex, battery.getVoltage());
                }
            }
            batteryBank.setFirstVoltage(firstNum);

            // Get second integer
            for (Battery battery : batteryBank.getBatteries()) {
                if ((battery.getIndex() > firstNumIndex) && (battery.getVoltage() > secondNum)) {
                    secondNum = battery.getVoltage();
                    secondNumIndex = battery.getIndex();
                    System.out.printf("[Second Num] Index %d | Voltage %d | New highest set.\n", secondNumIndex, battery.getVoltage());
                }
            }
            batteryBank.setLastVoltage(secondNum);
            totalOutputVoltage += batteryBank.getLargestVoltageCombination();

            // Part 2 Logic
            // Offen -> wenn eines gefunden wurde müssen wir weiter shiften
            // Index Start auf den MaxIndex des alten erhöhen
            // Index End auf max - 12 (+1)
            int indexEnd = batteryBank.getLastIndex() - 12;
            int indexStart = 0;
            int currentMaxNum = 0;
            int currentMaxIndex = 0;

            for (int i = indexStart; i <= indexEnd; i++) {
                Battery currentBattery = batteryBank.getBattery(i);
                if (currentBattery.getVoltage() > currentMaxNum) {
                    currentMaxNum = currentBattery.getVoltage();
                    currentMaxIndex = i;
                }
                System.out.printf("[Part 2 Logic] Index %d | Voltage %d -> new max set: %d (from index: %d)\n", currentBattery.getIndex(), currentBattery.getVoltage(), currentMaxNum, currentMaxIndex);
            }
        }

        System.out.println("========== SOLUTION PART 1 ==========");
        System.out.println("Largest possible voltage: " + totalOutputVoltage);


    }
}
