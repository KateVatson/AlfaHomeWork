package airport.exceptions;

public class ConveyorBeltMalfunctionError extends Error {

    //Если критическая ситуация, блокирующая работу пункта приема багажа
    public ConveyorBeltMalfunctionError(String message) {
        super(message);
    }
}