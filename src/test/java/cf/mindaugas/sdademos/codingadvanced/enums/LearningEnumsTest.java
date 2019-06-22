package cf.mindaugas.sdademos.codingadvanced.enums;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.everyItem;

public class LearningEnumsTest {

    Pizza testPizza;

    @Before
    public void setUp(){
        testPizza = new Pizza();
    }

    @After
    public void teardown(){
        testPizza = null;
    }

    @Test
    public void equalsEquals_givenStatusDelivered_printsStatusConditionally(){
        // given
        testPizza.setStatus(Pizza.PizzaStatus.DELIVERED);

        // when
        // String status = testPizza.getStatus().toString();
        Pizza.PizzaStatus st = testPizza.getStatus();

        // then
        Assert.assertThat(st, is(Pizza.PizzaStatus.DELIVERED));

//        // when
//        if(testPizza.getStatus() == Pizza.PizzaStatus.DELIVERED){
//            System.out.println(testPizza.getStatus());
//        }
//
//        // when
//        if(testPizza.getStatus().equals(Pizza.PizzaStatus.READY)){
//            System.out.println(testPizza.getStatus());
//        }
    }

    // then
    @Test(expected = NullPointerException.class)
    public void dotEquals_givenPizzaStatusNotSet_throwsNPE(){
        // given

        // when
        if(testPizza.getStatus().equals(Pizza.PizzaStatus.READY)){}
    }

    @Test
    // EnumUsingSwitch
    public void getDeliveryTimeInMinutes_givenOrderedStatus_returns30minutes(){
        // given
        testPizza.setStatus(Pizza.PizzaStatus.ORDERED);

        // when
        int deliveryTime = testPizza.getDeliveryTimeInMinutes();

        // then
        Assert.assertEquals(30, deliveryTime);
    }

    @Test
    public void givenPizzaOrder_whenReady_thenIsOrderedIsReadButNotDelivered() {
        // given

        // when
        testPizza.setStatus(Pizza.PizzaStatus.READY);

        // then
        Assert.assertTrue(testPizza.getStatus().isOrdered());
        Assert.assertTrue(testPizza.getStatus().isReady());
        Assert.assertFalse(testPizza.getStatus().isDelivered());
    }

    @Test
    public void getAllUndeliveredPizzas_givenAMixOfDeliveredAndUndelivered_returnUndeliveredOnly() {
        // given
        List<Pizza> mixedDeliveryStatusPizzas = new ArrayList<>();

//        Pizza somePizza;
//        for(int i = 0; i < 10; i++){
//            somePizza = new Pizza();
//
//            // TASK :: decide of how to init a random status
//            // #1st implementation
//            int randomChoise = (new Random()).nextInt(3);
//            if(randomChoise == 0)
//                somePizza.setStatus(Pizza.PizzaStatus.ORDERED);
//            if(randomChoise == 1)
//                somePizza.setStatus(Pizza.PizzaStatus.READY);
//            if(randomChoise == 2)
//                somePizza.setStatus(Pizza.PizzaStatus.DELIVERED);
//
//            // add the pizza with random delivery status
//            mixedDeliveryStatusPizzas.add(somePizza);
//        }

        Pizza somePizza;
        for(int i = 0; i < 20; i++){
            somePizza = new Pizza();

            // TASK :: decide of how to init a random status
            // #2nd implementation
            if(i % 3 == 0)
                somePizza.setStatus(Pizza.PizzaStatus.ORDERED);
            else if(i % 3 == 1)
                somePizza.setStatus(Pizza.PizzaStatus.READY);
            else
                somePizza.setStatus(Pizza.PizzaStatus.DELIVERED);

            // add the pizza with random delivery status
            mixedDeliveryStatusPizzas.add(somePizza);
        }

        // when
        List<Pizza> filteredPizzas = Pizza.getAllUndeliveredPizzas(mixedDeliveryStatusPizzas);

        // then
        Assert.assertThat(filteredPizzas,
                everyItem(status(anyOf(is(Pizza.PizzaStatus.ORDERED),is(Pizza.PizzaStatus.READY)))));
    }

    private FeatureMatcher<Pizza, Enum> status(Matcher<Enum> matcher) {
        return new FeatureMatcher<Pizza, Enum>(matcher, "pizza delivery status", "status") {
            @Override
            protected Enum featureValueOf(Pizza actual) {
                return actual.getStatus();
            }
        };
    }


    @Test
    public void givenPizaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        EnumMap<Pizza.PizzaStatus,List<Pizza>> emap = Pizza.groupPizzaByStatus(pzList);
        Assert.assertTrue(emap.get(Pizza.PizzaStatus.DELIVERED).size() == 1);
        Assert.assertTrue(emap.get(Pizza.PizzaStatus.ORDERED).size() == 2);
        Assert.assertTrue(emap.get(Pizza.PizzaStatus.READY).size() == 1);
    }
}
