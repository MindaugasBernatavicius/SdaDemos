package cf.mindaugas.sdademos._01_codingfundamentals.v2_exercises._03_oop;

public class IteratingOverArrayOfObjects {
    public static void main(String[] args) {
        // Initialize an array of objects
        // ... the code below can be understood using
        // ... int[] intArr = {1, 2, 4}; as an analogy
        Product[] products = {
                new Product(1, "Shoes", 2.2),
                new Product(2, "Boxes", 2.1),
                new Product(3, "Plates", 0.1),
                new Product(4, "Pants", 22.1)
        };

        // another way
        Product[] products2 = new Product[4];
        for (int i = 0; i < products2.length; i++) {
            products2[i] = new Product(i, "Shoes", i * (i + 0.01));
        }

        // print the objects
        for (int i = 0; i < products.length; i++) {
            System.out.println("{ id: " + products[i].getId()
                    + ", name: " + products[i].getName()
                    + ", weight: " + products[i].getWeight() + " }");
        }
    }
}

class Product {
    private int id;
    private String name;
    private double weight;

    public Product(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
