package org.aoc.y2025.d04;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GridFileReader fileReader = new GridFileReader();
        fileReader.readFile();
        ForkliftGrid forkliftGrid = fileReader.getForkliftGrid();

        ForkliftGrid markedForkliftGrid = new ForkliftGrid();

        int iteratorCounter = 0;
        for (GridItem item : forkliftGrid.getGridItems()) {
            // Anzahl an PAPER ENUMs vorher zählen
            // Anzahl an Paper ENUMs nacher zählen
            int paperBefore = 0;
            int paperAfter = 0;

            for (int i = iteratorCounter - 5; i < iteratorCounter; i++) {
                if (i >= 0) {
                    if (forkliftGrid.getGridItem(i).getGridItemType() == ItemType.PAPER) {
                        paperBefore++;
                    }
                }
            }

            for (int i = iteratorCounter + 1; i < iteratorCounter + 5 && i < forkliftGrid.getGridItems().size(); i++) {
                if (i <= forkliftGrid.getGridItems().size()) {
                    if (forkliftGrid.getGridItem(i).getGridItemType() == ItemType.PAPER) {
                        paperAfter++;
                    }
                }
            }

            if ((paperBefore < 4 || paperAfter < 4) && item.getGridItemType() == ItemType.PAPER) {
                System.out.printf("Index %d -> Marked as CAN BE ACCESSED\n", iteratorCounter);
            }


            System.out.printf("Index %d -> %s\n", iteratorCounter, item.getGridItemType());
            System.out.printf("Paper before: %d | Paper after: %d\n", paperBefore, paperAfter);
            System.out.println("====================");

            iteratorCounter++;
        }
    }
}
