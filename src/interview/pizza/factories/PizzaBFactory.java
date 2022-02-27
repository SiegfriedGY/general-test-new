package interview.pizza.factories;

import interview.pizza.Pizza;
import interview.pizza.Provider;
import interview.pizza.products.PizzaB;

public class PizzaBFactory implements Provider {

    @Override
    public Pizza offerPizza(String... requirement) {
        return new PizzaB(requirement[0]);
    }
}
