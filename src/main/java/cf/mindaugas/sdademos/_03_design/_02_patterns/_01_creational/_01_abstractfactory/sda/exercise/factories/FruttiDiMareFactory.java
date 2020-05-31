package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._01_abstractfactory.sda.exercise.factories;

import cf.mindaugas.sdademos._03_design._02_patterns._01_creational._01_abstractfactory.sda.example.factories.PizzaAbstractFactory;
import cf.mindaugas.sdademos._03_design._02_patterns._01_creational._01_abstractfactory.sda.example.pizza.Pizza;
import cf.mindaugas.sdademos._03_design._02_patterns._01_creational._01_abstractfactory.sda.exercise.pizza.FruttiDiMare;

public class FruttiDiMareFactory implements PizzaAbstractFactory {

    @Override
    public Pizza create(int size) {
        return new FruttiDiMare(size);
    }
}
