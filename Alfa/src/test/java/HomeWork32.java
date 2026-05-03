public class HomeWork32 {

        public static void main(String[] args) {

            // Массив паролей
            String[] passwords = {"securePass1", "1234qwerty", "1badpassz"};

            for (String password : passwords) {

                // Проверки
                boolean lengthValid = password.length() > 8;
                boolean notStartsWith1 = !password.startsWith("1");
                boolean notEndsWithZ = !password.endsWith("z");
                boolean no1234 = !password.contains("1234");
                boolean noQwerty = !password.contains("qwerty");


                boolean isValid = lengthValid && notStartsWith1 && notEndsWithZ && no1234 && noQwerty;

                System.out.println("Пароль '" + password + "' "
                        + (isValid ? "подходит под условия" : "не подходит по условиям"));
            }
        }
}
