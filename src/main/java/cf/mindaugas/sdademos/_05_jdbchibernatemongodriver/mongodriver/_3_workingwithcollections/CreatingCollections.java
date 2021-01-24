package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver._3_workingwithcollections;

import cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver._2_workingwithdatabases.CreatingDatabases;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;

import java.util.Arrays;

public class CreatingCollections {
    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        MongoDatabase dbCustomer = mongoClientWithAuth.getDatabase("customer");

        // If you are not specifying these options, you do not need to explicitly create the collection
        // since MongoDB creates new collections when you first store data for the collections.
        if (!CreatingDatabases.collectionExists(dbCustomer, "cappedCustColl"))
            dbCustomer.createCollection("cappedCustColl",
                    new CreateCollectionOptions().capped(true).sizeInBytes(1000L));

        for (String collectionName : dbCustomer.listCollectionNames()) {
            System.out.print(collectionName + " "); // there are no collections currently
        }

        mongoClientWithAuth.close();
    }
}
