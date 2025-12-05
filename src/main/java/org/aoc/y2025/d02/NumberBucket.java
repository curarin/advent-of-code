package org.aoc.y2025.d02;

public class NumberBucket {
    private final long lowerBound;
    private final long upperBound;

    public NumberBucket(long lowerBound, long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public long getLowerBound() {
        return lowerBound;
    }

    public long getUpperBound() {
        return upperBound;
    }
}
