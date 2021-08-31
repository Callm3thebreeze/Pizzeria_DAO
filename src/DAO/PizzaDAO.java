package DAO;
import java.util.Optional;
import java.util.UUID;

import Classes.Pizza;
import root.Configuration;
import root.EntityManager;

public class PizzaDAO implements IDAO<Pizza> {
    
    @Override
    public void insert(Pizza pizza){
        EntityManager
        .buildConnection(Configuration.getConfiguration())
        .addStatement(pizza, "INSERT INTO pizza(id, name, url) VALUES(?,?,?)", (statement, entity) -> {
            statement.setBytes(1, Converter.fromUUIDtoByteArray(entity.getId()));
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getUrl());
        })
        .save();

        System.out.println("Pizza: " + pizza.getName() + "añadida");
    }    


    @Override
    public Optional<Pizza> select(UUID id){
        Pizza pizza = new Pizza();        

        Pizza pizza1 = EntityManager.buildConnection(Configuration.getConfiguration())
        .addStatement(pizza, "SELECT id, name, url FROM pizza WHERE id=?", (statement, entity) -> {
           statement.setBytes(1, Converter.fromUUIDtoByteArray(id));
        })
        .select(Pizza.class, (resultSet, entity) -> {
           entity.setId(Converter.fromByteArrayToUUID(resultSet.getBytes("id")));
           entity.setName(resultSet.getString("name"));
           entity.setUrl(resultSet.getString("url"));
        }).orElseThrow();

        return Optional.of(pizza1);
    }

}