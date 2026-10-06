package hw19.act2.pages;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public LoginPage openAuthenticationPage() {
        $x("//a[text()='Form Authentication']").click();
        return new LoginPage();
    }
}