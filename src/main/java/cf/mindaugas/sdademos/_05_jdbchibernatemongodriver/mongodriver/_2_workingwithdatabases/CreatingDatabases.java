package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver._2_workingwithdatabases;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import java.util.ArrayList;
import java.util.Arrays;

public class CreatingDatabases {
    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        // 4. Creating databases: when Mongo sees that database doesn't exist, it will create it for us:
        MongoDatabase dbCustomer = mongoClientWithAuth.getDatabase("customer");
        System.out.println("Database Name: " + dbCustomer.getName());

        // ... however, if we take a look at the compass, the database was not created.
        // ... that is because mongo server only creates a database when we create a collection in it!

        MongoIterable<String> customerCollections = dbCustomer.listCollectionNames();
        System.out.println("Current _10_collections: ");
        for (String collectionName : customerCollections) {
            System.out.print(collectionName + " "); // there are no collections currently
        }

        // 5. Create a collection after checking if it already exists
        if (!collectionExists(dbCustomer, "customers"))
            dbCustomer.createCollection("customers");

        if (!dbCustomer.listCollectionNames().into(new ArrayList<>()).contains("customers"))
            dbCustomer.createCollection("customers");

        System.out.print("Collections created: " + "\n\t");
        for (String collectionName : dbCustomer.listCollectionNames()) {
            System.out.print(collectionName + " "); // there are no collections currently
        }

        mongoClientWithAuth.close();
    }

    public static boolean collectionExists(final MongoDatabase db, final String coll) {
        MongoIterable<String> collectionNames = db.listCollectionNames();
        for (final String name : collectionNames) {
            if (name.equalsIgnoreCase(coll)) return true;
        }
        return false;
    }
}
