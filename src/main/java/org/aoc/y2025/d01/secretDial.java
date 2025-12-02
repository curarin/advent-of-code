package org.aoc.y2025.d01;

public class secretDial {
    int currentPosition = 50;
    int zeroCounter = 0;

    public void setPosition(int positionChangeValue) {
        String direction = "";
        int initalChangeValue = positionChangeValue;

        int newPosition = this.currentPosition + positionChangeValue % 100;

        if (newPosition < 0) {
            this.currentPosition = newPosition + 100;
        } else if (newPosition > 99) {
            this.currentPosition = newPosition - 100;
        } else {
            this.currentPosition = newPosition;
        }

        if (this.currentPosition == 0) {
            this.zeroCounter++;
        }

        if (positionChangeValue >= 1) {
            direction = "right";
        } else if (positionChangeValue < 0) {
            direction = "left";
        }
        System.out.printf("We turned | %s | by %d | New position ==> %d (initial change value was %d)\n", direction, positionChangeValue, this.currentPosition, initalChangeValue);

    }

    public int getZeroCounter() {
        return this.zeroCounter;
    }
}
