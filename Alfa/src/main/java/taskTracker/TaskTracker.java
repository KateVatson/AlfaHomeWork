package taskTracker;

import java.util.ArrayList;

public class TaskTracker {
    private ArrayList<Task> tasks;

    public TaskTracker() {
        this.tasks = new ArrayList<>();
    }
// Добавление новой задачи
    public void addTask(String title){
        Task task = new Task(title);
        tasks.add(task);
        System.out.println("Добавлена новая задача:" + title);
    }
// Вывод всех добавленных задач
    public void printAllTasks(){
        for (Task task : tasks) {
            task.printInfo();
        }
    }
    // Отметка задачи как выполненной
    public void markTaskAsDone(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                task.markAsDone();
                System.out.println("Задача " + title + " выполнена!");
                return;
            }
        }
        System.out.println("Задача " + title + " не найдена");
    }

    // Получение статуса задачи по её названию
    public boolean isTaskDone(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task.isDone();
            }
        }

        System.out.println("Задача " + title + " не найдена");
        return false;
    }
 // Вывод статистики по всем задачам
    public void printStatistics() {
        int doneCount = 0;

        for (Task task : tasks) {
            if (task.isDone()) {
                doneCount++;
            }
        }

        int total = tasks.size();
        int openCount = total - doneCount;

        System.out.println("Всего задач: " + total);
        System.out.println("Выполнено: " + doneCount);
        System.out.println("Открыто: " + openCount);
    }
}

