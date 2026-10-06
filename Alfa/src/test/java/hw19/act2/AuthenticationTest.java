package hw19.act2;

import hw19.act2.pages.LoginPage;
import hw19.act2.pages.MainPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthenticationTest {

    @Test
    public void successfulLoginTest() {
        open("https://the-internet.herokuapp.com/");

        new MainPage()
                .openAuthenticationPage()
                .checkTitle()
                .setUsername("JamesBond")
                .setPassword("SuperSecretPassword!007")
                .loginSuccessfully()
                .checkSuccessfulLoginMessage()
                .checkLogoutButton()
                .logout()
                .checkTitle();
    }

    @Test
    public void invalidLoginTest() {
        open("https://the-internet.herokuapp.com/");

        new MainPage()
                .openAuthenticationPage()
                .checkElementalSeleniumLink()
                .setUsername("admin")
                .setPassword("1234")
                .loginWithInvalidCredentials()
                .checkInvalidUsernameMessage();
    }
}