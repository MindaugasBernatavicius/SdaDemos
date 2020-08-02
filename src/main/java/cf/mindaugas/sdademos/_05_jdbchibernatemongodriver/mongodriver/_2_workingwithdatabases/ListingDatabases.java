package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver._2_workingwithdatabases;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

import java.util.Arrays;
import java.util.function.Consumer;

public class ListingDatabases {

    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        // 3. List all databases
        MongoIterable<String> adminCollections = mongoClientWithAuth.listDatabaseNames();
        adminCollections.forEach((Consumer<? super String>) System.out::println);

        mongoClientWithAuth.close();
    }
}
