package alien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {

    public void demonstrateListCreations() {

        // ArrayList (изменяемый)
        List<String> mainSquad = new ArrayList<>();

        mainSquad.add("Губка Боб");
        mainSquad.add("Патрик");
        mainSquad.add("Сквидвард");
        mainSquad.add("Сэнди");
        System.out.println("Основной отряд (ArrayList): " + mainSquad);

        // Arrays.asList (фикс)
        List<String> supportSquad = Arrays.asList(
                "Крабс",
                "Перл",
                "Гэри"
        );
        System.out.println("Отряд поддержки (Arrays.asList): " + supportSquad);

        // List.of (неизменяемый)
        List<String> eliteSquad = List.of(
                "Планктон",
                "Карен"
        );

        System.out.println("Элитный отряд (List.of): " + eliteSquad);

        System.out.println();

        System.out.println("Попытки модификации:");
        modifyList(mainSquad, "Основной отряд (ArrayList)");
        modifyList(supportSquad, "Отряд поддержки (Arrays.asList)");
        modifyList(eliteSquad, "Элитный отряд (List.of)");
        System.out.println();
    }

    // Проверяем возможность добавления и удаления элементов
    private void modifyList(List<String> list, String listName) {

        // Пытаемся добавить нового
        try {
            list.add("Ларри");
            System.out.println(listName + " — добавление успешно");
        } catch (Exception e) {
            System.out.println(listName + " — добавление не удалось: " + e.getClass().getSimpleName());
        }

        // Пытаемся удалить первого
        try {
            list.remove(0);

            System.out.println(listName + " — удаление успешно");
        } catch (Exception e) {
            System.out.println(listName + " — удаление не удалось: " + e.getClass().getSimpleName());
        }
    }

    // Часть 3. Удаляем трусов из отряда через Iterator
    public void filterOutCowards(List<String> squad) {
        System.out.println("Отряд до фильтрации: " + squad);
        Iterator<String> iterator = squad.iterator();
        while (iterator.hasNext()) {
            String recruit = iterator.next();
            if (recruit.startsWith("Трус")) {
                iterator.remove();
            }
        }
        System.out.println("Отряд после фильтрации: " + squad);
        System.out.println();
    }

    // Альтернативная фильтрация через removeIf() (бонус)
    public void filterOutCowardsWithRemoveIf(List<String> squad) {
        System.out.println("Отряд до фильтрации: " + squad);
        squad.removeIf(name -> name.startsWith("Трус"));
        System.out.println("Отряд после фильтрации: " + squad);
        System.out.println();
    }
}