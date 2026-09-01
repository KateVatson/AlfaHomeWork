package hw15;

import java.util.ArrayList;
import java.util.List;

public class GameRental {

    private List<BoardGame> games = new ArrayList<>();

    public void addGame(BoardGame game) {

        if (game == null) {
            throw new IllegalArgumentException("Игра не может быть null");
        }

        if (findGame(game.getName()) != null) {
            throw new IllegalArgumentException("Игра с таким названием уже существует");
        }

        games.add(game);
    }

    public BoardGame findGame(String name) {

        for (BoardGame game : games) {

            if (game.getName().equals(name)) {
                return game;
            }
        }

        return null;
    }

    public boolean rentGame(String name, int customerAge) {

        BoardGame game = findGame(name);

        if (game == null) {
            throw new IllegalArgumentException("Игра не найдена");
        }

        if (!game.canBeRentedBy(customerAge)) {
            return false;
        }

        if (game.isRented()) {
            return false;
        }

        game.setRented(true);
        return true;
    }

    public boolean returnGame(String name) {

        BoardGame game = findGame(name);

        if (game == null) {
            return false;
        }

        if (!game.isRented()) {
            return false;
        }

        game.setRented(false);
        return true;
    }

    public int calculateCost(String name, int days) {

        BoardGame game = findGame(name);

        if (game == null) {
            throw new IllegalArgumentException("Игра не найдена");
        }

        if (days <= 0) {
            throw new IllegalArgumentException("Количество дней должно быть больше нуля");
        }

        return game.getPricePerDay() * days;
    }

    public void reset() {

        for (BoardGame game : games) {
            game.setRented(false);
        }
    }
}