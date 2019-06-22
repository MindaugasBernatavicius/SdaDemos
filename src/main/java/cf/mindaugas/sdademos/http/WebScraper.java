// package cf.mindaugas.sdademos.http;
//
// import java.io.IOException;
// import java.net.URI;
// import java.net.URISyntaxException;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.util.List;
// import java.util.Map;
//
// public class WebScraper {
//     public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//
//         HttpClient httpClient = HttpClient.newBuilder()
//                 .version(HttpClient.Version.HTTP_2)  // this is the default
//                 .build();
//
//         URI target = new URI("https://www.webscraper.io/");
//         HttpRequest request = HttpRequest.newBuilder()
//                 .uri(target)
//                 .GET()
//                 .build();
//
//         HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//         System.out.println("Response status code: " + response.statusCode());
//
//         for (Map.Entry<String, List<String>> entry : response.headers().map().entrySet()) {
//             String key = entry.getKey();
//             Object value = entry.getValue();
//             System.out.println(key + ":" + value);
//         }
//
//         System.out.println("Response headers: " + response.headers());
// //        System.out.println("Response body: " + response.body());
// //        logger.info("Response status code: " + response.statusCode());
// //        logger.info("Response headers: " + response.headers());
// //        logger.info("Response body: " + response.body());
//     }
// }
