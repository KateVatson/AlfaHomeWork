import java.util.Arrays;

public class HomeWork31 {

    public static void main(String[] args) {

            // Покупатели и их корзины (массивы)
            String[] petya = {"курица", "бананы", "творог"};
            String[] kolya = {"курица", "бананы", "творог"};
            String[] terenty = {"пиво", "пельмени", "ласка магия черного"};

            // Сравнение по количеству товаров
            boolean petyaKolyaSize = petya.length == kolya.length;
            boolean petyaTerentySize = petya.length == terenty.length;

            System.out.println("Петя и Коля одинаковое количество товаров: " + petyaKolyaSize);
            System.out.println("Петя и Терентий одинаковое количество товаров: " + petyaTerentySize);

            // Сравнение по составу продуктов
            boolean petyaKolyaProducts = Arrays.equals(petya, kolya);
            boolean petyaTerentyProducts = Arrays.equals(petya, terenty);

            System.out.println("Петя и Коля одинаковые корзины: " + petyaKolyaProducts);
            System.out.println("Петя и Терентий одинаковые корзины: " + petyaTerentyProducts);

            // Поиск длин
            String longest = "";
            String shortest = null;
            int totalLength = 0;
            int count = 0;

            String[][] allBaskets = {petya, kolya, terenty};

            for (String[] basket : allBaskets) {
                for (String product : basket) {

                    if (product.length() > longest.length()) { // Самое длинное слово
                        longest = product;
                    }

                    if (shortest == null || product.length() < shortest.length()) {
                        shortest = product;
                    }

                    totalLength += product.length();  //Средняя длина
                    count++;
                }
            }

            double averageLength = (double) totalLength / count;


            System.out.println("Самое длинное название: " + longest);
            System.out.println("Самое короткое название: " + shortest);
            System.out.printf("Средняя длина названия: %.2f%n", averageLength);
        }
}
