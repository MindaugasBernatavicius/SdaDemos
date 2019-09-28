package cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver._4_workingwithdocuments;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.bson.Document;

import java.util.Arrays;

public class UpdatingDocuments {
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

        // update
        // db.customer.update(
        //    { name: "Mindaugas" },
        //    { $set: { surname: "XXX" }}
        // )
        BasicDBObject searchQuery = new BasicDBObject().append("name", "Mindaugas");
        coll.updateOne(searchQuery, new Document("$set", new Document("surname", "XXX")));

        mongoClientWithAuth.close();
    }
}
