package airport.exceptions;

public class FlightNotFoundException extends AirportServiceException {

    // Если указанного рейса нет в списке доступных рейсов
    public FlightNotFoundException(String message) { //
        super(message);
    }
}