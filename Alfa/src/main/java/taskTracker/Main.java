package taskTracker;

public class Main {

    public static void main(String[] args) {

        TaskTracker tracker = new TaskTracker();

        // Добавляем задачи
        tracker.addTask("Погладить котиков");
        tracker.addTask("Полить цветы");
        tracker.addTask("Оплатить коммуналку");

        //Выводим список всех задач
        tracker.printAllTasks();

        // Проверяем отработку кода при опечатке
        tracker.markTaskAsDone("Полить цвууты");

        // Отмечаем задачу как выполненную
        tracker.markTaskAsDone("Полить цветы");


        // Проверяем статус задачи после отметки выполнения, где true выполнена
        System.out.println("Статус задачи 'Полить цветы': "
                + tracker.isTaskDone("Полить цветы"));

        // Проверяем отработку при опечатке
        tracker.isTaskDone("Полить цветв");


        // Повторно выводим список задач после изменений
        tracker.printAllTasks();


        // Выводим статистику по всем задачам
        tracker.printStatistics();
    }
}