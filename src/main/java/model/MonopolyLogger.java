package model;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MonopolyLogger {
    public static Logger LOGGER = Logger.getLogger(Monopoly.class.getName());

    public MonopolyLogger() throws IOException {
        FileHandler fileHandler = new FileHandler("monopoly.log");
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(fileHandler);
    }
}
