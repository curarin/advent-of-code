package org.aoc.y2025.d04;

public class GridItem {
    private final ItemType gridItemType;
    private final int columnIndex;
    private final int rowIndex;
    private boolean markAsAccessible;
    private final int id;

    public GridItem(ItemType gridItemType,  int columnIndex, int rowIndex, int id) {
        this.gridItemType = gridItemType;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.markAsAccessible = false;
        this.id = id;
    }

    public ItemType getGridItemType() {
        return this.gridItemType;
    }

    public void markAsAccesable() {
        this.markAsAccessible = true;
    }

    public boolean isMarkAsAccessible() {
        return this.markAsAccessible;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public int getId() {
        return this.id;
    }
}
