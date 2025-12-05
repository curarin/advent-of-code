package org.aoc.y2025.d05;

public class Ingredient {
    private final long id;
    IngredientState currentFreshnessState;

    public Ingredient(long id) {
        this.id = id;
        this.currentFreshnessState = IngredientState.UNCHECKED;
    }

    public long getId() {
        return this.id;
    }

    public void setFreshnessState(IngredientState ingredientState) {
        this.currentFreshnessState = ingredientState;
    }

    public IngredientState getFreshnessState() {
        return this.currentFreshnessState;
    }


}
