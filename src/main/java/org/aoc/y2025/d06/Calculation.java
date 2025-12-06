package org.aoc.y2025.d06;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calculation {
    ArrayList<BigInteger> currentNumbers;
    MathOperation currentOperation;
    BigInteger result;

    public Calculation() {
        currentNumbers = new ArrayList<>();
    }

    public void setMathOperation(MathOperation mathOperation) {
        this.currentOperation = mathOperation;
    }

    public void addNumber(BigInteger number) {
        this.currentNumbers.add(number);
    }

    public BigInteger getResult() {
        if (currentOperation == MathOperation.ADDITION) {
            this.result = BigInteger.valueOf(0);
            for (BigInteger number : this.currentNumbers) {
                this.result = this.result.add(number);
            }
        } else if (currentOperation == MathOperation.MULTIPLICATION) {
            this.result = BigInteger.valueOf(1);
            for (BigInteger number : this.currentNumbers) {
                this.result = this.result.multiply(number);
            }
        }
        return this.result;
    }
}
