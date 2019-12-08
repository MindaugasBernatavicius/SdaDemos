package cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.example.factories;

import cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.example.pizza.Capriciosa;
import cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.example.pizza.Pizza;

public class CapriciosaFactory implements PizzaAbstractFactory {

    @Override
    public Pizza create(int size) {
        return new Capriciosa(size);
    }
}
