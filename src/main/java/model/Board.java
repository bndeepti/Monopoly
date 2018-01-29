package model;

import cell.Cell;
import cell.CellFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Cell> cells = new ArrayList<>();
    private CellFactory cellFactory;

    public Board(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    public void init(String cellPositionsAndTypes, MonopolyProperties monopolyProperties) {
        List<String> cellPositionsAndTypesList = Arrays.asList(cellPositionsAndTypes.split(","));
        cellPositionsAndTypesList.forEach(cellPositionAndType -> cells.add(cellFactory.createCell(cellPositionAndType, monopolyProperties)));
    }

    public Cell getCell(int index) {
        return cells.get(index);
    }

    public int length() {
        return cells.size();
    }
}
