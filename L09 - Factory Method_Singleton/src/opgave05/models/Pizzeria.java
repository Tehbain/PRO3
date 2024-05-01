package opgave05.models;

import opgave05.models.pizzas.*;

public class Pizzeria {
    public Pizza orderPizza(String type) {

        Pizza pizza = SimplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
