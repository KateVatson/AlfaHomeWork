package coffee;


public class NotEnoughWaterException extends RuntimeException {

    public NotEnoughWaterException(String message) {  //Выбрасывается при недостаточном кол-ве воды, принимает в конструкторе текст ошибки
        super(message);
    }
}
