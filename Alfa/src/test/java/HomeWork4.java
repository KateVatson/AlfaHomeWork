public class HomeWork4 {
        public static void main(String[] args) {

            int passCount = 0;
            int flakyCount = 0;
            int bugCount = 0;
            int criticalCount = 0;

            for (int testNumber = 1; testNumber <= 100; testNumber++) {
                String status;
                if (testNumber % 3 == 0 && testNumber % 5 == 0) {
                    status = "Critical!";
                    criticalCount++;
                } else if (testNumber % 3 == 0) {
                    status = "Flaky";
                    flakyCount++;
                } else if (testNumber % 5 == 0) {
                    status = "Bug";
                    bugCount++;
                } else {
                    status = "Pass";
                    passCount++;
                }

                System.out.println("Тест #" + testNumber + ": " + status);
            }

            System.out.println();
            System.out.println("Итоги смены:  ");
            System.out.println("Всего тестов: 100");
            System.out.println("Pass: " + passCount);
            System.out.println("Flaky: " + flakyCount);
            System.out.println("Bug: " + bugCount);
            System.out.println("Critical: " + criticalCount);
        }
}
