package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.sda.example.factories;

import cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.sda.example.pizza.Margharita;
import cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.sda.example.pizza.Pizza;

public class MargharitaFactory implements PizzaAbstractFactory {

    @Override
    public Pizza create(int size) {
        return new Margharita(size);
    }
}
