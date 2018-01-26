package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MonopolyProperties {
    private Properties properties;
    private InputStream inputStream;

    public MonopolyProperties(InputStream inputStream, Properties properties) throws IOException {
        this.inputStream = inputStream;
        this.properties = properties;
        loadProperties();
    }

    private void loadProperties() throws IOException {
        properties.load(inputStream);
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
