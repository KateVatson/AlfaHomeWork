package arena.app;

import arena.heroes.Archer;
import arena.heroes.Hero;
import arena.heroes.Knight;
import arena.heroes.Mage;

public class App {

    public static void main(String[] args) {

        Hero[] heroes = {
                new Knight("Артур", 10, 100, 50),
                new Archer("Леголас", 8, 80, 30),
                new Mage("Мерлин", 12, 70, 150)
        };

        for (Hero hero : heroes) {
            hero.printInfo();
            hero.attack();
            System.out.println();
        }

        Hero.printHeroesCreated();

        System.out.println();

        final Knight knight = new Knight("Галахад", 20, 120, 80);

        System.out.println(knight);

        knight.setArmor(100);

        System.out.println(knight);

        Hero.printHeroesCreated();
    }
}