package airport.exceptions;

public class InvalidBaggageWeightException extends RuntimeException {

    //Если вес багажа меньше или равен нулю
    public InvalidBaggageWeightException(String message) {
        super(message);
    }
}