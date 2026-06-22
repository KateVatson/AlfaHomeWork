import java.time.Year;
import java.util.Random;

public class HomeWork5 {

    public static void main(String[] args) {

        // Протокол ГЕНЕРАТОР
        String accessCode = generateAccessCode();

        // Протокол ВАЛИДАТОР
        boolean isValid = isValidCode(accessCode, 8);
        System.out.println("Код доступа: " + accessCode);
        System.out.println("Код валиден: " + isValid);

        // Протокол ЛОГГЕР
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);

        // Протокол РАНДОМАЙЗЕР
        System.out.println(generateAgentId("AGENT", 42));
        System.out.println(generateAgentId("AGENT", 77));
        System.out.println(generateAgentId("AGENT", 13));
    }

    // Протокол ГЕНЕРАТОР
    public static String generateAccessCode() {
        int currentYear = Year.now().getValue();
        int codePart = (int) Math.pow(3, 7);

        return currentYear + "-" + codePart;
    }

    // Протокол ВАЛИДАТОР
    private static boolean isValidCode(String code, int minLength) {
        return code != null
                && code.length() >= minLength
                && code.contains("-");
    }

    // Протокол ЛОГГЕР (версия 1)
    public static void logEvent(String message) {
        System.out.println("[INFO] " + message);
    }

    // Протокол ЛОГГЕР (версия 2)
    public static void logEvent(String message, boolean isCritical) {
        if (isCritical) {
            System.out.println("[CRITICAL] " + message);
        } else {
            logEvent(message);
        }
    }

    // Протокол РАНДОМАЙЗЕР
    public static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);

        int randomNumber = random.nextInt(9000) + 1000;

        return prefix + "-" + randomNumber;
    }
}