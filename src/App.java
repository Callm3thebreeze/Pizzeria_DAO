import java.util.UUID;

import Classes.Pizza;
import DAO.PizzaDAO;


public class App {
    public static void main(String[] args) throws Exception {

        Pizza pizza = new Pizza();
        UUID pizzaID = UUID.randomUUID();

        pizza.setId(pizzaID);
        pizza.setName("Carbonara");
        pizza.setUrl("url");

        PizzaDAO pizzaDAO = new PizzaDAO();

        pizzaDAO.insert(pizza);
        pizzaDAO.select(pizza.getId());
        
    }
}