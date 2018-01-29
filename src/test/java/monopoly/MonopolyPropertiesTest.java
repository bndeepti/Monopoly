package monopoly;

import monopoly.MonopolyProperties;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class MonopolyPropertiesTest {
    MonopolyProperties monopolyProperties;

    Properties properties;

    @Before
    public void setUp() throws IOException {
        InputStream fileStream = this.getClass().getResourceAsStream("/test.monopoly.properties");
        properties = new Properties();
        monopolyProperties = new MonopolyProperties(fileStream, properties);
    }

    @Test
    public void testShouldGetPropertyValue() throws IOException {
        assertEquals("monopoly", monopolyProperties.getProperty("test.message"));
    }
}