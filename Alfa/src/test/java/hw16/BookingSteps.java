package hw16;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.List;
import java.util.Map;

public class BookingSteps {

    // Получаем список столиков из DataTable
    @Дано("в ресторане есть столики:")
    public void restaurantHasTables(DataTable table) {

        List<Map<String, String>> tables =
                table.asMaps(String.class, String.class);

        for (Map<String, String> tableData : tables) {

            String tableNumber = tableData.get("номер");
            String capacity = tableData.get("вместимость");

            System.out.println("Столик №" + tableNumber + ", вместимость: "
                    + capacity + " гостей"
            );
        }
    }

    // Получаем вместимость свободного столика
    @Дано("в ресторане есть свободный столик на {int} гостей")
    public void restaurantHasFreeTable(int capacity) {
        System.out.println("Свободный столик на " + capacity + " гостей");
    }

    // Все подходящие столики заняты
    @Дано("все подходящие столики заняты")
    public void allSuitableTablesAreBusy() {
        System.out.println("Все подходящие столики заняты");
    }

    // У гостя уже есть активная бронь
    @Дано("у гостя есть активное бронирование столика номер {int}")
    public void guestHasActiveBooking(int tableNumber) {
        System.out.println("Активная бронь столика №" + tableNumber);
    }

    // Получаем количество гостей и время бронирования
    @Когда("гость бронирует столик на {int} гостей в {int} часов")
    public void guestBooksTable(int guestCount, int bookingHour) {
        System.out.println("Гость бронирует столик на " + guestCount
                + " гостей в " + bookingHour + " часов"
        );
    }

    // Получаем количество гостей, время и Doc String с пожеланием
    @Когда("гость бронирует столик на {int} гостей в {int} часов с пожеланием:")
    public void guestBooksTableWithRequest(int guestCount, int bookingHour, String request) {

        System.out.println("Гость бронирует столик на " + guestCount + " гостей в "
                + bookingHour + " часов");
        System.out.println("Пожелание гостя: " + request
        );
    }

    // Отмена бронирования
    @Когда("гость отменяет бронирование")
    public void guestCancelsBooking() {
        System.out.println("Гость отменяет бронирование");
    }

    // Успешное бронирование
    @Тогда("бронирование успешно создано")
    public void bookingSuccessfullyCreated() {

        System.out.println("Бронирование успешно создано");
    }

    // Получаем отказ
    @Тогда("гость получает отказ в бронировании")
    public void bookingRejected() {
        System.out.println("Гость получил отказ в бронировании");
    }

    // Проверяем результат Scenario Outline
    @Тогда("результат бронирования - {word}")
    public void bookingResult(String result) {

        System.out.println("Результат бронирования: " + result);
    }

    // Бронирование отменено
    @Тогда("бронирование отменено")
    public void bookingCancelled() {

        System.out.println("Бронирование отменено");
    }

    // Столик становится занят
    @И("столик на {int} гостей становится занят")
    public void tableBecomesBusy(int capacity) {

        System.out.println("Столик на " + capacity + " гостей теперь занят");
    }

    // Столик становится свободным
    @И("столик номер {int} становится свободным")
    public void tableBecomesFree(int tableNumber) {

        System.out.println("Столик №" + tableNumber + " теперь свободен");
    }
}