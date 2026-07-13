package alien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Часть 1. База пришельцев
        System.out.println("--- Часть 1 База пришельцев ---");

        List<Alien> aliens = new ArrayList<>();

        aliens.add(new Alien("Зигмунд", "Марс", 5));
        aliens.add(new Alien("Иммануил", "Солнце", 9));
        aliens.add(new Alien("Зигмунд", "Марс", 9)); // дубль
        aliens.add(new Alien("Платон", "Земля", 8));
        aliens.add(new Alien("Сократ", "Сатурн", 2));

        System.out.println("Список пришельцев:");

        for (Alien alien : aliens) {
            System.out.println(alien);
        }
        boolean hasDuplicate = false;
        for (int i = 0; i < aliens.size(); i++) {
            for (int j = i + 1; j < aliens.size(); j++) {
                if (aliens.get(i).equals(aliens.get(j))) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                break;
            }
        }

        System.out.println();

        System.out.println("Содержит ли список дубликат: " + hasDuplicate);

        System.out.println();

        // Часть 2. Формирование отрядов
        System.out.println("--- Часть 2 Формирование отрядов ---");
        SquadManager squadManager = new SquadManager();
        squadManager.demonstrateListCreations();

        System.out.println();

        // Часть 3. Отсеивание трусов
        System.out.println("--- Часть 3 Отсеивание трусов ---");
        List<String> squad = new ArrayList<>(
                Arrays.asList(
                        "Губка Боб",
                        "Трус Планктон",
                        "Патрик",
                        "Трус Ларри",
                        "Сэнди"
                )
        );
        squadManager.filterOutCowards(squad);

        System.out.println();

        // Часть 4. Очередь на вход
        System.out.println("--- Часть 4 Очередь на вход ---");

        AssaultQueue queue = new AssaultQueue();

        queue.addRecruit("Трудяга1");
        queue.addRecruit("Трудяга2");
        queue.addRecruit("Трудяга3");
        queue.addRecruit("Трудяга4");
        queue.addRecruit("Трудяга5");

        System.out.println("Исходная очередь:");
        queue.printQueue();

        System.out.println();

        System.out.println("Покинули очередь первыми:");
        System.out.println("Минус " + queue.retreatCoward());
        System.out.println("Минус " + queue.retreatCoward());
        queue.printQueue();

        System.out.println();
        System.out.println("Добавим новеньких в конец");
        queue.addRecruit("Новичок");
        queue.addRecruit("Новичок2");
        queue.addRecruit("Супернова");

        queue.printQueue();

        System.out.println();

        // Часть 5. Отчёт командованию

        System.out.println("--- Часть 5 Отчёт командованию ---");
        List<Alien> capturedAliens = new ArrayList<>();

        //Пойманные пришельцы
        capturedAliens.add(new Alien("Кот", "Марс", 5));
        capturedAliens.add(new Alien("Собака", "Земля", 3));
        capturedAliens.add(new Alien("Сафонов", "Солнце", 5));
        capturedAliens.add(new Alien("Тостер", "Сатурн", 3));

        MissionReport report1 = new MissionReport(
                "Штурм Зоны 51",
                capturedAliens,
                50
        );

        MissionReport report2 = new MissionReport(
                "Штурм Зоны 51",
                capturedAliens,
                50
        );

        System.out.println("Первый отчёт:");
        System.out.println(report1);

        System.out.println();

        System.out.println("Второй отчёт:");
        System.out.println(report2);

        System.out.println();

        System.out.println("Сравнение через == : " + (report1 == report2));
        System.out.println("Сравнение через equals() : " + report1.equals(report2));


}
}