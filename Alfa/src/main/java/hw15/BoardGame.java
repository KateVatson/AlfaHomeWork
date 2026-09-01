package hw15;

public class BoardGame {

    private String name;
    private int minAge;
    private int pricePerDay;
    private boolean rented;

    public BoardGame(String name, int minAge, int pricePerDay) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название игры не может быть пустым");
        }

        if (minAge < 0) {
            throw new IllegalArgumentException("Минимальный возраст не может быть меньше нуля");
        }

        if (pricePerDay <= 0) {
            throw new IllegalArgumentException("Стоимость аренды должна быть больше нуля");
        }

        this.name = name;
        this.minAge = minAge;
        this.pricePerDay = pricePerDay;
        this.rented = false;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public boolean isRented() {
        return rented;
    }

    public boolean canBeRentedBy(int age) {
        return age >= minAge;
    }

    void setRented(boolean rented) {
        this.rented = rented;
    }
}