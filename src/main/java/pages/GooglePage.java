package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    //Locators

    private SelenideElement moreButton = $("div div[class='n6'] span[role='button']");
    private SelenideElement enterMail = $("div[class='h-c-header__cta'] ul:nth-child(1) li[class$='g-mail-nav-links'] a[ga-event-action='sign in']");
    private SelenideElement loginEmail = $("div[id='profileIdentifier']");
    private SelenideElement spamButton = $("a[title='Spam']");
    private ElementsCollection spamTableRows = $$x("//div[@class='ya']/../div/../following-sibling::div/div[@class='Cp']//tr");
    private ElementsCollection inboxTableRows = $$("div[class='Cp'] tbody tr");
    private ElementsCollection inboxTableRowsCheckbox = $$("div[class='Cp'] tbody tr div[role='checkbox']");
    private SelenideElement deleteButton = $("div[act='10'] div[class='asa']");
    private SelenideElement spamRemoveAll = $("span[class='x2']");
    private SelenideElement dialogPopup = $("div[role='alertdialog']:not([style='display: none;'])");
    private SelenideElement okButton = $("div[role='alertdialog']:not([style='display: none;']) button[name='ok']");
    private SelenideElement incomingButton = $("a[title='Inbox']");
    private SelenideElement accountButton = $("a[aria-label^='Google Account:']");
    private SelenideElement logoutButton = $("div[aria-label='Account Information'] a[target='_top']");


    // Working with page

    public void proceedWithGoogle() {
        Selenide.open("https://mail.google.com");
        enterMail.click();
        Selenide.switchTo().window(0).close();
        Selenide.switchTo().window(0);
        loginEmail.click();
    }

    public void deleteFirstLetterFromIncoming() {
        incomingButton.scrollTo();

        if (!inboxTableRows.isEmpty()) {
            System.out.println("Incoming folder has " + inboxTableRows.size() + " items");
            inboxTableRowsCheckbox.get(0).click();
            deleteButton.click();
        } else {
            System.out.println("Incoming folder is empty");
        }
    }

    public void deleteSpamLettersIfExist() {
        moreButton.click();
        spamButton.scrollTo().click();
        if (!spamTableRows.isEmpty()) {
            spamRemoveAll.click();
            okButton.click();
            dialogPopup.should(disappear);
        } else {
            System.out.println("Spam folder is empty");
        }
    }

    public void logOutFromGoogle() {
        accountButton.click();
        logoutButton.click();
    }

}
