package cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver.covered;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import java.util.List;

public class MongoBasics {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        System.out.println("server connection successfully done");

        // To get all database names
       List<String> dbNames = mongoClient.getDatabaseNames();
       System.out.println(dbNames);

       // MongoCredential credential = MongoCredential.createCredential("yo", "customer", "qwerty".toCharArray());
       // MongoClient mongoClient1 = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));

        MongoDatabase dbs = mongoClient.getDatabase("customer");
        System.out.println("Connect to database successfully");
        System.out.println("Database Name: " + dbs.getName());

        MongoIterable<String> mongoTables = dbs.listCollectionNames();
        for (String collectionName: mongoTables) {
            System.out.println(collectionName);
        }


        mongoClient.close();
    }

}
