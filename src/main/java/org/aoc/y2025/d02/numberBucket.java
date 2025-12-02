package org.aoc.y2025.d02;

public class numberBucket {
    private final long lowerBound;
    private final long upperBound;

    public numberBucket(long lowerBound, long upperBound) {
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
