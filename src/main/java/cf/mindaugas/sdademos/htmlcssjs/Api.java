package cf.mindaugas.sdademos.htmlcssjs;

import cf.mindaugas.sdademos.http.model.User;
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

public class Api {
    public static void main(String[] args) {

        // 0. Generating simple HTML
        get("/hw", (request, response) -> {
            System.out.println(">>>>>>>>>>>>>>>>>");
            return "<p>Hello world!</p>";
        });

        // 1. Return HTML from file
        get("/form", (request, response) -> {
            System.out.println("We reached the form w/ IP:" + request.ip());
            System.out.println("Request body: " + request.body());
            // Reference to the HTML file containing the form
            String htmlFile = "target\\classes\\html\\spark_form\\index.html";
            // Converting the contents of the file
            String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFile)), StandardCharsets.UTF_8);
            // System.out.println(htmlContent);
            return htmlContent;
        });

        post("/form", (request, response) -> {
            System.out.println("We reached the form w/ IP:" + request.ip());
            System.out.println("Request body: " + request.body());
            // Reference to the HTML file containing the form
            String htmlFile = "target\\classes\\html\\ex1_forms\\index.html";
            // Converting the contents of the file
            String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFile)), StandardCharsets.UTF_8);
            // System.out.println(htmlContent);
            return htmlContent;
        });

        post("/submit-form", (request, response) -> {
            // // 0. Obtaining the input
            // System.out.println(request.body());
            // System.out.println(URLDecoder.decode(request.body(), "UTF-8"));
            // return "<h4>Success</h4>";

            // // 1. Processing the user input
            // String[] userinfo = request.body().split("&");
            // for (String pieceOfInfo: userinfo) {
            //     System.out.println(pieceOfInfo);
            // }
            // return "<h4>Success</h4>";

            // 2. Return data as html <UL>
            // <ul>
            //     <li>First element</li>
            //     <li>Second element</li>
            // </ul>
            String[] userinfo = request.body().split("&");
            String ulopen = "<ul>";
            String ulclose = "</ul>";
            for (String pieceOfInfo: userinfo) {
                ulopen += "<li>" + pieceOfInfo.split("=")[1] + "</li>";
            }
            return ulopen + ulclose;
        });

        // Excercise: create a form that would add data into the list above - simple html
        List<User> users = new ArrayList();
        users.add(new User(1, "Mindaugas", "B.", "mb@gmail.com"));
        users.add(new User(2, "Jonas", "J.", "jonasj@yahoo.com"));
        users.add(new User(3, "Petras", "P.", "petrasp@yahoo.com"));


        get("/add-user-form", (request, response) -> {
            String htmlFile = "target\\classes\\htmlcssjs_excercise\\index-plain.html";
            String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFile)), StandardCharsets.UTF_8);
            // System.out.println(htmlContent);
            return htmlContent;
        });

        post("/add-user-action", (request, response) -> {
            String firstname = "";
            String initial = "";
            String email = "";

            String[] userInfo = request.body().split("&");
            System.out.println(Arrays.toString(userInfo));
            for (String userProp : userInfo) {
                if ((userProp.split("="))[0].equals("firstname")) {
                    firstname = userProp.split("=")[1];
                } else if (userProp.split("=")[0].equals("initial")) {
                    initial = userProp.split("=")[1];
                } else if (userProp.split("=")[0].equals("email")) {
                    email = URLDecoder.decode(userProp.split("=")[1], "UTF-8");
                } else {
                    // error
                }
            }

            User userToAdd = new User(users.size() + 1, firstname, initial, email);
            users.add(userToAdd);
            response.redirect("/users");
            // return new Gson().toJson(users);

            // https://github.com/perwendel/spark/issues/322
            return null;
        });


        // TODO :: add the /users path that will render all the users into an HTML table
    }
}

