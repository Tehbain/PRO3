package opgave06.models.factories;

import opgave06.models.pizza.NYStyleCheesePizza;
import opgave06.models.pizza.NYStylePepperoniPizza;
import opgave06.models.pizza.NYStyleVeggiePizza;
import opgave06.models.pizza.Pizza;

public class SimpleNYPizzaFactory extends SimplePizzaFactory{
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
