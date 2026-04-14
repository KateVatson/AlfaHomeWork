public class HomeWork {
     static void main(String[] args) {

         // Данные сотрудника
        String name = "Глеб";
        String position = "Старший шаурма-инженер";

        // Финансы сотрудника
        int ratePerShift = 2000;
        int shifts = 8;
        int bonus = 3000;
        int penalty = 500;

        // Продажи
        int shawarmaPrice = 300;
        int shawarmaSold = 3000;

        // Расчёты
        int salaryWithoutBonus = ratePerShift * shifts;
        int finalSalary = salaryWithoutBonus + bonus - penalty;
        int revenue = shawarmaPrice * shawarmaSold;

        // Вывод
        System.out.println("Сотрудник: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Оплата за смены: " + salaryWithoutBonus);
        System.out.println("Премия: " + bonus);
        System.out.println("Штраф: " + penalty);
        System.out.println("Итоговая зарплата: " + finalSalary);
        System.out.println("Шаур-выручка: " + revenue);
    }
}
