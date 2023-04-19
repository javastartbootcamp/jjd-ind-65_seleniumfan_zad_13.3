package pl.javastart.task;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    static List<Product> readProducts(String fileName) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            BigDecimal amount = new BigDecimal(split[1]);
            products.add(new Product(split[0], amount, split[2]));
        }
        return products;
    }

    static List<Currency> readCurrencies(String fileName) throws FileNotFoundException {
        List<Currency> currencies = new ArrayList<>();
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            BigDecimal rate = new BigDecimal(split[1]);
            currencies.add(new Currency(split[0], rate));
        }
        scanner.close();
        return currencies;
    }
}
