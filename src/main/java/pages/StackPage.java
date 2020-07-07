package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utilities.ReadProperties;

import static com.codeborne.selenide.Selenide.$;

public class StackPage {

    private static String login = ReadProperties.getLogin();
    private static String pass = ReadProperties.getPassword();
    public String baseUrl = "https://stackoverflow.com/users/signup?ssrc=head&returnurl=%2fusers%2fstory%2fcurrent%27";


    //Locators
    private SelenideElement loginWithGoogleButton = $("div[id='openid-buttons'] button:nth-child(1)");
    private SelenideElement loginInput = $("input[type='email']");
    private SelenideElement passwordInput = $("input[type='password']");
    private SelenideElement nextLoginButton = $("div[id='identifierNext'] span");
    private SelenideElement nextPassButton = $("div[id='passwordNext'] span");


    // Working with page
    public void loginWithGoogle() {
        Selenide.open(baseUrl);
        loginWithGoogleButton.click();
        loginInput.val(login);
        nextLoginButton.click();
        passwordInput.shouldBe(Condition.enabled).val(pass);
        nextPassButton.click();
    }

}
