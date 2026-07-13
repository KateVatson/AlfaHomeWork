package airport;

import airport.exceptions.*;

public class BaggageDropDesk {

    private final String[] availableFlights;

    public BaggageDropDesk(String[] availableFlights) {
        this.availableFlights = availableFlights;
    }

    // Принимает багаж и возвращает бирку при успешной проверке
    public BaggageTicket checkInBaggage(
            String passengerName,
            String flightNumber,
            int baggageWeight
    ) throws AirportServiceException {

        // Проверяем имя пассажира
        if (passengerName == null || passengerName.isBlank()) {
            throw new InvalidPassengerNameException(
                    "Имя пассажира не может быть пустым"
            );
        }

        // Проверяем корректность веса
        if (baggageWeight <= 0) {
            throw new InvalidBaggageWeightException(
                    "Вес багажа должен быть больше 0 кг"
            );
        }

        // Проверяем существование рейса
        boolean flightExists = false;
        for (String flight : availableFlights)
            if (flight.equals(flightNumber)) {
                flightExists = true;
                break;
            }

        if (!flightExists) {
            throw new FlightNotFoundException(
                    "Рейс " + flightNumber + " не найден"
            );
        }

        // Проверяем перевес
        if (baggageWeight > 23) {
            throw new OverweightBaggageException(
                    "Вес багажа " + baggageWeight +
                            " кг превышает разрешённые 23 кг"
            );
        }

        // Имитируем проблемы с печатью
        if ("AE-404".equals(flightNumber)) {
            throw new BaggageTagPrintException(
                    "Не удалось напечатать бирку для рейса " + flightNumber
            );
        }

        System.out.println(
                "Данные введены слишком правильно. " +
                        "Пассажиру необходимо уплатить налог."
        );

        return new BaggageTicket(
                passengerName,
                flightNumber,
                baggageWeight
        );
    }

}