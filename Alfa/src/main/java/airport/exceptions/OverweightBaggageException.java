package airport.exceptions;

public class OverweightBaggageException extends AirportServiceException {

    // Если багаж слишком тяжелый
    public OverweightBaggageException(String message) {
        super(message);
    }
}