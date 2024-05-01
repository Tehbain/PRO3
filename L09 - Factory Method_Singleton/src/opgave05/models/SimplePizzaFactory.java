package opgave05.models;

import opgave05.models.pizzas.*;

public class SimplePizzaFactory {

    public static Pizza createPizza(String type) {
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if(type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        } else {
            return null;
        }
        return pizza;
    }

}
