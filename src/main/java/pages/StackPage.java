package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.ReadProperties;

import java.time.Duration;

public class StackPage {

    static WebDriver driver;

    private static String login = ReadProperties.getLogin();
    private static String pass = ReadProperties.getPassword();
    public String baseUrl = "https://stackoverflow.com/users/signup?ssrc=head&returnurl=%2fusers%2fstory%2fcurrent%27";


    //Locators
    private String loginWithGoogleButton = "div[id='openid-buttons'] button:nth-child(1)";
    private String loginInput = "input[type='email']";
    private String passwordInput = "input[type='password']";
    private String nextLoginButton = "div[id='identifierNext'] span";
    private String nextPassButton = "div[id='passwordNext'] span";


    public StackPage(WebDriver driver) {
        this.driver = driver;
    }

    // Working with page
    public void loginWithGoogle() {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector(loginWithGoogleButton)).click();
        driver.findElement(By.cssSelector(loginInput)).sendKeys(login);
        driver.findElement(By.cssSelector(nextLoginButton)).click();
        waitForStaleness(driver.findElement(By.cssSelector(passwordInput)));
        driver.findElement(By.cssSelector(passwordInput)).sendKeys(pass);
        driver.findElement(By.cssSelector(nextPassButton)).click();
    }

    // Web elements help methods

    private Wait<WebDriver> getWebDriverWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public Boolean waitForStaleness(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.stalenessOf(element));
    }

}
