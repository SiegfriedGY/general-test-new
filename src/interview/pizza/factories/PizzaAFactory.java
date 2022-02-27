package interview.pizza.factories;

import interview.pizza.Pizza;
import interview.pizza.Provider;
import interview.pizza.products.PizzaA;

public class PizzaAFactory implements Provider {

    @Override
    public Pizza offerPizza(String ... requirement) {
        return new PizzaA(requirement[0]);
    }
}
