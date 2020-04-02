package cf.mindaugas.sdademos.http;

import cf.mindaugas.sdademos.http.model.User;
import com.google.gson.Gson;
import spark.Spark;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

// Ref: https://www.baeldung.com/spark-framework-rest-api
// Docs: http://sparkjava.com/documentation#getting-started

public class RestApi {
    public static void main(String[] args) {
        // https://stackoverflow.com/questions/38528305/java-spark-framework-enable-logging
        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });

        List<User> users = new ArrayList();
        users.add(new User(1, "Mindaugas", "B.", "mb@gmail.com"));
        users.add(new User(2, "Jonas", "J.", "jonasj@yahoo.com"));
        users.add(new User(3, "Petras", "P.", "petrasp@yahoo.com"));

        // http://localhost:4567
        // http://localhost:4567/hello
        // (req, res) -> "Hello, world" - specifies the logic
        // that will be executed when the user issues a GET rew. to /hello
        get("/hello", (req, res) -> {
            return "Hello, world";
        });

        // http://localhost:4567/hello/mindaugas
        // https://www.urlencoder.org/
        // bernam@XXXXBERNAML1C MINGW64 ~/Desktop/SdaDemos (master)
        // $ curl http://localhost:4567/hello/%D0%BC%D0%B8%D0%BD%D0%B4%D0%B0%D1%83%D0%B3%D0%B0%D1%81 -s
        // Hello, миндаугас
        get("/hello/:name", (req, res) -> {
            System.out.println("Called with:" + req.params(":name"));
            // Creating the filter
            String pattern = "(Microsoft).+?";
            if((req.params(":name")).toLowerCase().matches(pattern))
                return "Bad boy!";
            return "Hello, "+ req.params(":name");
        });

        post("/hello-content-type", (request, response) -> {
            // 0.
            // return request.body();

            // 1.
            // if(request.body().equals("username=mindaugas"))
            //     return "Success";
            // else
            //     return "Failure";

            // 2.
            if(!request.headers("content-type").equals("application/json"))
                return "Failure";
            return "Success";
        });

        get("/hello-html", (req, res) -> "" +
                "<!DOCTYPE html>" +
                "   <head>" +
                "       <title>My webapp</title>" +
                "   </head>" +
                "   <body>" +
                "       <h1 style=\"color:blue;\">Hello, world</h1>" +
                "       <img src=\"data:image/gif;base64,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\">" +
                "   </body>" +
                "</html>");

        // REST API
        // get("/users", (request, response) -> new Gson().toJson(users));

        // HETEOAS
        get("/users", (request, response) -> {
            response.type("application/hal+json");
            List<String> links;
            for (User user: users) {
                links = new ArrayList();
                links.add(request.url() + "/" + user.getId());
                user.setLinks(links);
            }
            return new Gson().toJson(users);
            // We could potentially add structure like this:
            // "self": {
            //     "href": "http://localhost:8080/spring-security-rest/api/customers/10A"
            // },
            // "allOrders": {
            //     "href": "http://localhost:8080/spring-security-rest/api/customers/10A/orders"
            // }
        });

        get("/users/:id", (request, response) -> {
            User userToReturn = null;
            for(User user : users){
                if(user.getId() == Integer
                        .parseInt(request.params(":id"))) {
                    userToReturn = user;
                    break;
                }
            }
            return new Gson().toJson(userToReturn);
        });

        // put("/users/:id", (request, response) -> {
        //     //...
        // });
        // delete("/users/:id", (request, response) -> {
        //     //...
        // });
        // options("/users/:id", (request, response) -> {
        //     //...
        // });
    }
}