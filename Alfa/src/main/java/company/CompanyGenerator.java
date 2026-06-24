package company;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.Random;

public class CompanyGenerator {

    private static final String[] SURNAMES = {
            "Testerov",
            "Watson",
            "Sherlock",
            "Chocopie",
            "Pocari",
            "Rostov",
            "Nintendo"
    };

    private static final Random RANDOM = new Random();
    private static final Faker FAKER = new Faker();

    public static String generateSurname() {
        return SURNAMES[RANDOM.nextInt(SURNAMES.length)];
    }

    public static void generateCompany() throws IOException {

        String firstSurname = generateSurname();
        String separator = "&";
        String secondSurname = FAKER.name().lastName();

        // Вывод логотипа
        System.out.println(FigletFont.convertOneLine(firstSurname));
        System.out.println(FigletFont.convertOneLine(separator));
        System.out.println(FigletFont.convertOneLine(secondSurname));

        System.out.println();
        System.out.println("=== Registration Information ===");
        System.out.println("Director: " + FAKER.name().fullName());
        System.out.println("Phone: " + FAKER.phoneNumber().phoneNumber());
        System.out.println("Address: " + FAKER.address().fullAddress());
    }
}