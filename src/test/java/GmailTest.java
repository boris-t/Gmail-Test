import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.GooglePage;
import pages.StackPage;

import java.util.concurrent.TimeUnit;

public class GmailTest{

    // Declare driver and base url
    public static WebDriver driver;
    public static String baseUrl;

    // Initialize pages

    GooglePage googlePage = new GooglePage(driver);
    StackPage stackPage = new StackPage(driver);

    // Initialize driver

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-web-security",
                "--user-data-dir",
                "--allow-running-insecure-content");
        baseUrl = "https://stackoverflow.com/users/signup?ssrc=head&returnurl=%2fusers%2fstory%2fcurrent%27";
    }


    // Running tests

    @Test
    public void checkGoogleMail() throws Exception {
        stackPage.loginWithGoogle();
        googlePage.proceedWithGoogle();
        googlePage.deleteFirstLetterFromIncoming();
        googlePage.deleteSpamLettersIfExist();
        googlePage.logOutFromGoogle();
    }

    // Close driver

    @AfterClass
    public static void shutDown() throws Exception {
        driver.quit();
    }


    /** Test without page object



//        driver.findElement(By.cssSelector(loginWithGoogleButton)).click();
//        driver.findElement(By.cssSelector(loginInput)).sendKeys(login);
//        driver.findElement(By.cssSelector(nextLoginButton)).click();
//        waitForStaleness(driver.findElement(By.cssSelector(passwordInput)));
//        driver.findElement(By.cssSelector(passwordInput)).sendKeys(pass);
//        driver.findElement(By.cssSelector(nextPassButton)).click();


//        driver.get("https://mail.google.com");
//
//        driver.findElement(By.cssSelector(enterMail)).click();
//        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(0));
//        driver.close();
//        driver.switchTo().window(tabs2.get(1));
//
//        driver.findElement(By.cssSelector(loginEmail)).click();


//        scrollToElement(driver.findElement(By.cssSelector(incomingButton)));
////        driver.findElement(By.cssSelector(incomingButton)).click();
//        List<WebElement> inboxElements = driver.findElements(By.cssSelector(inboxTableRows));
//        List<WebElement> inboxCheckboxes = driver.findElements(By.cssSelector(inboxTableRowsCheckbox));
//        if (!inboxElements.isEmpty()) {
//            System.out.println("Incoming folder has " + inboxElements.size() + " items");
//            inboxCheckboxes.get(0).click();
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            driver.findElement(By.cssSelector(deleteButton)).click();
//        } else {
//            System.out.println("Incoming folder is empty");
//        }


//        driver.findElement(By.cssSelector(moreButton)).click();
//
//        scrollToElement(driver.findElement(By.cssSelector(spamButton)));
//        driver.findElement(By.cssSelector(spamButton)).click();
//        List<WebElement> spamElements = driver.findElements(By.xpath(spamTableRows));
//        if (!spamElements.isEmpty()) {
//            driver.findElement(By.cssSelector(spamRemoveAll)).click();
//            driver.findElement(By.cssSelector(okButton)).click();
//            waitToDisappear(driver.findElement(By.cssSelector(dialogPopup)));
//        } else {
//            System.out.println("Spam folder is empty");
//        }


//        WebElement more = driver.findElement(By.cssSelector(moreButton));
//        waitForClickable(more).click();


//        driver.findElement(By.cssSelector(accountButton)).click();
//        driver.findElement(By.cssSelector(logoutButton)).click();
//        logoutButton.click();

//    }


//    private String loginWithGoogleButton = "div[id='openid-buttons'] button:nth-child(1)";
//    private String loginInput = "input[type='email']";
//    private String passwordInput = "input[type='password']";
//    private String nextLoginButton = "div[id='identifierNext'] span";
//    private String nextPassButton = "div[id='passwordNext'] span";
//    private String moreButton = "div div[class='n6'] span[role='button']";
//    private String enterMail = "div[class='h-c-header__cta'] ul:nth-child(1) li[class$='g-mail-nav-links'] a[ga-event-action='sign in']";
//    private String loginEmail = "div[id='profileIdentifier']";
//    private String spamButton = "a[title='Spam']";
//    private String spamTableRows = "//div[@class='ya']/../div/../following-sibling::div/div[@class='Cp']//tr";
//    private String inboxTableRows = "div[class='Cp'] tbody tr";
//    private String inboxTableRowsCheckbox = "div[class='Cp'] tbody tr div[role='checkbox']";
//    private String deleteButton = "div[act='10'] div[class='asa']";
//    private String spamRemoveAll = "span[class='x2']";
//    private String dialogPopup = "div[role='alertdialog']:not([style='display: none;'])";
//    private String okButton = "div[role='alertdialog']:not([style='display: none;']) button[name='ok']";
//    //div[contains(@role, 'alertdialog') and not(contains(@style, 'display: none;'))]//button[@name='ok']
//    private String incomingButton = "a[title='Inbox']";
//    private String accountButton = "a[aria-label^='Google Account:']";
//    private String logoutButton = "div[aria-label='Account Information'] a[target='_top']";
//
////    private WebElement logoutButton = driver.findElement(By.cssSelector("div[aria-label='Account Information'] a[target='_top']"));
//

     */
}
