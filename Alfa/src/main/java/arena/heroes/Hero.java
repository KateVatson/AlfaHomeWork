package arena.heroes;

public class Hero {

    private String name;
    private int level;
    private int health;

    public static final int MAX_LEVEL = 100;
    private static int heroesCreated = 0;

    public Hero(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
        heroesCreated++;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public void levelUp() {
        if (level < MAX_LEVEL) {
            level++;
        }
    }

    public void attack() {
        System.out.println("Герой наносит обычный удар.");
    }

    public void attack(String target) {
        System.out.println("Герой наносит обычный удар. Цель: " + target);
    }

    public void attack(String target, int times) {
        System.out.println("Герой атакует цель " + target + " " + times + " раза.");
    }

    public final void rest() {
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }

    public static void printHeroesCreated() {
        System.out.println("Всего создано героев: " + heroesCreated);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }
}