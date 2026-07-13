package alien;

import java.util.Objects;

public class Alien {

    private String name;
    private String planet;
    private int dangerLevel;

    public Alien(String name, String planet, int dangerLevel) {
        this.name = name;
        this.planet = planet;
        this.dangerLevel = dangerLevel;
    }
    // Имя
    public String getName() {
        return name;
    }
    // Планета
    public String getPlanet() {
        return planet;
    }
    // Уровень угрозы
    public int getDangerLevel() {
        return dangerLevel;
    }


    // Пришельцы считаются одинаковыми, если совпадают имя и планета
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Alien alien = (Alien) object;
        return Objects.equals(name, alien.name)
                && Objects.equals(planet, alien.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet);
    }

    // Вывод информации о пришельце
    @Override
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                ", dangerLevel=" + dangerLevel +
                '}';
    }
}