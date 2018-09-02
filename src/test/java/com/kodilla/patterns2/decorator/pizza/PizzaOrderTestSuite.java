package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void getCostBasicPizza() {
        //given
        PizzaOrder pizzaOrder = new BasicPizza();
        //when
        BigDecimal testPrice = pizzaOrder.getCost();
        //then
        assertEquals(new BigDecimal(15), testPrice);
    }

    @Test
    public void getIngredientsBasicPizza() {
        //given
        PizzaOrder pizzaOrder = new BasicPizza();
        String testString ="pizza dough, sauce, cheese";
        //when & then
        assertEquals(testString, pizzaOrder.getDescription());
    }

    @Test
    public void getCostWithAdditionalIngredient(){
        //given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new AdditionalMeetIngredient(pizzaOrder);
        pizzaOrder = new AdditionalVegetableIngredient(pizzaOrder);
        pizzaOrder = new ExtraDip(pizzaOrder);
        pizzaOrder = new PizzaDelivery(pizzaOrder);
        //when & then
        assertEquals(new BigDecimal(28), pizzaOrder.getCost());
    }

    @Test
    public void getIngredientsWithAdditionalIngredient() {
        //given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new AdditionalMeetIngredient(pizzaOrder);
        pizzaOrder = new AdditionalVegetableIngredient(pizzaOrder);
        pizzaOrder = new ExtraDip(pizzaOrder);
        pizzaOrder = new PizzaDelivery(pizzaOrder);
        String testString ="pizza dough, sauce, cheese, salami, paprika + extra garlic dip + delivery";
        //when & then
        assertEquals(testString, pizzaOrder.getDescription());
    }
}