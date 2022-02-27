package interview.pizza.products;

import interview.pizza.Pizza;

/**
 * supplements a size property
 */
public class PizzaA extends Pizza {

    private String size;

    public PizzaA(String size) {
        super();
        this.size = size;
    }

    @Override
    public String toString() {
        return "Dough:" + this.getDough() + " Topping:" + this.getTopping() + " Sauce:" + this.getSauce() + " Size:" + size;
    }
}
