package cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver._4_workingwithdocuments;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver._2_workingwithdatabases.CreatingDatabases;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import org.bson.Document;

import java.util.Arrays;

public class CreatingDocuments {

    public static void main(String[] args) {
        MongoCredential credential = MongoCredential
                .createScramSha1Credential("root", "admin", "root".toCharArray());

        MongoClient mongoClientWithAuth = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                        .credential(credential).build());

        MongoCollection coll = mongoClientWithAuth
                .getDatabase("customer").getCollection("customer");

        // insert one
        Document document = new Document()
                .append("name", "Mindaugas")
                .append("surname", "Bernatavičius");
        coll.insertOne(document);

        // TODO :: insert one with options

        // TODO :: insert many

        mongoClientWithAuth.close();
    }
}
