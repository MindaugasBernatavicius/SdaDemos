package cf.mindaugas.sdademos._02_javaadvanced._14_io;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _06_Json2Xml_Custom_NotFinished {
    public static void main(String[] args) {
        String jsonFilePath = "input.json";
        String xmlFilePath = "output.xml";

        try {
            // Read JSON file as a String
            String jsonString = new String(
                    Files.readAllBytes(
                            Paths.get(jsonFilePath)));

            // Parse JSON string to a JsonObject
            var jsonObject = (new JsonParser()).parse(jsonString);
            var xmlString = jsonObject.isJsonObject()
                    ? convertToXml(jsonObject.getAsJsonObject())
                    : convertToXml(jsonObject.getAsJsonArray());

            // Write XML string to file
            FileWriter fileWriter = new FileWriter(xmlFilePath);
            fileWriter.write(xmlString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            System.out.println("Invalid JSON syntax.");
        }
    }

    private static String convertToXml(JsonElement jsonElement) {
        var sb = new StringBuilder();
        if(jsonElement.isJsonObject()){
            for(var entry : jsonElement.getAsJsonObject().entrySet()) {
                if (entry.getValue().isJsonObject())
                    sb.append(convertToXml(entry.getValue().getAsJsonObject()));
                else if (entry.getValue().isJsonArray())
                    sb.append("<").append(entry.getKey()).append(">\n")
                        .append(convertToXml(entry.getValue().getAsJsonArray()))
                    .append("</").append(entry.getKey()).append(">");
                else
                    sb.append("<").append(entry.getKey()).append(">")
                        .append(entry.getValue().getAsString())
                    .append("</").append(entry.getKey()).append(">\n");
            }
        } else {
            for(var entry : jsonElement.getAsJsonArray()) {
                if (entry.isJsonObject()) sb.append("\t").append(convertToXml(entry.getAsJsonObject()));
                else if (entry.isJsonArray()) sb.append("\t").append(convertToXml(entry.getAsJsonArray()));
                else sb.append("\t").append("<item>").append(entry).append("</item>\n");
            }
        }

        return sb.toString();
    }
}
