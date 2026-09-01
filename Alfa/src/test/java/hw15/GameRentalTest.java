package hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameRentalTest {

    private final BoardGame demogame =
            new BoardGame("Манчкин", 12, 400);

    // Проверяем успешную аренду игры
    @Test
    void testRentBoardGameHappyPath() {
        GameRental gameRental = new GameRental();
        gameRental.addGame(demogame);

        assertTrue(gameRental.rentGame("Манчкин", 18),
                "Метод аренды вернул неожиданный ответ"
        );

        assertTrue(gameRental.findGame("Манчкин").isRented(),
                "Метод аренды не установил признак того, что игра арендована"
        );
    }

    // Проверяем аренду несуществующей игры
    @Test
    void testRentBoardGameNotFound() {
        GameRental gameRental = new GameRental();
        gameRental.addGame(demogame);

        assertThrows(
                IllegalArgumentException.class, () -> gameRental.rentGame("Монополия", 18),
                "Метод должен выбрасывать IllegalArgumentException при несуществующем названии"
        );
    }

    // Проверяем аренду клиентом неподходящего возраста
    @Test
    void testRentBoardGameInvalidClientAge() {
        GameRental gameRental = new GameRental();
        gameRental.addGame(demogame);

        assertFalse(gameRental.rentGame("Манчкин", 10),
                "Метод аренды вернул неожиданный ответ"
        );
    }

    // Проверяем повторную аренду уже арендованной игры
    @Test
    void testRentBoardGameAlreadyRented() {
        GameRental gameRental = new GameRental();
        BoardGame boardGame = new BoardGame("Манчкин", 12, 400);

        gameRental.addGame(boardGame);
        gameRental.rentGame("Манчкин", 18);

        assertFalse(gameRental.rentGame("Манчкин", 18),
                "Уже арендованную игру нельзя арендовать повторно"
        );
    }

    // Проверяем успешный возврат игры
    @Test
    void testReturnBoardGameHappyPath() {
        GameRental gameRental = new GameRental();
        BoardGame boardGame = new BoardGame("Манчкин", 12, 400);

        gameRental.addGame(boardGame);
        gameRental.rentGame("Манчкин", 18);

        assertTrue(gameRental.returnGame("Манчкин"),
                "Метод returnGame должен вернуть true при успешном возврате"
        );

        assertFalse(boardGame.isRented(),
                "После успешного возврата игра не должна иметь признак аренды"
        );
    }

    // Проверяем возврат несуществующей игры
    @Test
    void testReturnBoardGameNotFound() {
        GameRental gameRental = new GameRental();

        gameRental.addGame(new BoardGame("Манчкин", 12, 400)
        );

        assertFalse(gameRental.returnGame("Монополия"),
                "Метод returnGame должен вернуть false при возврате несуществующей игры"
        );
    }

    // Проверяем возврат игры, которая не была арендована
    @Test
    void testReturnBoardGameNotRented() {
        GameRental gameRental = new GameRental();

        gameRental.addGame(new BoardGame("Манчкин", 12, 400)
        );

        assertFalse(gameRental.returnGame("Манчкин"),
                "Метод returnGame должен вернуть false при возврате неарендованной игры"
        );
    }
}