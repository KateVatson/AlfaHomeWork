import java.util.Random;

public class HomeWork2 {

        public static void main(String[] args) {

            Random random = new Random();

            // Генерация данных
            int age = random.nextInt(100); // возраст 0-99
            double money = random.nextDouble() * 100000; // деньги до 100000

            boolean hasInvitation = true; // Приглашение
            boolean isBlacklisted = false; // Черный список

            // Условия
            boolean isAdult = age >= 18;
            boolean hasAccessMoney = money > 50000;
            boolean notBlacklisted = !isBlacklisted;

            boolean canEnter = isAdult && (hasInvitation || hasAccessMoney) && notBlacklisted;

            // Взнос
            double contribution = money * 0.075;

            // Вывод
            System.out.println("Возраст: " + age);
            System.out.printf("Деньги: %.2f%n", money);
            System.out.println("Есть приглашение: " + hasInvitation);
            System.out.println("В черном списке: " + isBlacklisted);

            System.out.println("Проходит ли пользователь: " + canEnter);
            System.out.printf("Обязательный добровольный взнос: %.2f%n", contribution);
        }
    }
