package StrategyPattern;

import java.util.ArrayList;
import java.util.List;

interface PricingStrategy {
    double apply(double price);

}

class NoPricingStrategy implements PricingStrategy {

    public double apply(double price) {
        return price;
    }
}

class PercentagePricingStrategy implements PricingStrategy {
    private double percent;

    public PercentagePricingStrategy(double percent) {
        this.percent = percent;
    }

    public double apply(double price) {
        return price * (1 - percent); // 10% discount
    }
}

class FlatPricingStrategy implements PricingStrategy {
    private double discountAmount;

    public FlatPricingStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double apply(double price) {
        return price - discountAmount; // $20 discount
    }
}

class PrimePricingStrategy implements PricingStrategy {
    private double percent;

    public PrimePricingStrategy(double percent) {
        this.percent = percent;
    }

    public double apply(double price) {
        return price * (1 - percent - 0.1); // 15% discount
    }
}

class SurgePricingStrategy implements PricingStrategy {
    private double amount;

    public SurgePricingStrategy(double amount) {
        this.amount = amount;
    }

    public double apply(double price) {
        return price * (1 + amount); // 20% increase
    }
}

class PriceCalculator {
    private List<PricingStrategy> strategies;

    public PriceCalculator(List<PricingStrategy> strategies) {
        this.strategies = strategies;
    }

    public double calculate(double price) {

        for (PricingStrategy strategy : strategies) {
            price = strategy.apply(price);
        }
        return price;
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        PricingStrategy noDiscount = new NoPricingStrategy();
        PricingStrategy flat = new FlatPricingStrategy(200);
        PricingStrategy percentage = new PercentagePricingStrategy(0.2);
        PricingStrategy surge = new SurgePricingStrategy(0.3);

        List<PricingStrategy> strategies = new ArrayList<>();
        strategies.add(noDiscount);
        strategies.add(flat);
        strategies.add(percentage);
        strategies.add(surge);

        PriceCalculator calculator = new PriceCalculator(strategies);
        double originalPrice = 1000;
        System.err.println("Original Price: $" + originalPrice);
        double finalPrice = calculator.calculate(originalPrice);
        System.err.println("Final Price: $" + finalPrice);
    }
}