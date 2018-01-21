package model;

import cell.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Cell> cells = new ArrayList<>();

    public void init(String cellPositionsAndTypes) {
        List<String> cellPositionsAndTypesList = Arrays.asList(cellPositionsAndTypes.split(","));
        cellPositionsAndTypesList.forEach(cellPositionAndType -> cells.add(createCell(cellPositionAndType)));
    }

    private Cell createCell(String cellPositionAndType) {
        switch (cellPositionAndType) {
            case "J":
                return new JailCell();
            case "T":
                return new TreasureCell();
            case "H":
                return new HotelCell();
            case "E":
                return new EmptyCell();
        }
        return new EmptyCell();
    }

    public Cell getCell(int index) {
        return cells.get(index);
    }
}
