package hw19.act1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthenticationTest {

    @Test
    public void successfulLoginTest() {
        // Открываем главную страницу
        open("https://the-internet.herokuapp.com/");

        // Переходим на страницу авторизации
        $x("//a[text()='Form Authentication']").click();

        // Проверяем заголовок
        $("h2").shouldHave(text("Login Page"));

        // Вводим логин и пароль
        $("#username").setValue("JamesBond");
        $("#password").setValue("SuperSecretPassword!");

        // Авторизуемся
        $("button[type='submit']").click();

        // Проверяем успешный вход
        $("#flash").shouldHave(text("You logged into a secure area!"));

        // Проверяем кнопку Logout
        $("a.button").shouldBe(visible)
                .shouldHave(text("Logout"));

        // Выходим
        $("a.button").click();

        // Проверяем возврат на страницу логина
        $("h2").shouldHave(text("Login Page"));
    }

    @Test
    public void invalidLoginTest() {
        // Открываем главную страницу
        open("https://the-internet.herokuapp.com/");

        // Переходим на страницу авторизации
        $x("//a[text()='Form Authentication']").click();

        // Проверяем ссылку внизу страницы
        $x("//a[text()='Elemental Selenium']")
                .shouldBe(visible)
                .shouldHave(text("Elemental Selenium"));

        // Вводим неправильные данные
        $("#username").setValue("admin");
        $("#password").setValue("1234");

        // Пытаемся авторизоваться
        $("button[type='submit']").click();

        // Проверяем сообщение об ошибке
        $("#flash").shouldHave(text("Your username is invalid!"));
    }
}