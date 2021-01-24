package cf.mindaugas.sdademos.angularbackend;

import com.google.gson.Gson;
import spark.Filter;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class ProductsRestEndpoint {
    public static void main(String[] args) {
        // root is 'src/main/resources', so put files in 'src/main/resources/angular'
        staticFiles.location("/angular"); // Static files
        get("/_", (req, res) -> "OK"); // fake route, needed to start Spark

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Shoes", 550, 2.50, 3.75));
        products.add(new Product(2, "Dress", 1550, 12.50, 2.25));
        products.add(new Product(3, "Pants", 50, 22.50, 4.25));
        products.add(new Product(4, "Socks", 590, 1.99, 1.25));

        // get all products
        get("/products", (req, res) -> new Gson().toJson(products));

        // get a single product
        get("/products/:id", (req, res)
                -> new Gson().toJson(products.stream()
                .filter(p -> p.id == Integer.parseInt(req.params(":id")))
                .findFirst()
                .get()
        ));

        // allowing the pre-flight request
        options("/*", (req, res) -> {
            res.status(200);
            return "OK";
        });

        // update existing product
        put("/products/:id", (req, res) -> {
            Product updatedProduct = new Gson().fromJson(req.body(), Product.class);
            products.get(Integer.parseInt(req.params(":id")) - 1).title = updatedProduct.title;
            products.get(Integer.parseInt(req.params(":id")) - 1).count = updatedProduct.count;
            products.get(Integer.parseInt(req.params(":id")) - 1).price = updatedProduct.price;
            products.get(Integer.parseInt(req.params(":id")) - 1).rating = updatedProduct.rating;
            res.status(200);
            return "{\"status\": \"success\"}";
        });

        before((Filter) (request, response) -> {
            System.out.println("Received request from " + request.raw().getMethod());
        });

        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Methods", "*");
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Headers", "*");
        });
    }
}

class Product {
    public int id;
    public String title;
    public int count;
    public double price;
    public double rating;

    public Product(int id, String title, int count, double price, double rating) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.price = price;
        this.rating = rating;
    }
}
