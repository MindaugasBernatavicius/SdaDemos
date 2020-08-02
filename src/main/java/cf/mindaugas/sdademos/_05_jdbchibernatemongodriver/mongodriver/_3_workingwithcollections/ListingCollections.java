package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver._3_workingwithcollections;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class ListingCollections {
    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        // listing collection names
        MongoDatabase dbCustomer = mongoClientWithAuth.getDatabase("customer");
        for (String collectionName: dbCustomer.listCollectionNames()) {
            System.out.println(collectionName + " ");
        }

        // listing collections with their information
        for (Document collectionInfo: dbCustomer.listCollections()) {
            System.out.println("-------------");
            System.out.println(collectionInfo.toJson());
            System.out.println("-------------");
        }

        mongoClientWithAuth.close();
    }
}
