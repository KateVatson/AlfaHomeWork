package hw15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameCatalogTest {

    private GameRental gameRental;

    @BeforeEach
    void setUp() {
        gameRental = new GameRental();
    }

    // Проверяем успешное добавление игры
    @Test
    void testAddGameHappyPath() {
        BoardGame boardGame = new BoardGame("Каркассон", 7, 500);

        gameRental.addGame(boardGame);

        assertEquals(boardGame, gameRental.findGame("Каркассон"),
                "Метод добавления игры в каталог работает некорректно"
        );
    }

    // Проверяем добавление null
    @Test
    void testAddNullBoardGame() {
        assertThrows(
                IllegalArgumentException.class, () -> gameRental.addGame(null),
                "Метод должен выбрасывать IllegalArgumentException при добавлении null"
        );
    }

    // Проверяем повторное добавление игры с таким же названием
    @Test
    void testAddSameGame() {
        BoardGame boardGame = new BoardGame("Каркассон", 7, 500);
        gameRental.addGame(boardGame);

        assertThrows(IllegalArgumentException.class, () -> gameRental.addGame(boardGame),
                "Метод должен выбрасывать IllegalArgumentException при повторном добавлении игры"
        );
    }

    // Проверяем поиск существующей игры
    @Test
    void testFindGameHappyPath() {
        BoardGame testGame = new BoardGame("Манчкин", 12, 400);

        gameRental.addGame(new BoardGame("Каркассон", 7, 500));
        gameRental.addGame(new BoardGame("Монополия", 8, 300));
        gameRental.addGame(testGame);

        BoardGame actualGame = gameRental.findGame(testGame.getName());

        assertEquals(testGame, actualGame,
                "Метод должен находить игру по точному совпадению названия"
        );
    }

    // Проверяем поиск несуществующей игры
    @Test
    void testFindGameNoGame() {
        String nonexistentName = "Шахматы";
        gameRental.addGame(new BoardGame("Каркассон", 7, 500));
        gameRental.addGame(new BoardGame("Монополия", 8, 300));

        BoardGame actualGame = gameRental.findGame(nonexistentName);

        assertNull(actualGame,
                "Метод должен возвращать null, если игра с указанным названием не найдена"
        );
    }

    // Проверяем сброс состояния всех игр
    @Test
    void testBoardGameResetHappyPath() {
        BoardGame rentedGame = new BoardGame("Манчкин", 12, 400);
        BoardGame availableGame = new BoardGame("Монополия", 8, 300);

        gameRental.addGame(rentedGame);
        gameRental.addGame(availableGame);

        gameRental.rentGame("Манчкин", 18);

        gameRental.reset();

        assertAll(
                "После reset() все игры должны иметь признак аренды false",

                () -> assertFalse(gameRental.findGame("Манчкин").isRented(),
                        "Метод reset() не сбросил признак аренды у игры Манчкин"
                ),
                () -> assertFalse(gameRental.findGame("Монополия").isRented(),
                        "Метод reset() некорректно обработал игру Монополия")
        );
    }
}