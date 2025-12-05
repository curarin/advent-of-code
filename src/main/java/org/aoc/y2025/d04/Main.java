package org.aoc.y2025.d04;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GridFileReader fileReader = new GridFileReader();
        fileReader.readFile();
        ForkliftGrid forkliftGrid = fileReader.getForkliftGrid();
        int totalAccesseblePaperRolls = 0;

        for (GridItem item : forkliftGrid.getGridItems()) {
            //System.out.printf("Coordiates: %d / %d\n", item.getColumnIndex(), item.getRowIndex());
            int paperRollcounter = 0;

            // 2 ^ 3 permutationen von ColumnIndex & RowIndex berechnen
            int[] columnIndices = {item.getColumnIndex() - 1, item.getColumnIndex(), item.getColumnIndex() + 1};
            int[] rowIndices = {item.getRowIndex() - 1, item.getRowIndex(), item.getRowIndex() + 1};

            for (int columnIndex : columnIndices) {
                if (columnIndex >= 0 && columnIndex < forkliftGrid.getMaximumColumnIndex()) {
                    for (int rowIndex : rowIndices) {
                        System.out.printf("[Row: %d | Col: %d] Checking Row %d / Col %d\n", item.getRowIndex(), item.getColumnIndex(), rowIndex, columnIndex);
                        if (rowIndex >= 0 && rowIndex < forkliftGrid.getMaximumRowIndex()) {
                            if (forkliftGrid.getGridItem(rowIndex, columnIndex).getGridItemType() == ItemType.PAPER) {
                                if (item.getId() != forkliftGrid.getGridItem(rowIndex, columnIndex).getId()) {
                                    paperRollcounter++;
                                    System.out.printf("[Row: %d | Col: %d] -> Nearby Paper found (at %d / %d) -> total: %d.\n", item.getRowIndex(), item.getColumnIndex(), rowIndex, columnIndex, paperRollcounter);
                                }
                            }
                        }
                    }
                }
            }
            if (paperRollcounter < 4 && item.getGridItemType() == ItemType.PAPER) {
                System.out.printf("[Row: %d | Col: %d] Paperroll has %d within 8 adjacent Rolls & can be easily accessed.\n", item.getRowIndex(), item.getRowIndex(), paperRollcounter);
                item.markAsAccesable();
            }
            System.out.println("-------------------------------------------------");
        }

        for (GridItem item : forkliftGrid.getGridItems()) {
            if (item.isMarkAsAccessible()) {
                totalAccesseblePaperRolls++;
            }
        }

        System.out.println("========== PART 1 SOLUTION ==========");
        System.out.printf("[Total Count] %d",  totalAccesseblePaperRolls);
    }
}
