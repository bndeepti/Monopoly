package cell;

import model.MonopolyProperties;

public class CellFactory {
    public Cell createCell(String cellPositionAndType, MonopolyProperties monopolyProperties) {
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
}
