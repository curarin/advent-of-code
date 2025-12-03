package org.aoc.y2025.d03;

import java.util.ArrayList;

public class BatteryBank {
    ArrayList<Battery> batteries = new ArrayList<>();
    int firstVoltage = 0;
    int lastVoltage = 0;
    int lastIndex = 0;

    public ArrayList<Battery> getBatteries() {
        return this.batteries;
    }

    public void addBattery(Battery battery) {
        this.batteries.add(battery);
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public void setFirstVoltage(int firstVoltage) {
        this.firstVoltage = firstVoltage;
    }
    public void setLastVoltage(int lastVoltage) {
        this.lastVoltage = lastVoltage;
    }

    public int getLastIndex() {
        return this.lastIndex;
    }

    public int getLargestVoltageCombination() {
        String firstVoltage = String.valueOf(this.firstVoltage);
        String lastVoltage = String.valueOf(this.lastVoltage);
        String combination =  firstVoltage + lastVoltage;
        System.out.printf("Largest possible voltage: %s\n", combination);
        return Integer.parseInt(combination);
    }
}
