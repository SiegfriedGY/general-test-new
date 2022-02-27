package interview.pizza.products;

import interview.pizza.Pizza;

/**
 * supplement a shape property
 */
public class PizzaB extends Pizza {

    private String shape;

    public PizzaB(String shape) {
        super();
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Dough:" + this.getDough() + " Topping:" + this.getTopping() + " Sauce:" + this.getSauce() + " Shape:" + shape;
    }

}
