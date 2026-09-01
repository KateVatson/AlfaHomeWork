package hw15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RentalCostTest {

    // Проверяем корректный расчёт стоимости аренды
    @Test
    public void testCalculateCostHappyPath() {
        GameRental gameRental = new GameRental();

        gameRental.addGame(
                new BoardGame("Каркассон", 7, 500)
        );

        int days = 3;
        int expectedCost = gameRental.findGame("Каркассон").getPricePerDay() * days;

        assertEquals(expectedCost, gameRental.calculateCost("Каркассон", days),
                "Метод calculateCost должен вернуть произведение стоимости за день на количество дней"
        );
    }

    // Проверяем некорректные данные при расчёте стоимости
    @ParameterizedTest(name = "{index}: название={0}, дни={1}")
    @MethodSource("invalidCalculateCostArguments")
    void testCalculateCostInvalidArguments(String name, int days, boolean addGame,
                                           String assertionMessage
    ) {
        GameRental gameRental = new GameRental();
        if (addGame) {gameRental.addGame(new BoardGame("Каркассон", 7, 500));
        }
        assertThrows(IllegalArgumentException.class, () -> gameRental.calculateCost(name, days), assertionMessage
        );
    }

    static Stream<Arguments> invalidCalculateCostArguments() {
        return Stream.of(

                Arguments.of("Несуществующая игра", 3, false,
                        "Метод должен выбросить IllegalArgumentException, если игра отсутствует в каталоге"
                ),
                Arguments.of(
                        "Каркассон", 0, true,
                        "Метод должен выбросить IllegalArgumentException, если количество дней равно нулю"
                ),
                Arguments.of("Каркассон", -1, true,
                        "Метод должен выбросить IllegalArgumentException, если количество дней меньше нуля"
                )
        );
    }
}