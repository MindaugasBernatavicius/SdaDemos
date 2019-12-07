package cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.sda;

import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.sda.example.factories.PizzaFactory;
import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.sda.example.pizza.Pizza;

public class AbstractFactory {

    public static void main(String[] args) {
        Pizza margharita = PizzaFactory.createPizza("Margharita", 32);
        Pizza capriciosa = PizzaFactory.createPizza("Capriciosa", 42);
        //Pizza fruttiDiMare = PizzaFactory.createPizza("Frutti di Mare", 32);
        System.out.println(margharita);
        System.out.println(capriciosa);
        //System.out.println(fruttiDiMare);
    }
}
