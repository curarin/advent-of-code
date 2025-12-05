package org.aoc.y2025.d04;

import java.util.ArrayList;

public class ForkliftGrid {
    ArrayList<GridItem> gridItems = new ArrayList<>();

    public void addGridItem(GridItem gridItem) {
        this.gridItems.add(gridItem);
    }

    public ArrayList<GridItem> getGridItems() {
        return this.gridItems;
    }

    public GridItem getGridItem(int i) {
        return this.gridItems.get(i);
    }
}
