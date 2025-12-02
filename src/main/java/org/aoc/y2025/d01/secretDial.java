package org.aoc.y2025.d01;

public class secretDial {
    int currentPosition = 50;
    int zeroCounterPartOne = 0;
    int zeroCounterPartTwo = 0;

    public void setPosition(int positionChangeValue) {
        System.out.println("------------------------------------------");
        String direction = "";
        int initalChangeValue = positionChangeValue;
        int oldPosition = this.currentPosition;
        int newPosition = this.currentPosition + positionChangeValue % 100;
        boolean positionSurpassedZero = false;

        if (((this.currentPosition + positionChangeValue > 100) || (this.currentPosition + positionChangeValue < 0)) && oldPosition != 0) {
            positionSurpassedZero = true;
            System.out.printf("%d  %d yields to WE PASSED ZERO", this.currentPosition, positionChangeValue);
        }

        if (positionChangeValue > 100) {
            zeroCounterPartTwo += (int) Math.floor((double) positionChangeValue / 100);
            System.out.println("We crossed 0 with " + newPosition);
        } else if (positionSurpassedZero) {
            zeroCounterPartTwo++;
            System.out.println("We crossed 0 with " + newPosition);
        }

        if (newPosition < 0) {
            this.currentPosition = newPosition + 100;
        } else if (newPosition > 99) {
            this.currentPosition = newPosition - 100;
        } else {
            this.currentPosition = newPosition;
        }

        if (this.currentPosition == 0) {
            this.zeroCounterPartOne++;
            this.zeroCounterPartTwo++;
        }

        if (positionChangeValue >= 1) {
            direction = "right";
        } else if (positionChangeValue < 0) {
            direction = "left";
        }
        System.out.printf("We turned | %s | by %d | New position ==> %d (initial change value was %d)\n", direction, positionChangeValue, this.currentPosition, initalChangeValue);
    }

    public int getZeroCounterPartOne() {
        return this.zeroCounterPartOne;
    }

    public int getZeroCounterPartTwo() {
        return this.zeroCounterPartTwo;
    }
}
