package pl.javastart.task;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import static pl.javastart.task.CurrencyCalculator.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Product> products = FileUtils.readProducts("products.csv");
            List<Currency> currencies = FileUtils.readCurrencies("currencies.csv");

            BigDecimal sum = calculateSumInEur(products, currencies);
            BigDecimal average = calculateAverageInEur(products, currencies);
            Product maxProduct = findMostExpensiveProduct(products, currencies);
            Product minProduct = findCheapestProduct(products, currencies);

            Stats stats = new Stats(sum, average, maxProduct, minProduct);
            System.out.println(stats.getStats());
        } catch (FileNotFoundException e) {
            System.err.println("Nie można odczytać pliku");
        }
    }
}
