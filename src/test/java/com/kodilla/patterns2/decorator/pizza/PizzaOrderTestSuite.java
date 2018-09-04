package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

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
        String testString = "pizza dough, sauce, cheese";
        //when & then
        assertEquals(testString, pizzaOrder.getDescription());
    }

    @Test
    public void getCostWithAdditionalIngredient() {
        //given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new AdditionalMeetIngredient(
                new AdditionalVegetableIngredient(
                        new ExtraDip(
                                new PizzaDelivery(pizzaOrder)
                        )
                )
        );
        //when & then
        assertEquals(new BigDecimal(28), pizzaOrder.getCost());
    }

    @Test
    public void getIngredientsWithAdditionalIngredient() {
        //given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new PizzaDelivery(
                new ExtraDip(
                        new AdditionalVegetableIngredient(
                                new AdditionalMeetIngredient(pizzaOrder)
                        )
                )
        );
        String testString = "pizza dough, sauce, cheese, salami, paprika + extra garlic dip + delivery";
        //when & then
        assertEquals(testString, pizzaOrder.getDescription());
    }
}