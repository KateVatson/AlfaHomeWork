package coffee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        // Приготовление кофе. Проверка NotEnoughWaterException
        try {
            System.out.print("Введите количество воды (мл): ");
            int water = scanner.nextInt();

            coffeeMachine.makeCoffee(water);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
            scanner.nextLine(); // очищаем буфер
        } catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        // Подсчет кол-ва чашек. Проверка ArithmeticException
        try {
            System.out.print("\nВведите количество воды (мл): ");
            int water = scanner.nextInt();

            System.out.print("Введите объем чашки (мл): ");
            int cupSize = scanner.nextInt();

            int cups = coffeeMachine.calculateCups(water, cupSize);

            System.out.println("Можно приготовить " + cups + " чашек.");

        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
            scanner.nextLine();
        }

        scanner.nextLine();

        // Вывод названия кофе. Проверка на пустое значение NullPointerException
        try {
            System.out.print("\nВведите название кофе: ");
            String coffeeName = scanner.nextLine();

            if (coffeeName.isBlank()) {
                coffeeName = null;
            }

            coffeeMachine.printCoffeeName(coffeeName);

        } catch (NullPointerException e) {
            System.out.println("Ошибка: название кофе отсутствует");
        }
    }
}