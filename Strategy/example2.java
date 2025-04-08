package Strategy;

// Shipping strategy interface
public interface ShippingStrategy {
    double calculateShippingCost(Order order);
}

// Standard shipping
public class StandardShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Order order) {
        return 5.0;  // Fixed shipping fee
    }
}

// Expedited shipping
public class ExpeditedShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Order order) {
        return 20.0;  // Expedited shipping fee
    }
}

// Context class: Order
public class OrderContext {
    private ShippingStrategy strategy;

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShipping(Order order) {
        return strategy.calculateShippingCost(order);
    }
}