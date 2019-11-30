package cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver.covered;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Updt_Del_Records {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        System.out.println("OK!");

        MongoDatabase db = mongoClient.getDatabase("customer");
        System.out.println("Connect to Customer Db");
        MongoCollection<Document> collection = db.getCollection("customerInfo");


//==================HOW TO RUN THIS CLASS
/*
 First run the single Updt... see the result from ReadingRecord
 then comment it out again.
 now uncomment & run single Del... see the result from ReadingRecord
 then comment it out again.

 DONT run the multiples unless there is more data
*/
//==================

        //============single Update
//        collection.updateOne(eq("name", "from"), new Document("$set", new Document("age", 55)));

        //=======single Delete
//        collection.deleteOne(eq("name", "from"));


/*
        //=========multiple Updates
        //UpdateResult updateResult = collection.updateMany(lt("age", 90), inc("age", 10));
        //System.out.println(updateResult.getModifiedCount());

        //=======multiple Deletes
        //DeleteResult deleteResult = collection.deleteMany(gte("age", 10));
        //System.out.println(deleteResult.getDeletedCount());
*/
        mongoClient.close();
    }
}
