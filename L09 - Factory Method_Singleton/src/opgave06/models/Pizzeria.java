package opgave06.models;

import opgave06.models.factories.SimplePizzaFactory;
import opgave06.models.pizza.Pizza;

public class Pizzeria {
    SimplePizzaFactory pizzaFactory;

    public Pizzeria(SimplePizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {

        Pizza pizza = pizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
