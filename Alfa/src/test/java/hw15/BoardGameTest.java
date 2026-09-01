package hw15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameTest {

    // Проверяем создание игры с разными корректными данными
    @ParameterizedTest
    @CsvSource({
            "'Каркассон', 7, 500",
            "'Монополия', 8, 300",
            "'Манчкин', 12, 400"
    })
    void testCreateBoardGameHappyPath(String name, int minAge, int pricePerDay) {
        BoardGame boardGame = new BoardGame(name, minAge, pricePerDay);

        assertEquals(name, boardGame.getName(),
                "Конструктор некорректно обработал название игры");

        assertEquals(pricePerDay, boardGame.getPricePerDay(),
                "Конструктор некорректно обработал стоимость аренды");

        assertEquals(minAge, boardGame.getMinAge(),
                "Конструктор некорректно обработал минимальный возраст");

        assertFalse(boardGame.isRented(),
                "При создании игра не должна быть арендована");
    }

    // Проверяем создание игры с null и пустым названием
    @ParameterizedTest
    @NullAndEmptySource
    void testCreateBoardGameNameValidation(String name) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BoardGame(name, 7, 500),
                "Конструктор должен выбрасывать IllegalArgumentException при некорректном названии: " + name
        );
    }

    // Проверяем создание игры с отрицательным возрастом
    @Test
    void testCreateBoardGameAgeValidation() {
        int age = -1;

        assertThrows(
                IllegalArgumentException.class,
                () -> new BoardGame("Каркассон", age, 500),
                "Конструктор должен выбрасывать IllegalArgumentException при неправильном возрасте"
        );
    }

    // Проверяем создание игры с неправильной стоимостью
    @Test
    void testCreateBoardGamePriceValidation() {
        int price = -1;

        assertThrows(
                IllegalArgumentException.class,
                () -> new BoardGame("Каркассон", 7, price),
                "Конструктор должен выбрасывать IllegalArgumentException при неправильной стоимости"
        );
    }

    // Проверяем возрастное ограничение для аренды
    @ParameterizedTest
    @CsvSource({
            "10, false",
            "12, true",
            "18, true"
    })
    void testCanBeRentedByValidation(int age, boolean expectedResult) {
        BoardGame boardGame = new BoardGame("Манчкин", 12, 400);

        assertEquals(
                expectedResult,
                boardGame.canBeRentedBy(age),
                "Результат проверки возраста клиента не совпал с ожидаемым"
        );
    }
}