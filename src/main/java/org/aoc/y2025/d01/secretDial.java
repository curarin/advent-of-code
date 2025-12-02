package org.aoc.y2025.d01;

public class secretDial {
    int currentPosition = 50;
    int zeroCounterPartOne = 0;
    int zeroCounterPartTwo = 0;

    public void setPosition(int positionChangeValue) {
        System.out.println("------------------------------------------");
        String direction = "";
        int oldPosition = this.currentPosition;
        int newPosition = (this.currentPosition + positionChangeValue) % 100;

        boolean positionSurpassedZero = positionHasSurpassedZero(positionChangeValue, oldPosition);

        if (positionChangeValue > 100) {
            int zeroCounterDivider = (int) Math.floor((double) positionChangeValue / 100);
            zeroCounterPartTwo += zeroCounterDivider;
            System.out.printf("We crossed 0 by moving from %d -> %d (for %d many times)\n", oldPosition, newPosition, zeroCounterDivider);
        } else if (positionSurpassedZero) {
            zeroCounterPartTwo++;
            System.out.printf("We crossed 0 by moving from %d -> %d.\n", oldPosition, newPosition);
        }

        if (newPosition < 0) {
            this.currentPosition = newPosition + 100;
        } else {
            this.currentPosition = newPosition;
        }

        if (this.currentPosition == 0) {
            this.zeroCounterPartOne++;
            this.zeroCounterPartTwo++;
        }

        printToStdOut(positionChangeValue, direction, oldPosition, this.currentPosition);
    }

    private static void printToStdOut(int positionChangeValue, String direction, int oldPosition, int newPosition) {
        if (positionChangeValue >= 1) {
            direction = "right";
        } else if (positionChangeValue < 0) {
            direction = "left";
        }
        System.out.printf("We turned %s from %d (by %d) to %d | New position ==> %d \n", direction, oldPosition, positionChangeValue, newPosition, newPosition);
    }

    private boolean positionHasSurpassedZero(int positionChangeValue, int oldPosition) {
        boolean positionSurpassedZero = false;
        if (((this.currentPosition + positionChangeValue > 100) || (this.currentPosition + positionChangeValue < 0)) && oldPosition != 0) {
            positionSurpassedZero = true;
        }
        return positionSurpassedZero;
    }

    public int getZeroCounterPartOne() {
        return this.zeroCounterPartOne;
    }

    public int getZeroCounterPartTwo() {
        return this.zeroCounterPartTwo;
    }
}
