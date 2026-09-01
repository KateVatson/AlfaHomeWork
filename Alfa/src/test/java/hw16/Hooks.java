package hw16;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    // Выводим название сценария перед его запуском
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Начинается сценарий: " + scenario.getName()
        );
    }

    // Выводим результат после выполнения сценария
    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            System.out.println("Сценарий упал: " + scenario.getName()
            );
        } else {
            System.out.println("Сценарий прошёл успешно: " + scenario.getName()
            );
        }
    }
}