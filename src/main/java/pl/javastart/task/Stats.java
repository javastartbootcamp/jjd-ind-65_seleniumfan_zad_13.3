package pl.javastart.task;

import java.math.BigDecimal;

public class Stats {
    private BigDecimal sum;
    private BigDecimal average;
    private Product mostExpensiveProduct;
    private Product cheapestProduct;

    public Stats(BigDecimal sum, BigDecimal average, Product mostExpensiveProduct, Product cheapestProduct) {
        this.sum = sum;
        this.average = average;
        this.mostExpensiveProduct = mostExpensiveProduct;
        this.cheapestProduct = cheapestProduct;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public Product getMostExpensiveProduct() {
        return mostExpensiveProduct;
    }

    public void setMostExpensiveProduct(Product mostExpensiveProduct) {
        this.mostExpensiveProduct = mostExpensiveProduct;
    }

    public Product getCheapestProduct() {
        return cheapestProduct;
    }

    public void setCheapestProduct(Product cheapestProduct) {
        this.cheapestProduct = cheapestProduct;
    }

    public String getStats() {
        return "\"Suma wszystkich produktów w EUR: " + sum +
                "\nŚrednia wszystkich produktów w EUR: " + average +
                "\nNajdroższy produkt w przeliczeniu na EUR: " + mostExpensiveProduct +
                "\nNajtańszy produkt w przeliczeniu na EUR: " + cheapestProduct;
    }
}
