package pl.devfoundry.testing;

import pl.devfoundry.testing.order.Order;

import java.util.ArrayList;
import java.util.List;

class Cart {

    private List<Order> orders = new ArrayList<>();

    List<Order> getOrders() {
        return orders;
    }

    void addOrderToCart(Order order) {
        this.orders.add(order);
    }

    void clearCart() {
        this.orders.clear();
    }

    void simulateLargeOrder() {

        for(int i = 0; i < 1_000; i++) {
            Meal meal = new Meal(i%10, "Hamburger no " + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);
        }
        System.out.println("Cart size: " + orders.size());
        clearCart();

    }

}
