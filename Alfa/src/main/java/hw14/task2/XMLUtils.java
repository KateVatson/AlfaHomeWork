package hw14.task2;

public class XMLUtils {

    public static String createEmptyElement(String tagName) {
        // Проверяем null и пустую строку
        if (tagName == null || tagName.isEmpty()) {
            return "<invalid/>";
        }
        // Создаем открывающий и закрывающий XML-тег
        return "<" + tagName + "></" + tagName + ">";
    }
}