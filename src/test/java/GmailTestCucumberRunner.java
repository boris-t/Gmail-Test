import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        features = {
                "src/test/features/",
        },
        glue = {"steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
@RunWith(Cucumber.class)
public class GmailTestCucumberRunner {

    @BeforeClass
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.timeout = 4000;
    }

    @AfterClass
    public static void shutDown() {
        Selenide.closeWebDriver();
    }

}
