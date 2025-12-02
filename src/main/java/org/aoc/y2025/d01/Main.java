package org.aoc.y2025.d01;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        rotationReader data = new rotationReader();
        data.readFile();
        ArrayList<Integer> listOfData = data.getRotationNumbers();
        secretDial secret = new secretDial();

        for (int rotation : listOfData) {
            secret.setPosition(rotation);
        }

        System.out.println("\n======================== Result Part 1 ========================");
        System.out.printf("We managed to get %d Zeroes with the provided rotations.\n", secret.getZeroCounter());
        System.out.println("===============================================================");
    }
}
