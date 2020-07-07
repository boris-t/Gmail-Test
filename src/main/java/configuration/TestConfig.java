package configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestConfig {

    @BeforeClass
    public static void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterClass
    public static void shutDown() {
        Selenide.closeWebDriver();
    }

}
