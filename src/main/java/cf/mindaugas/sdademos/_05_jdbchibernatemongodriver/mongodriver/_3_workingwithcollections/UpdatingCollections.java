package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver._3_workingwithcollections;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.MongoNamespace;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class UpdatingCollections {
    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        MongoDatabase dbCustomer = mongoClientWithAuth.getDatabase("customer");

        // rename the collections
        MongoCollection<Document> collection = dbCustomer.getCollection("cappedCustColl");
        collection.renameCollection(
                new MongoNamespace("customer", "cappedCustColl_renamed"));

        mongoClientWithAuth.close();
    }
}
