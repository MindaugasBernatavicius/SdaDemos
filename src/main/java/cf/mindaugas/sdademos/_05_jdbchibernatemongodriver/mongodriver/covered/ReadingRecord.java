package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver.covered;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;

public class ReadingRecord {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        System.out.println("OK!");

        MongoDatabase db = mongoClient.getDatabase("customer");
        System.out.println("Connect to Customer Db");
        MongoCollection<Document> collection = db.getCollection("customerInfo");

        FindIterable<Document> iterable = collection.find();
        for(Document d : iterable) {
            System.out.println(d);
            System.out.println(d.toJson());
            System.out.println(d.get("name"));
        }

        System.out.println(collection.countDocuments());
        System.out.println("====================");

        //============single
        Document singleDoc = collection.find(eq("name", "Yohan")).first();
        System.out.println(singleDoc.toJson());
        System.out.println("====================");

    //============multiple
        FindIterable<Document> iterable2 = collection.find(gt("age", 10));
        for(Document d : iterable2) {
            System.out.println(d.get("name"));
            System.out.println(d.get("age"));
        }



        mongoClient.close();
    }
}
