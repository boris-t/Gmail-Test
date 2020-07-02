package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GooglePage {

    static WebDriver driver;

    //Locators

    private String moreButton = "div div[class='n6'] span[role='button']";
    private String enterMail = "div[class='h-c-header__cta'] ul:nth-child(1) li[class$='g-mail-nav-links'] a[ga-event-action='sign in']";
    private String loginEmail = "div[id='profileIdentifier']";
    private String spamButton = "a[title='Spam']";
    private String spamTableRows = "//div[@class='ya']/../div/../following-sibling::div/div[@class='Cp']//tr";
    private String inboxTableRows = "div[class='Cp'] tbody tr";
    private String inboxTableRowsCheckbox = "div[class='Cp'] tbody tr div[role='checkbox']";
    private String deleteButton = "div[act='10'] div[class='asa']";
    private String spamRemoveAll = "span[class='x2']";
    private String dialogPopup = "div[role='alertdialog']:not([style='display: none;'])";
    private String okButton = "div[role='alertdialog']:not([style='display: none;']) button[name='ok']";
    //div[contains(@role, 'alertdialog') and not(contains(@style, 'display: none;'))]//button[@name='ok']
    private String incomingButton = "a[title='Inbox']";
    private String accountButton = "a[aria-label^='Google Account:']";
    private String logoutButton = "div[aria-label='Account Information'] a[target='_top']";

    public GooglePage(WebDriver driver) {
        GooglePage.driver = driver;
    }

    // Working with page

    public void proceedWithGoogle() {
        driver.get("https://mail.google.com");

        driver.findElement(By.cssSelector(enterMail)).click();
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        driver.findElement(By.cssSelector(loginEmail)).click();
    }

    public void deleteFirstLetterFromIncoming() {
        scrollToElement(driver.findElement(By.cssSelector(incomingButton)));
        List<WebElement> inboxElements = driver.findElements(By.cssSelector(inboxTableRows));
        List<WebElement> inboxCheckboxes = driver.findElements(By.cssSelector(inboxTableRowsCheckbox));
        if (!inboxElements.isEmpty()) {
            System.out.println("Incoming folder has " + inboxElements.size() + " items");
            inboxCheckboxes.get(0).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(deleteButton)).click();
        } else {
            System.out.println("Incoming folder is empty");
        }
    }

    public void deleteSpamLettersIfExist() {
        driver.findElement(By.cssSelector(moreButton)).click();
        scrollToElement(driver.findElement(By.cssSelector(spamButton)));
        driver.findElement(By.cssSelector(spamButton)).click();
        List<WebElement> spamElements = driver.findElements(By.xpath(spamTableRows));
        if (!spamElements.isEmpty()) {
            driver.findElement(By.cssSelector(spamRemoveAll)).click();
            driver.findElement(By.cssSelector(okButton)).click();
            waitToDisappear(driver.findElement(By.cssSelector(dialogPopup)));
        } else {
            System.out.println("Spam folder is empty");
        }
    }

    public void logOutFromGoogle() {
        driver.findElement(By.cssSelector(accountButton)).click();
        driver.findElement(By.cssSelector(logoutButton)).click();
    }

    // Web elements help methods

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }


    public Boolean waitToDisappear(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.invisibilityOf(element));
    }

    private Wait<WebDriver> getWebDriverWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

}
