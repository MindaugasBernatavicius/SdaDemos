package cf.mindaugas.sdademos.javaadvanced._16_lambdas;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaExample {
    static class Person{
        public String firstName;
        public String lastName;
        public int age;
        public Person(String firstName, String lastName, int age){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    }

    static class IsAdult implements Predicate<Person>{
        @Override
        public boolean test(Person person) {
            return person.age >= 18;
        }
    }

    public static int calcSomething(Integer[] array, Function<Integer[], Integer> summarizer){
        return summarizer.apply(array);
    }

    public static void main(String[] args){
        Person person = new Person("Jimmy", "Dog", 23);
        Predicate<Person> checker = new IsAdult();
        Predicate<Person> lambda = p -> p.age >= 18;

        System.out.println(checker.test(person));
        System.out.println(lambda.test(person));

        Thread t1 = new Thread(() -> System.out.println("Hello from " + Thread.currentThread().getName()));
        t1.start();

        int[] array = {1, 5, 2};
        Thread t2 = new Thread(() -> {
            int M = 0;
            for(int number : array){
                if(M < number){
                    M = number;
                }
            }

            System.out.println("Max is: " + M);
        });

        t2.start();

        // Basic Syntax:
        // (paramaters, ...) -> { ... code ... }
        Integer[] simpleArray = {1, 2, 3, 4, 5};

        int result = calcSomething(simpleArray, (data) -> {
            int sum = 0;
            for(int number : data){
                sum += number;
            }

            return sum;
        });

        System.out.println("Result: " + result);

        Function<Integer, Integer> simpleFn = i -> i * i;
        UnaryOperator<Integer> exactlyTheSameFn = i -> i * i;
    }
}
