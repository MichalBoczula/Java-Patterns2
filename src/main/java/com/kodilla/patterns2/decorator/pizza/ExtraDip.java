package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraDip extends AbstractPizzaOrderDecorator {
    public ExtraDip(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription().concat(" + extra garlic dip");
    }
}
