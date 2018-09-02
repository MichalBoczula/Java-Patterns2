package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasicPizza implements PizzaOrder {
    private List<String> ingredients = new ArrayList<>();

    public BasicPizza() {
        ingredients.add("pizza dough");
        ingredients.add("sauce");
        ingredients.add("cheese");
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15);
    }

    @Override
    public String getDescription() {
        return "pizza dough, sauce, cheese";
    }


}
