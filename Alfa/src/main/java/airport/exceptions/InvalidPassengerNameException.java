package airport.exceptions;

public class InvalidPassengerNameException extends RuntimeException {

    //Если имя пассажира null или пустое
    public InvalidPassengerNameException(String message) {
        super(message);
    }
}