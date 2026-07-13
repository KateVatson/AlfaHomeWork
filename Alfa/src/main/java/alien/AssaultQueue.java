package alien;

import java.util.LinkedList;

public class AssaultQueue {

    // Очередь штурмовиков
    private LinkedList<String> queue;

    public AssaultQueue() {
        this.queue = new LinkedList<>();
    }

    // Добавляем штурмовика в конец очереди
    public void addRecruit(String name) {
        queue.addLast(name);
    }

    // Удаляем и возвращаем первого человека из очереди
    public String retreatCoward() {
        return queue.removeFirst();
    }

    // Выводим текущее состояние очереди
    public void printQueue() {
        System.out.println("Текущая очередь: " + queue);
    }

    @Override
    public String toString() {
        return "Очередь на штурм: " + queue;
    }
}