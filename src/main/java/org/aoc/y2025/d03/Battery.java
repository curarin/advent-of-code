package org.aoc.y2025.d03;

public class Battery {
    private int voltage;
    private int index;

    public void setVoltage(int voltage) {
        if (voltage > 0 && voltage < 10) {
            this.voltage = voltage;
        } else {
            System.out.println("Battery voltage out of range");
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getVoltage() {
        return this.voltage;
    }

    public int getIndex() {
        return this.index;
    }
}
