package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.sda.example.factories;

import cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.sda.example.pizza.Pizza;

public interface PizzaAbstractFactory {

    public Pizza create(int size);
}
