package airport;

public class BaggageTicket {

    private final String passengerName;
    private final String flightNumber;
    private final int baggageWeight;

    public BaggageTicket(
            String passengerName,
            String flightNumber,
            int baggageWeight
    ) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.baggageWeight = baggageWeight;
    }
// Имя пассажира
    public String getPassengerName() {
        return passengerName;
    }
// Номер рейса
    public String getFlightNumber() {
        return flightNumber;
    }
// Вес багажа
    public int getBaggageWeight() {
        return baggageWeight;
    }
// Вывод информации о багажной бирке
    @Override
    public String toString() {
        return "Багажная бирка: " +
                "пассажир — " + passengerName +
                ", рейс — " + flightNumber +
                ", вес — " + baggageWeight + " кг";
    }
}