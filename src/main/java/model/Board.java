package model;

import cell.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Cell> cells = new ArrayList<>();

    public void init(String cellPositionsAndTypes, MonopolyProperties monopolyProperties) {
        List<String> cellPositionsAndTypesList = Arrays.asList(cellPositionsAndTypes.split(","));
        cellPositionsAndTypesList.forEach(cellPositionAndType -> cells.add(createCell(cellPositionAndType, monopolyProperties)));
    }

    private Cell createCell(String cellPositionAndType, MonopolyProperties monopolyProperties) {
        switch (cellPositionAndType) {
            case "J":
                int fine = Integer.parseInt(monopolyProperties.getProperty("jail.fine"));
                return new JailCell(fine);
            case "T":
                int value = Integer.parseInt(monopolyProperties.getProperty("treasure.value"));
                return new TreasureCell(value);
            case "H":
                int cost = Integer.parseInt(monopolyProperties.getProperty("hotel.cost"));
                int rent = Integer.parseInt(monopolyProperties.getProperty("hotel.rent"));
                return new HotelCell(cost, rent);
            case "E":
                return new EmptyCell();
        }
        return new EmptyCell();
    }

    public Cell getCell(int index) {
        return cells.get(index);
    }

    public int length() {
        return cells.size();
    }
}
