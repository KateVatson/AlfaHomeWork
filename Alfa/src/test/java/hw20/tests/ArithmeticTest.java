package hw20.tests;

import hw20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Калькулятор")
@Feature("Арифметические операции")
public class ArithmeticTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Kate")
    @Description("Проверяем базовое сложение двух положительных чисел")
    public void testAddPositiveNumbers() {
        double result = steps.add(2, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем сложение отрицательного и положительного числа")
    public void testAddNegativeNumber() {
        double result = steps.add(-5, 3);
        steps.verifyResult(result, -2);
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Kate")
    public void testSubtractNumbers() {
        double result = steps.subtract(10, 4);
        steps.verifyResult(result, 6);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    public void testMultiplyNumbers() {
        Allure.step("Выполняем умножение чисел 7 и 8");

        double result = steps.multiply(7, 8);
        steps.verifyResult(result, 56);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем обычное деление числа 15 на 3")
    @Link(
            name = "Требование к операции деления",
            url = "https://example.com/calculator/division"
    )
    public void testDivideNumbers() {
        Allure.parameter("Делимое", 15);
        Allure.parameter("Делитель", 3);

        double result = steps.divide(15, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("CALC-101")
    public void testDivideByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> steps.divide(15, 0)
        );
    }
}