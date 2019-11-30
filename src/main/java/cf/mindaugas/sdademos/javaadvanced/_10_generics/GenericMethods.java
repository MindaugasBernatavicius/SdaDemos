package cf.mindaugas.sdademos.javaadvanced._10_generics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GenericMethods {

    // ... advanced example on how to adapt a generic method to two classes that
    // ... do not share an inheritence root
    private static <T> void populateList(String filePath, List<T> listData, Class<T> listType) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bf.readLine()) != null) {
                String[] dataInLine = line.split("\\s+");
                if (listType.equals(Customer.class)) {
                    listData.add((T) new Customer(dataInLine[0], dataInLine[1]));
                } else if (listType.equals(Order.class)) {
                    listData.add((T) new Order(dataInLine[0], Double.parseDouble(dataInLine[1])));
                }
            }

            for (T t : listData) {
                System.out.println(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ... implementing a minimum method for custom objects
    public static <T> T min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("Unable to find the minimum of an empty list");
        }

        T lowestFound = values.get(0);

        for (int i = 1; i < values.size(); i++) {
            final T element = values.get(i);
            if (comparator.compare(element, lowestFound) < 0) {
                lowestFound = element;
            }
        }

        return lowestFound;
    }

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        String filePathCustomers = ".\\target\\classes\\Customers.txt";
        String filePathOrders = ".\\target\\classes\\Orders.txt";

        populateList(filePathCustomers, customers, Customer.class);
        populateList(filePathOrders, orders, Order.class);

        System.out.println(customers.size() + " " + orders.size());


        // ... minimizer


        // ... generic bubbleSort
    }
}

class Customer {
    Customer(String s, String ss) { }
}

class Order {
    Order(String s, Double d) { }
}