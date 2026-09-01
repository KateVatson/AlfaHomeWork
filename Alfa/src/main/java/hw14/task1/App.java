package hw14.task1;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Создаем список фильмов
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Интерстеллар", 8.7));
        movies.add(new Movie("Шрек", 8.1));
        movies.add(new Movie("Начало", 8.8));
        movies.add(new Movie("Веном", 6.6));

        // Выводим список до сортировки
        System.out.println("До сортировки:");
        System.out.println(movies);

        // Сортируем фильмы
        movies.sort(new MovieRatingComparator());

        // Выводим список после сортировки
        System.out.println("После сортировки:");
        System.out.println(movies);
    }
}