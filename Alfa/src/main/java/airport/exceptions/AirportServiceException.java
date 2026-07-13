package airport.exceptions;

// Базовое проверяемое исключение аэропорта
public class AirportServiceException extends Exception {

    public AirportServiceException(String message) {
        super(message);
    }
}