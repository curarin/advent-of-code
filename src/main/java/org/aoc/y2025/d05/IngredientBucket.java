package org.aoc.y2025.d05;

public class IngredientBucket {
    private final long lowerBound;
    private final long upperBound;

    public IngredientBucket(long lowerBound, long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public long getLowerBound() {
        return this.lowerBound;
    }
    public long getUpperBound() {
        return this.upperBound;
    }
}
