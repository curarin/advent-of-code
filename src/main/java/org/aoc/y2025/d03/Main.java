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
            int currentMaxIndex = batteryBank.getLastIndex();
            int currentNumIndex = 0;
            int currentMaxNum = 0;
            for (Battery battery : batteryBank.getBatteries()) {
                if ((battery.getIndex() > currentNumIndex) && (battery.getVoltage() > currentMaxNum) && (battery.getIndex() != currentMaxIndex)) {
                    System.out.printf("Current Max Index: %d | Voltage %d | New highest set.\n", currentMaxIndex, battery.getVoltage());
                }
                currentMaxIndex -= 1;
                batteryBank.setVoltagesForPartTwo(currentMaxNum);
            }
            System.out.println(batteryBank.getVoltagesForPartTwo());


        }

        System.out.println("========== SOLUTION PART 1 ==========");
        System.out.println("Largest possible voltage: " + totalOutputVoltage);


    }
}
