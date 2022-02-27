package interview.pizza.factories;

import interview.pizza.Pizza;
import interview.pizza.Provider;
import interview.pizza.products.PizzaA;

import java.util.Arrays;

public class PizzaBasicFactory implements Provider {

    @Override
    public Pizza offerPizza(String ... requirement) {
        if (requirement.length==0) {
            return new Pizza();  // default settings
        } else {
            // customized settings
            Pizza pizza = new Pizza();
            pizza.setDough(requirement[0]);
            pizza.setSauce(requirement[1]);
            pizza.setTopping(requirement[2]);
            return pizza;
        }
    }
}