// public class Api {
//     public static void main(String[] args) {
//
//         // https://stackoverflow.com/questions/38528305/java-spark-framework-enable-logging
//         Spark.exception(Exception.class, (exception, request, response) -> {
//             exception.printStackTrace();
//         });
//
//         List<User> users = new ArrayList();
//         users.add(new User(1, "Mindaugas", "B.", "mb@gmail.com"));
//         users.add(new User(2, "Jonas", "J.", "jonasj@yahoo.com"));
//         users.add(new User(3, "Petras", "P.", "petrasp@yahoo.com"));
//
//         // Submitting an HTML form
//         // http://192.168.8.101:4567/submit-form or http://localhost:4567/submit-form
//         // C:\Users\bernam\Desktop\SdaDemos\target\classes\html\ex1_forms\index.html
//         get("/form", (request, response) -> {
//
//             System.out.println("We reached the form!");
//
//             // Reference to the HTML file containing the form
//             String htmlFile = "target\\classes\\html\\ex1_forms\\index.html";
//
//             // Converting the contents of the file
//             String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFile)), StandardCharsets.UTF_8);
//
//             // System.out.println(htmlContent);
//             return htmlContent;
//         });
//
//         post("/submit-form", (request, response) -> {
//             // 0.
//             System.out.println(request.body());
//             System.out.println(URLDecoder.decode(request.body(), "UTF-8"));
//
//             // return "<h4>Success</h4>";
//
//             // 1.
//             // String[] userinfo = request.body().split("&");
//             // for (String pieceOfInfo: userinfo) {
//             //     System.out.println(pieceOfInfo);
//             // }
//             // return "<h4>Success</h4>";
//
//             // 2. Return data as html <UL>
//             // <ul>
//             //     <li>First element</li>
//             //     <li>Second element</li>
//             // </ul>
//             String[] userinfo = request.body().split("&");
//             String ulopen = "<ul>";
//             String ulclose = "</ul>";
//             for (String pieceOfInfo: userinfo) {
//                 ulopen += "<li>" + pieceOfInfo.split("=")[1] + "</li>";
//             }
//             return ulopen + ulclose;
//         });
//
//         // Excercise: create a form that would add data into the list above - simple html
//         get("/add-user-form", (request, response) -> {
//             String htmlFile = "target\\classes\\htmlcssjs_excercise\\index-plain.html";
//             String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFile)), StandardCharsets.UTF_8);
//             // System.out.println(htmlContent);
//             return htmlContent;
//         });
//
//         post("/add-user-action", (request, response) -> {
//             String firstname = "";
//             String initial = "";
//             String email = "";
//
//             String[] userInfo = request.body().split("&");
//             System.out.println(Arrays.toString(userInfo));
//             for (String userProp: userInfo) {
//                 if((userProp.split("="))[0].equals("firstname")) {
//                     firstname = userProp.split("=")[1];
//                 } else if (userProp.split("=")[0].equals("initial")){
//                     initial = userProp.split("=")[1];
//                 } else if (userProp.split("=")[0].equals("email")){
//                     email = URLDecoder.decode(userProp.split("=")[1],"UTF-8");
//                 } else {
//                     // error
//                 }
//             }
//
//             User userToAdd = new User(users.size() + 1, firstname, initial, email);
//             users.add(userToAdd);
//             response.redirect("/users");
//             // return new Gson().toJson(users);
//
//             // https://github.com/perwendel/spark/issues/322
//             return null;
//         });
//         // ... add some simple CSS to the form and the table rendered:
//         get("/add-user-form-css", (request, response) -> {
//             String htmlFile = "target\\classes\\htmlcssjs_excercise\\index.html";
//             String htmlContent = new String(Files.readAllBytes(Paths.get(htmlFile)), StandardCharsets.UTF_8);
//             // System.out.println(htmlContent);
//             return htmlContent;
//         });
//
//         // ... now use bootstrap and jQuery ajax
//     }
// }