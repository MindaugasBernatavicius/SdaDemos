package cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.example.factories;

import cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.example.pizza.Pizza;

public interface PizzaAbstractFactory {

    public Pizza create(int size);
}
