package hw14.task1;

public class Movie {

    private String title;
    private double rating;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    // Определяем формат вывода фильма в консоль
    @Override
    public String toString() {
        return title + " - " + rating;
    }
}