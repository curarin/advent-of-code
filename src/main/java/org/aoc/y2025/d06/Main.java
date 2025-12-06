package org.aoc.y2025.d06;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CalculationReader reader = new CalculationReader();
        ArrayList<Calculation> calculations = reader.getCalculations();
        BigInteger finalResult = BigInteger.ZERO;

        for (Calculation calculation : calculations) {
            finalResult = finalResult.add(calculation.getResult());
        }
        System.out.println("====== PART 1 SOLUTION ======");
        System.out.println(finalResult);
    }
}
