package coffee;

public class CoffeeMachine {

    // Приготовление кофе
    public void makeCoffee(int waterAmount) {

        if (waterAmount < 200) {
            throw new coffee.NotEnoughWaterException(
                    "Недостаточно воды для приготовления кофе. Нужно минимум 200 мл."
            );
        }

        System.out.println("Кофе приготовлен!");
    }

    // Подсчёт количества чашек
    public int calculateCups(int waterAmount, int cupSize) {

        return waterAmount / cupSize;
    }

    // Вывод названия кофе
    public void printCoffeeName(String coffeeName) {

        System.out.println(coffeeName.toUpperCase());
    }
}