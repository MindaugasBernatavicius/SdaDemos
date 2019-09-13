package cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver._3_workingwithcollections;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver._2_workingwithdatabases.CreatingDatabases;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;

import java.util.Arrays;

public class DeletingCollections {

    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        MongoDatabase dbCustomer = mongoClientWithAuth.getDatabase("customer");

        for (String collectionName: dbCustomer.listCollectionNames()) {
            System.out.print(collectionName + " ");
        }
        System.out.println("-----------------");

        // Delete collection
        dbCustomer.getCollection("cappedCustColl").drop();

        for (String collectionName: dbCustomer.listCollectionNames()) {
            System.out.print(collectionName + " ");
        }
        System.out.println("-----------------");

        mongoClientWithAuth.close();
    }
}
