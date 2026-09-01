package hw14.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLUtilsTest {

    @Test
    void testForValidTagName() {
        // 1. Arrange
        String input = "user";
        String expected = "<user></user>";

        // 2. Act
        String actual = XMLUtils.createEmptyElement(input);

        // 3. Assert
        assertEquals(expected, actual, "Метод получил некорректный тег");
    }

    @Test
    void testForInvalidTagName() {
        // 1. Arrange
        String input = "";
        String expected = "<invalid/>";
        // 2. Act
        String actual = XMLUtils.createEmptyElement(input);

        // 3. Assert
        assertEquals(expected, actual, "Метод вернул некорректный ответ при получении пустой строки.");
    }

    @Test
    public void testReturnInvalidForNull() {
        // 1. Arrange
        String inputTagName = null;
        String expectedOutput = "<invalid/>";

        // 2. Act
        String actualOutput = XMLUtils.createEmptyElement(inputTagName);

        // 3. Assert
        assertEquals(expectedOutput, actualOutput,
                String.format("Метод должен возвращать <invalid/> при передаче null. Ожидалось: %s, но получено: %s",
                        expectedOutput, actualOutput));
    }

}