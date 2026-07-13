package airport;

import airport.exceptions.*;

public class App {

    public static void main(String[] args) {

        String[] flights = {
                "SU-123",
                "TK-777",
                "KC-909",
                "AE-404"
        };

        BaggageDropDesk baggageDropDesk = new BaggageDropDesk(flights);

        // Успешная сдача багажа
        try {

            BaggageTicket ticket = baggageDropDesk.checkInBaggage(
                    "Test Testov",
                    "SU-123",
                    18
            );

            System.out.println("Багаж успешно принят");
            System.out.println(ticket);

        } catch (FlightNotFoundException e) {
            System.out.println("Проверьте номер рейса: " + e.getMessage());

        } catch (OverweightBaggageException e) {
            System.out.println("Необходимо оплатить перевес: " + e.getMessage());

        } catch (BaggageTagPrintException e) {
            System.out.println("Проверьте принтер багажных бирок: " + e.getMessage());

        } catch (InvalidPassengerNameException e) {
            System.out.println("Некорректные данные пассажира: " + e.getMessage());

        } catch (InvalidBaggageWeightException e) {
            System.out.println("Некорректный вес багажа: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Ошибка сервиса аэропорта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданное исключение: " + e.getMessage());
        }

        System.out.println();

        // Указанного пассажиром рейса не существует в базе
        try {

            baggageDropDesk.checkInBaggage(
                    "Sherlock Holmes",
                    "SU-999",
                    15
            );

        } catch (FlightNotFoundException e) {
            System.out.println("Проверьте номер рейса: " + e.getMessage());

        } catch (OverweightBaggageException e) {
            System.out.println("Необходимо оплатить перевес: " + e.getMessage());

        } catch (BaggageTagPrintException e) {
            System.out.println("Проверьте принтер багажных бирок: " + e.getMessage());

        } catch (InvalidPassengerNameException e) {
            System.out.println("Некорректные данные пассажира: " + e.getMessage());

        } catch (InvalidBaggageWeightException e) {
            System.out.println("Некорректный вес багажа: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Ошибка сервиса аэропорта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданное исключение: " + e.getMessage());
        }

        System.out.println();

        // Багаж слишком тяжелый
        try {

            baggageDropDesk.checkInBaggage(
                    "Kate Vatson",
                    "TK-777",
                    30000
            );

        } catch (FlightNotFoundException e) {
            System.out.println("Проверьте номер рейса: " + e.getMessage());

        } catch (OverweightBaggageException e) {
            System.out.println("Необходимо оплатить перевес: " + e.getMessage());

        } catch (BaggageTagPrintException e) {
            System.out.println("Проверьте принтер багажных бирок: " + e.getMessage());

        } catch (InvalidPassengerNameException e) {
            System.out.println("Некорректные данные пассажира: " + e.getMessage());

        } catch (InvalidBaggageWeightException e) {
            System.out.println("Некорректный вес багажа: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Ошибка сервиса аэропорта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданное исключение: " + e.getMessage());
        }

        System.out.println();

        // Проблема с печатью бирки
        try {

            baggageDropDesk.checkInBaggage(
                    "Zachem Pochemu",
                    "AE-404",
                    19
            );

        } catch (FlightNotFoundException e) {
            System.out.println("Проверьте номер рейса: " + e.getMessage());

        } catch (OverweightBaggageException e) {
            System.out.println("Необходимо оплатить перевес: " + e.getMessage());

        } catch (BaggageTagPrintException e) {
            System.out.println("Проверьте принтер багажных бирок: " + e.getMessage());

        } catch (InvalidPassengerNameException e) {
            System.out.println("Некорректные данные пассажира: " + e.getMessage());

        } catch (InvalidBaggageWeightException e) {
            System.out.println("Некорректный вес багажа: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Ошибка сервиса аэропорта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданное исключение: " + e.getMessage());
        }

        System.out.println();

        // Некорректное имя пассажира
        try {

            baggageDropDesk.checkInBaggage(
                    null,
                    "KC-909",
                    12
            );

        } catch (FlightNotFoundException e) {
            System.out.println("Проверьте номер рейса: " + e.getMessage());

        } catch (OverweightBaggageException e) {
            System.out.println("Необходимо оплатить перевес: " + e.getMessage());

        } catch (BaggageTagPrintException e) {
            System.out.println("Проверьте принтер багажных бирок: " + e.getMessage());

        } catch (InvalidPassengerNameException e) {
            System.out.println("Некорректные данные пассажира: " + e.getMessage());

        } catch (InvalidBaggageWeightException e) {
            System.out.println("Некорректный вес багажа: " + e.getMessage());
        }
        catch (AirportServiceException e) {
            System.out.println("Ошибка сервиса аэропорта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданное исключение: " + e.getMessage());
        }

        System.out.println();

        // Некорректный вес багажа (отрицательный)
        try {

            baggageDropDesk.checkInBaggage(
                    "Oleg Ivanov",
                    "KC-909",
                    -5
            );

        } catch (FlightNotFoundException e) {
            System.out.println("Проверьте номер рейса: " + e.getMessage());

        } catch (OverweightBaggageException e) {
            System.out.println("Необходимо оплатить перевес: " + e.getMessage());

        } catch (BaggageTagPrintException e) {
            System.out.println("Проверьте принтер багажных бирок: " + e.getMessage());

        } catch (InvalidPassengerNameException e) {
            System.out.println("Некорректные данные пассажира: " + e.getMessage());

        } catch (InvalidBaggageWeightException e) {
            System.out.println("Некорректный вес багажа: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Ошибка сервиса аэропорта: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданное исключение: " + e.getMessage());
        }
    }
}