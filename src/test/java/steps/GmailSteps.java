package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;
import pages.StackPage;

public class GmailSteps {

    StackPage stackPage = new StackPage();
    GooglePage googlePage = new GooglePage();

    @Given("open stack overflow page and login with google account")
    public void openStackOverflowPageAndLoginWithGoogleAccount() {
        stackPage.loginWithGoogle();
    }

    @Given("proceed with google account")
    public void proceedWithGoogleAccount() {
        googlePage.proceedWithGoogle();
    }

    @When("delete first letter from Incoming")
    public void deleteFirstLetterFromIncoming() {
        googlePage.deleteFirstLetterFromIncoming();
    }

    @When("delete spam messages if they exist")
    public void deleteSpamMessagesIfTheyExist() {
        googlePage.deleteSpamLettersIfExist();
    }

    @Then("log out")
    public void logOut() {
        googlePage.logOutFromGoogle();
    }

}
