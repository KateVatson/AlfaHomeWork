package hw20.tests;

import hw20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Калькулятор")
@Feature("Математические функции")
public class MathFunctionsTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Возведение в степень")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем возведение числа 2 в десятую степень")
    public void testPower() {
        double result = steps.power(2, 10);
        steps.verifyResult(result, 1024);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.CRITICAL)
    public void testSqrtNegativeNumber() {
        assertThrows(
                ArithmeticException.class,
                () -> steps.sqrt(-4)
        );
    }
}