package airport.exceptions;

public class BaggageTagPrintException extends AirportServiceException {

    //Если не получилось напечатать багажную бирку
    public BaggageTagPrintException(String message) {
        super(message);
    }
}