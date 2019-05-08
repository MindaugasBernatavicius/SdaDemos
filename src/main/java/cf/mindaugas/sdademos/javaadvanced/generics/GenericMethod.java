package cf.mindaugas.sdademos.javaadvanced.generics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class GenericMethod {

    public static <T> void populateList(String filePath, List<T> listData, Class<T> listType){
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bf.readLine()) != null){
                String[] dataInLine = line.split("\\s+");
                if(listType.equals(Customer.class)) {
                    listData.add((T)new Customer(dataInLine[0], dataInLine[1]));
                } else if (listType.equals(Order.class)) {
                    listData.add((T)new Order(dataInLine[0], Double.parseDouble(dataInLine[1])));
                }
//                System.out.println(dataInLine[0] + " " + dataInLine [1]);
            }

            for (T t : listData) {
                System.out.println(t);
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if(bf != null){
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList();
        List<Order> orders = new ArrayList();

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        String filePathCustomers = ".\\target\\classes\\Customers.txt";
        String filePathOrders = ".\\target\\classes\\Orders.txt";

        populateList(filePathCustomers, customers, Customer.class);
        populateList(filePathOrders, orders , Order.class);

        System.out.println(customers.size() + " " + orders.size());
//
//        for (int i = 0; i < listData.size(); i++) {
//            for (int j = 0; j < data1.size(); j++){
//
//            }
//        }
    }
}