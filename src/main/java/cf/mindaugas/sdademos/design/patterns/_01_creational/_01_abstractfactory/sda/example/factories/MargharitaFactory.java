package cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.sda.example.factories;

import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.sda.example.pizza.Margharita;
import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.sda.example.pizza.Pizza;

public class MargharitaFactory implements PizzaAbstractFactory {

    @Override
    public Pizza create(int size) {
        return new Margharita(size);
    }
}
