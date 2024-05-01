package opgave06.models.factories;

import opgave06.models.pizza.ChicagoStyleCheesePizza;
import opgave06.models.pizza.ChicagoStylePepperoniPizza;
import opgave06.models.pizza.ChicagoStyleVeggiePizza;
import opgave06.models.pizza.Pizza;

public class SimpleChicagiPizzaFactory extends SimplePizzaFactory{

    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else return null;
    }
}
