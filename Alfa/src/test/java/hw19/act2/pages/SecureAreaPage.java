package hw19.act2.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SecureAreaPage {

    public SecureAreaPage checkSuccessfulLoginMessage() {
        $("#flash")
                .shouldHave(text("You logged into a secure area!"));

        return this;
    }

    public SecureAreaPage checkLogoutButton() {
        $("a.button")
                .shouldBe(visible)
                .shouldHave(text("Logout"));

        return this;
    }

    public LoginPage logout() {
        $("a.button").click();
        return new LoginPage();
    }
}