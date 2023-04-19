package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CurrencyCalculator {
    public static BigDecimal calculateSumInEur(List<Product> products, List<Currency> currencies) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            sum = sum.add(changeAmountToEur(product, currencies));
        }
        return sum;
    }

    public static BigDecimal calculateAverageInEur(List<Product> products, List<Currency> currencies) {
        BigDecimal sum = calculateSumInEur(products, currencies);
        return sum.divide(BigDecimal.valueOf(products.size()), RoundingMode.HALF_UP);
    }

    public static Product findMostExpensiveProduct(List<Product> products, List<Currency> currencies) {
        BigDecimal maxPrice = BigDecimal.ZERO;
        Product maxProduct = products.get(0);
        for (Product product : products) {
            BigDecimal amountInEur = changeAmountToEur(product, currencies);
            if (amountInEur.compareTo(maxPrice) > 0) {
                maxPrice = amountInEur;
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public static Product findCheapestProduct(List<Product> products, List<Currency> currencies) {
        BigDecimal minPrice = changeAmountToEur(products.get(0), currencies);
        Product minProduct = products.get(0);
        for (Product product : products) {
            BigDecimal amountInEur = changeAmountToEur(product, currencies);
            if (amountInEur.compareTo(minPrice) < 0) {
                minPrice = amountInEur;
                minProduct = product;
            }
        }
        return minProduct;
    }

    public static BigDecimal changeAmountToEur(Product product, List<Currency> currencies) {
        BigDecimal amountInEur = BigDecimal.ZERO;
        for (Currency element : currencies) {
            if (element.getCode().equals(product.getCurrencyCode())) {
                amountInEur = product.getAmount().divide(element.getRate(), RoundingMode.HALF_UP);
                break;
            }
        }
        return amountInEur;
    }
}
