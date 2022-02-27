package interview.pizza;

import interview.pizza.factories.PizzaAFactory;
import interview.pizza.factories.PizzaBFactory;
import interview.pizza.factories.PizzaBasicFactory;

public class Customer {

    public static void main(String[] args) {
        /**
         * I use Abstract Factory design pattern in solving this problem.
         */
        // order a basic pizza
        Provider provider = new PizzaBasicFactory();
        // with default settings
        System.out.println(provider.offerPizza());
        // with customized settings
        System.out.println(provider.offerPizza(CustomizationEnum.Dough2.getData(), CustomizationEnum.Sauce1.getData(), CustomizationEnum.Topping2.getData()));

        // order a pizza with size choice (default settings + chosen size)
        provider = new PizzaAFactory();
        System.out.println(provider.offerPizza(CustomizationEnum.Size1.getData()));
        System.out.println(provider.offerPizza(CustomizationEnum.Size2.getData()));

        // order a pizza with shape choice (default settings + chosen shape)
        provider = new PizzaBFactory();
        System.out.println(provider.offerPizza(CustomizationEnum.Shape1.getData()));
        System.out.println(provider.offerPizza(CustomizationEnum.Shape2.getData()));
    }
}
