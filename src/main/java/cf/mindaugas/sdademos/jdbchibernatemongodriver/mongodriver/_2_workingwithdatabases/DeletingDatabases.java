package cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver._2_workingwithdatabases;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.function.Consumer;

public class DeletingDatabases {
    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        System.out.println("Listing before dropping: ");
        mongoClientWithAuth.listDatabaseNames().forEach((Consumer<? super String>) System.out::println);
        System.out.println("-----------------");

        // Dropping a database
        MongoDatabase dbCustomer = mongoClientWithAuth.getDatabase("customer");
        dbCustomer.drop();

        System.out.println("Listing after dropping: ");
        mongoClientWithAuth.listDatabaseNames().forEach((Consumer<? super String>) System.out::println);
        System.out.println("-----------------");

        mongoClientWithAuth.close();
    }
}
