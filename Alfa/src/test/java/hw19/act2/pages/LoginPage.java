package hw19.act2.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public LoginPage checkTitle() {
        $("h2").shouldHave(text("Login Page"));
        return this;
    }

    public LoginPage checkElementalSeleniumLink() {
        $x("//a[text()='Elemental Selenium']")
                .shouldBe(visible)
                .shouldHave(text("Elemental Selenium"));

        return this;
    }

    public LoginPage setUsername(String username) {
        $("#username").setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    public SecureAreaPage loginSuccessfully() {
        $("button[type='submit']").click();
        return new SecureAreaPage();
    }

    public LoginPage loginWithInvalidCredentials() {
        $("button[type='submit']").click();
        return this;
    }

    public LoginPage checkInvalidUsernameMessage() {
        $("#flash").shouldHave(text("Your username is invalid!"));
        return this;
    }
}