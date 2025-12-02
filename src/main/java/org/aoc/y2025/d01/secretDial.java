package org.aoc.y2025.d01;

public class secretDial {
    int currentPosition = 50;
    int zeroCounterPartOne = 0;
    int zeroCounterPartTwo = 0;

    public void setPosition(int positionChangeValue) {
        System.out.println("------------------------------------------");

        int oldPosition = this.currentPosition;
        int newPosition = oldPosition + positionChangeValue;

        newPosition = ((newPosition % 100) + 100) % 100;

        if (newPosition == 0) {
            zeroCounterPartOne++;
        }

        int steps = Math.abs(positionChangeValue);
        int direction = (positionChangeValue > 0) ? 1 : -1;
        int temp = this.currentPosition;

        for (int i = 1; i <= steps; i++) {
            temp += direction;
            temp = ((temp % 100) + 100) % 100;
            if (temp == 0) {
                System.out.println("We surpassed 0 at step " + i);
                zeroCounterPartTwo++;
            }
        }
        this.currentPosition = newPosition;

        printToStdOut(positionChangeValue, oldPosition, this.currentPosition);
    }

    private static void printToStdOut(int positionChangeValue, int oldPosition, int newPosition) {
        String direction = "";
        if (positionChangeValue >= 1) {
            direction = "right";
        } else if (positionChangeValue < 0) {
            direction = "left";
        }
        System.out.printf("We turned %s from %d (by %d) to %d | New position ==> %d \n",
                direction, oldPosition, positionChangeValue, newPosition, newPosition);
    }

    public int getZeroCounterPartOne() {
        return this.zeroCounterPartOne;
    }

    public int getZeroCounterPartTwo() {
        return this.zeroCounterPartTwo;
    }
}
