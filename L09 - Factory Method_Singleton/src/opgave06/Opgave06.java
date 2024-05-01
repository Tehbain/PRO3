package opgave06;

import opgave06.models.Pizzeria;
import opgave06.models.factories.SimpleChicagiPizzaFactory;
import opgave06.models.factories.SimpleNYPizzaFactory;
import opgave06.models.factories.SimplePizzaFactory;

public class Opgave06 {
    public static void main(String[] args) {

        Pizzeria pizzeria = new Pizzeria(new SimpleNYPizzaFactory());
        pizzeria.orderPizza("veggie");

        System.out.println();

        pizzeria = new Pizzeria(new SimpleChicagiPizzaFactory());
        pizzeria.orderPizza("veggie");
    }

}
