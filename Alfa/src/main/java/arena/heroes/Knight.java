package arena.heroes;

public class Knight extends Hero {

    private int armor;

    public Knight(String name, int level, int health, int armor) {
        super(name, level, health);
        this.armor = armor;
    }

    @Override
    public void attack() {
        System.out.println("Рыцарь бьёт мечом!");
    }

    // Нельзя переопределить final метод
    /*
    @Override
    public void rest() {
        System.out.println("Рыцарь отдыхает.");
    }
    */

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "name='" + getName() + '\'' +
                ", level=" + getLevel() +
                ", health=" + getHealth() +
                ", armor=" + armor +
                '}';
    }
}