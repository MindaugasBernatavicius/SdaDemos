package cf.mindaugas.sdademos.jdbchibernatemongodriver.mongodriver.covered;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CreateRecord {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        System.out.println("OK!");

        MongoDatabase db = mongoClient.getDatabase("customer");
        System.out.println("Connect to Customer Db");
        MongoCollection<Document> collection = db.getCollection("customerInfo");

        //==============create JavaObj Customer
        CustomerModel new_cust = new CustomerModel("from", "Java");

        Document document = new Document();
        document.append("dsf", new_cust.getName());
        document.append("surname", new_cust.getSurname());

        try{
            collection.insertOne(document);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // Adding many documents... first put them into a list.
       /* List<Document> docmentsList = new ArrayList<Document>();
       Inside a loop{
       Document document = new Document();
        document.append("dsf", new_cust.getName());
        document.append("surname", new_cust.getSurname());
        docmentsList.add(document);
       }
        collection.insertMany(documentsList);*/


       mongoClient.close();
    }

}
