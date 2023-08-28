package cf.mindaugas.sdademos._02_javaadvanced._17_methodreferences;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _00_MethodReferences {
    public static void _00_referencingStaticMethods(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Book"));
        products.add(new Product(50, "Sugar"));
        products.add(new Product(200, "Kakao"));

        // static method reference that must match the Comparator.compare definition
        // ... int compare(T o1, T o2); - we are mathing the comparator method
        products.sort(ProductComparator::compare);

        // method reference to an instance method
        // ... product1.compareTo(product2)
        products.sort(Product::compareTo);

        var productBrands = new ArrayList<String>();
        productBrands.add("Castco");
        productBrands.add("Apple");

        var products2 = productBrands.stream()
                .map(Product::new)
                .collect(Collectors.toList());
        System.out.println(products2);
    }

    public static void _01_referencingInstanceMethods(){
        Banana banana = new Banana("DarkYellow", 150);
        // Predicate<Banana> isBananaRipe = b -> Banana.isRipe(b);
        Predicate<Banana> isBananaRipe = Banana::isRipe;
        System.out.println(isBananaRipe.test(banana));

        System.out.println(
                ((Predicate<Banana>) Banana::isRipe)
                .test(new Banana("DarkYellow", 150))
        );
    }

    public static void main(String[] args) {
        _00_referencingStaticMethods();
        _01_referencingInstanceMethods();
    }
}

@AllArgsConstructor
class Banana {
    private String color;
    private int wightInGrams;
    static boolean isRipe(Banana b) {
        return true; // we can have better logic based on objects data
    }
}


// unfortunatelly we can't use the comparator interface,
// ... because static methods are not compliant with comparator interface
class ProductComparator {
    public static int compare(Product o1, Product o2) {
        return o1.weight - o2.weight;
    }
}

@AllArgsConstructor
@ToString
class Product implements Comparable<Product> {
    int weight;
    String label;

    public Product(String label) {
        this.label = label;
    }

    @Override
    public int compareTo(Product o) {
        return weight - o.weight;
    }
}