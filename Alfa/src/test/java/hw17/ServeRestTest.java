package hw17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServeRestTest {

    private static String userEmail;
    private static String userId;
    private static String userToken;
    private static Usuario usuario;

    // Задание 1. Настройка
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        Faker faker = new Faker();
        userEmail = faker.internet().emailAddress();

        usuario = new Usuario(
                "Кейт Тест",
                userEmail,
                "pass123",
                "true"
        );
    }

    // Задание 2. Получение всех пользователей
    @Test
    @Order(1)
    public void shouldGetAllUsers() {
        when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("quantidade", greaterThan(0))
                .body("usuarios.size()", greaterThan(0));
    }

    // Задание 3. Поиск пользователя по email
    @Test
    @Order(2)
    public void shouldFindUserByEmail() {
        String email = when()
                .get("/usuarios")
                .then()
                .extract()
                .path("usuarios[0].email");

        given()
                .queryParam("email", email)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(1))
                .body("usuarios[0].email", equalTo(email));
    }

    // Задание 4. Создание нового пользователя
    @Test
    @Order(3)
    public void shouldCreateNewUser() {
        String newUserRequestBody = """
                {
                  "nome": "Секретный Шпиен",
                  "email": "%s",
                  "password": "customer009",
                  "administrador": "true"
                }
                """.formatted(userEmail);

        userId = given()
                .contentType(ContentType.JSON)
                .body(newUserRequestBody)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body(
                        "message",
                        equalTo("Cadastro realizado com sucesso")
                )
                .body("_id", notNullValue())
                .extract()
                .path("_id");
    }

    // Задание 5. Изменение пользователя
    @Test
    @Order(4)
    public void shouldUpdateUser() {
        String newUserRequestBody = """
                {
                  "nome": "Супер Шпиен",
                  "email": "%s",
                  "password": "customer009",
                  "administrador": "false"
                }
                """.formatted(userEmail);

        given()
                .pathParam("id", userId)
                .contentType(ContentType.JSON)
                .body(newUserRequestBody)
                .when()
                .put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body(
                        "message",
                        equalTo("Registro alterado com sucesso")
                );
    }

    // Задание 6. Авторизация
    @Test
    @Order(5)
    public void shouldLogin() {
        String loginRequestBody = """
                {
                  "email": "%s",
                  "password": "customer009"
                }
                """.formatted(userEmail);

        Response loginResponse = given()
                .contentType(ContentType.JSON)
                .body(loginRequestBody)
                .when()
                .post("/login");

        loginResponse
                .then()
                .statusCode(200)
                .body(
                        "message",
                        equalTo("Login realizado com sucesso")
                )
                .body("authorization", notNullValue());

        userToken = loginResponse
                .then()
                .extract()
                .path("authorization");
    }

    // Задание 6. Удаление пользователя
    @Test
    @Order(6)
    public void shouldDeleteUser() {
        given()
                .pathParam("id", userId)
                .header("Authorization", userToken)
                .when()
                .delete("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body(
                        "message",
                        equalTo("Registro excluído com sucesso")
                );

        given()
                .pathParam("id", userId)
                .when()
                .get("/usuarios/{id}")
                .then()
                .statusCode(400)
                .body(
                        "message",
                        equalTo("Usuário não encontrado")
                );
    }

    // Задание 7. Каталог товаров
    @Test
    @Order(7)
    public void shouldGetAllProducts() {
        String firstName = when()
                .get("/produtos")
                .then()
                .extract()
                .path("produtos[0].nome");

        when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body(
                        "produtos.preco",
                        everyItem(greaterThan(0))
                )
                .body(
                        "produtos.nome",
                        everyItem(notNullValue())
                )
                .body(
                        "produtos.nome",
                        hasItem(firstName)
                );
    }

    // Бонус. Создание пользователя через DTO
    @Test
    @Order(8)
    public void shouldCreateNewUserFromDto() {
        userId = given()
                .contentType(ContentType.JSON)
                .body(usuario)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body(
                        "message",
                        equalTo("Cadastro realizado com sucesso")
                )
                .body("_id", notNullValue())
                .extract()
                .path("_id");
    }

    // Дополнительное задание 8. Негативный логин: неверный пароль
    @Test
    @Order(9)
    public void shouldFailLoginWithWrongPassword() {
        String invalidLoginRequestBody = """
                {
                  "email": "%s",
                  "password": "wrongPassword999"
                }
                """.formatted(userEmail);

        given()
                .contentType(ContentType.JSON)
                .body(invalidLoginRequestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(401)
                .body(
                        "message",
                        equalTo("Email e/ou senha inválidos")
                );
    }
}