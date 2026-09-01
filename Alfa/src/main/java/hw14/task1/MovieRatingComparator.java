package hw14.task1;

import java.util.Comparator;


public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {

        // Сортировка фильмов от низкого рейтинга к высокому
        return Double.compare(movie1.getRating(), movie2.getRating());
    }
}