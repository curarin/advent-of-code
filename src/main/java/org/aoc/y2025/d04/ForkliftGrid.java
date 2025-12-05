package org.aoc.y2025.d04;

import java.util.ArrayList;

public class ForkliftGrid {
    private ArrayList<GridItem> gridItems = new ArrayList<>();
    private int maximumRowIndex;
    private int maximumColumnIndex;

    public void addGridItem(GridItem gridItem) {
        this.gridItems.add(gridItem);
    }

    public ArrayList<GridItem> getGridItems() {
        return this.gridItems;
    }

    public void setMaximumRowIndex(int maximumRowIndex) {
        this.maximumRowIndex = maximumRowIndex;
        System.out.printf("Maximum Row Index set: %d\n", this.maximumRowIndex);
    }

    public void setMaximumColumnIndex(int maximumColumnIndex) {
        this.maximumColumnIndex = maximumColumnIndex;
        System.out.printf("Maximum Column Index set: %d\n", this.maximumColumnIndex);
    }

    public int getMaximumRowIndex() {
        return this.maximumRowIndex;
    }
    public int getMaximumColumnIndex() {
        return this.maximumColumnIndex;
    }

    public GridItem getGridItem(int rowIndex, int columnIndex) {
        for (GridItem gridItem : this.gridItems) {
            if (gridItem.getRowIndex() == rowIndex && gridItem.getColumnIndex() == columnIndex) {
                return gridItem;
            }
        }
        return null;
    }
}
