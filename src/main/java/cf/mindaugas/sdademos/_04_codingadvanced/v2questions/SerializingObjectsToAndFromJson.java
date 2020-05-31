package cf.mindaugas.sdademos._04_codingadvanced.v2questions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SerializingObjectsToAndFromJson {
    public static void main(String[] args) throws IOException {
        // 0. object serialization to json
        // ------------------------------
        // NamedEntity namedEntity = new NamedEntity("Mindaugas");
        // System.out.println(new Gson().toJson(namedEntity)); // {"name":"Mindaugas","properties":[]}

        // 1. object serialization from json
        // ------------------------------
        // String content = Files.readString(Paths.get("target\\classes\\jsonFile\\sample.json"));
        // System.out.println(content);
        //
        // ProductList productList = new Gson()
        //         .fromJson(content, ProductList.class);
        //
        // productList.getProducts().stream().forEach(System.out::println);

        // 2. Partial json file deserialization (aka targeted deserialization)
        // -------------------------------------------------------------
        // String content = Files.readString(Paths.get("target\\classes\\jsonFile\\sample.json"));
        // System.out.println(content);
        // JsonParser parser = new JsonParser();
        // JsonObject cont = parser.parse(content).getAsJsonObject();
        // JsonArray arr = cont.get("productStock").getAsJsonArray();
        // List<Product> products = new Gson().fromJson(arr, new TypeToken<List<Product>>() { }.getType());
        //
        // products.forEach(System.out::println);
        //
        // String curr = cont.get("currency").getAsString();
        // System.out.println("Currency: " +  curr);

    }
}

class ProductList {
    private List<Product> productStock;

    public List<Product> getProducts() {
        return productStock;
    }

    public void setProducts(List<Product> products) {
        this.productStock = products;
    }
}

class Product {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class NamedEntity {
    private String name;
    private String[] properties = {};

    public NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}



